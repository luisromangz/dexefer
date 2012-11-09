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
package org.dexefer.sections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.dexefer.annotations.DXFSubElements;
import org.dexefer.annotations.DXFTerminator;
import org.dexefer.annotations.DXFElementType;
import org.dexefer.tables.Table;

import org.dexefer.DXFElement;

/**
 * Represents an <c>ENTITIES</c> section in the DXFFile.
 * 
 * @author luisro
 */
@DXFElementType("SECTION")
@DXFTerminator("ENDSEC")
public class Tables implements DXFElement, Iterable<Table>  {
	@DXFSubElements
	List<Table> tables;
	
	public Tables() {
		
		tables = new ArrayList<Table>();
	}
	
	/**
	 * Adds a table to the collection.
	 * @param table
	 * @return The calling object.
	 */
	public Tables add(Table table) {
		tables.add(table);
		return this;
	}
	
	/**
	 * Removes the given entity.
	 * @param entity The entity to be removed.
	 * @return The calling object.
	 */
	public Tables remove(Table entity) {
		tables.remove(entity);
		return this;
	}
	
	/**
	 * Removes all entities.
	 * @return The calling object.
	 */
	public Tables clear() {
		
		tables.clear();
		return this;
	}

	/**
	 * Allows iteration on the entities.
	 */
	@Override
	public Iterator<Table> iterator() {
		return tables.iterator();		
	}

	/**
	 * Returns an unmodifiable version of the entities.
	 */
	public Iterable<Table> getTables(){
		return Collections.unmodifiableCollection(tables);
	}
}
