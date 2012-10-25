package org.dexefer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.management.RuntimeErrorException;

import org.dexefer.annotations.DXFProperty;
import org.dexefer.annotations.DXFSubElements;
import org.dexefer.sections.Entities;
import org.dexefer.DXFElement;

/**
 * Allows defining the structure of a DXF file.
 * 
 * @author luisro
 */
public class DXFFile {
	
	Entities entities;
	
	/**
	 * Creates an empty (without entities) DXFFile instance.
	 */
	public DXFFile() {
		entities = new Entities();
	}
	
	/**
	 * Returns the entities contained in the DXF file.
	 * @return
	 */
	public Entities getEntities() {
		return entities;
	}
	
	public void write(OutputStream output) throws IOException {
		DXFWriter writer = new DXFWriter(output);
		
		writeElement(writer, entities);
		
		writer.writeEntry(0, "EOF");		
		writer.close();
	}
	
	private void writeElement(DXFWriter writer, DXFElement element) throws IOException {
		Class<? extends DXFElement> eClass = element.getClass();
		writer.writeEntry(0, eClass.getName().toUpperCase());	
		
		
		for(Field f : element.getClass().getFields()) {
			// We iterate the fields.
			DXFProperty property = f.getAnnotation(DXFProperty.class);
			DXFSubElements subElements = f.getAnnotation(DXFSubElements.class);
			
			if(property!=null && subElements!=null) {
				throw new IllegalStateException(String.format("Field '%s' in class '%s' cannot have annotations DXFProperty and DXFSubElements at the same time."));				
			} else  if(property!=null) {
				writer.writeEntry(property.value(), getFieldValue(f, element));
			}
		}
	}
	
	private String getFieldValue(Field field, DXFElement element) {
		String getterName = field.getName();
		
		Method method;
		try{
			method = element.getClass().getMethod(getterName);
		} catch(NoSuchMethodException e) {
			throw new IllegalStateException(
					String.format("There is no getter for field '%s'.", field.getName()), e);
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
		
		return value.toString();
	}
}
