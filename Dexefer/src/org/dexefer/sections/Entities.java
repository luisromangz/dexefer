package org.dexefer.sections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.dexefer.annotations.DXFSubElements;
import org.dexefer.annotations.DXFTerminator;
import org.dexefer.annotations.DXFElementType;
import org.dexefer.entities.Entity;

import org.dexefer.DXFElement;

/**
 * Represents an <c>ENTITIES</c> section in the DXFFile.
 * 
 * @author luisro
 */
@DXFElementType("SECTION")
@DXFTerminator("ENDSEC")
public class Entities implements DXFElement, Iterable<Entity>  {
	@DXFSubElements
	List<Entity> entities;
	
	public Entities() {
		
		entities = new ArrayList<Entity>();
	}
	
	/**
	 * Adds an entity to the collection.
	 * @param entity
	 * @return The calling object.
	 */
	public Entities add(Entity entity) {
		entities.add(entity);
		return this;
	}
	
	/**
	 * Removes the given entity.
	 * @param entity The entity to be removed.
	 * @return The calling object.
	 */
	public Entities remove(Entity entity) {
		entities.remove(entity);
		return this;
	}
	
	/**
	 * Removes all entities.
	 * @return The calling object.
	 */
	public Entities clear() {
		
		entities.clear();
		return this;
	}

	/**
	 * Allows iteration on the entities.
	 */
	@Override
	public Iterator<Entity> iterator() {
		return entities.iterator();		
	}

	/**
	 * Returns an unmodifiable version of the entities.
	 */
	public Iterable<Entity> getEntities(){
		return Collections.unmodifiableCollection(entities);
	}
}
