/*
   Copyright 2012 Luis Román Gutiérrez

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.dexefer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

import org.dexefer.annotations.DXFElementType;
import org.dexefer.annotations.DXFPointProperty;
import org.dexefer.annotations.DXFProperty;
import org.dexefer.annotations.DXFSubElements;
import org.dexefer.annotations.DXFTerminator;
import org.dexefer.annotations.DXFValueMap;
import org.dexefer.sections.Entities;
import org.dexefer.sections.Header;
import org.dexefer.sections.Tables;

/**
 * Allows defining the structure of a DXF file.
 * 
 * @author luisro
 */
public class DXFFile {
	
	Header header;
	Entities entities;
	Tables tables;
	
	/**
	 * Creates an empty (without entities) DXFFile instance.
	 */
	public DXFFile() {
		header = new Header();
		entities = new Entities();
		tables = new Tables();
	}
	
	/**
	 * Gets the DXF file's header.
	 * @return
	 */
	public Header getHeader(){
		return header;
	}
	
	/**
	 * Returns the entities contained in the DXF file.
	 * @return
	 */
	public Entities getEntities() {
		return entities;
	}
	
	/**
	 * Returns the tables contained in the DXF file.
	 * @return
	 */
	public Tables getTables(){
		return tables;	
	}
	
	public void write(OutputStream output) throws IOException {
		DXFWriter writer = new DXFWriter(output);
		
		writer.writeEntry(999, "Dexefer");
		
		//writeElement(writer, header);
		//writeElement(writer,tables);
		writeElement(writer, entities);
		
		writer.writeEntry(0, "EOF");		
		writer.close();
	}
	
	private void writeElement(DXFWriter writer, DXFElement element) throws IOException {
		Class<? extends DXFElement> eClass = element.getClass();
		String className = eClass.getSimpleName().toUpperCase();
		DXFElementType elementTypeA = eClass.getAnnotation(DXFElementType.class);
		if(elementTypeA==null) {
			writer.writeEntry(0, className);	
		} else if(elementTypeA.shown()){
			writer.writeEntry(0, elementTypeA.value());
			if(elementTypeA.showClassName()){
				writer.writeEntry(2, className);
			}
		}	
		
		writeElementFields(writer, element, eClass);
		
		DXFTerminator terminatorA = eClass.getAnnotation(DXFTerminator.class);
		if(terminatorA!=null) {
			// We write the element's terminator
			writer.writeEntry(0, terminatorA.value());
		}
	}
	
	private void writeElementFields(
			DXFWriter writer, 
			DXFElement element,
			Class<? extends DXFElement> eClass) 
					throws IOException {
		
		if(DXFElement.class.isAssignableFrom(eClass.getSuperclass())) {
			// If the parent class is a DXFElement too, we add the fields declared there first.
			writeElementFields(writer, element, (Class<? extends DXFElement>) eClass.getSuperclass());
		}
		
		// We iterate the fields.
		for(Field f : eClass.getDeclaredFields()) {
			int nonNullProperties = 0;
			DXFPointProperty pointPropertyA = f.getAnnotation(DXFPointProperty.class);
			if(pointPropertyA!=null){
				nonNullProperties++;
			}
			DXFProperty propertyA = f.getAnnotation(DXFProperty.class);
			if(propertyA!=null) {
				nonNullProperties++;
			}
			DXFSubElements subElementsA = f.getAnnotation(DXFSubElements.class);
			if(subElementsA!=null){
				nonNullProperties++;
			}
			DXFValueMap valueMapA = f.getAnnotation(DXFValueMap.class);
			if(valueMapA!=null){
				nonNullProperties++;				
			}
			
			if(nonNullProperties==0){
				continue;
			} else if(nonNullProperties>1) {
				throw new IllegalStateException(String.format("Field '%s' in class '%s' cannot have more than one annotation defining the field at the same time."));
			}
			
			
			 if(propertyA!=null) {
				// We write the property's value, if it's not null (optional).
				Object value =  getFieldValue(eClass,f, element);
				if(value!=null){
					int code = propertyA.value();
					writer.writeEntry(code,value.toString());
				}
			} else if (subElementsA!=null) {				
				Object collection = getFieldValue(eClass,f,  element);
				if(!Iterable.class.isInstance(collection)){
					throw new IllegalStateException(String.format("The field '%s' is not Iterable so it cannot use the @DXFSubElements annotation."));
				}
				
				for(DXFElement subElement : (Iterable<? extends DXFElement>)collection){
					writeElement(writer, subElement);
				}
			} else if(pointPropertyA!=null){
				Object point = getFieldValue(eClass,f,  element);
				if(point==null){
					continue;
				}
				
				if(!DXFPoint.class.isInstance(point)){
					throw new IllegalStateException(String.format("The field '%s' is not a DXFPoint so it cannot be applied the @DXFPointProperties annotation."));
				}
				
				DXFPoint p = (DXFPoint)point;
				writer.writeEntry(pointPropertyA.xCode(), p.X+"");
				writer.writeEntry(pointPropertyA.yCode(), p.Y+"");
				if(pointPropertyA.zCode()>=0){
					// If negative, it means that it doesn't need to be set.					
					writer.writeEntry(pointPropertyA.zCode(), p.Z+"");
				}
			} else if(valueMapA!=null) {
				Object map = getFieldValue(eClass,f,element);
				if(!Map.class.isInstance(map)) {
					throw new IllegalStateException(String.format(
							"The field '%s' is not a Map so it cannot be applied the @DXFValueMap annotation."));
				}
				
				Map<Integer,Object> m = (Map<Integer,Object>) map;
				for(Entry<Integer, Object> e: m.entrySet()){
					writer.writeEntry(e.getKey(), e.getValue().toString());
				}
			}
		}		
	}

	private Object getFieldValue(Class<? extends DXFElement> eClass, Field field,  DXFElement element) {
		
		try {
			return field.get(element);
		} catch (IllegalArgumentException e1) {
			throw new RuntimeException(e1);			
		} catch (IllegalAccessException e1) {
			// We do nothing.
		}
		
		String prefix = "get";		
		
		String getterName = prefix+ field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1);
		Method method;
		try{
			method = eClass.getMethod(getterName);
		} catch(NoSuchMethodException e) {
			throw new IllegalStateException(
					String.format("Field '%s' is not public and has no getter method.", field.getName()), e);
		}
		
		Object value;
		try {
			value = method.invoke(element);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);			
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(
					String.format("There is no public getter for field '%s'.", field.getName()), e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		return value;
	}
}
