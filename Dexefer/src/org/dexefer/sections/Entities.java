package org.dexefer.sections;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dexefer.annotations.DXFSubElements;
import org.dexefer.annotations.DXFTerminator;
import org.dexefer.entities.Entity;

import org.dexefer.DXFElement;

/**
 * Represents an <c>ENTITIES</c> section in the DXFFile.
 * 
 * @author luisro
 */
@DXFTerminator("ENDSEC")
public class Entities implements DXFElement, Iterable<Entity>  {
	@DXFSubElements
	List<Entity> entityList;
	
	public Entities() {
		
		entityList = new ArrayList<Entity>();
	}
	
	/**
	 * Adds an entity to the collection.
	 * @param entity
	 * @return The calling object.
	 */
	public Entities add(Entity entity) {
		entityList.add(entity);
		return this;
	}
	
	/**
	 * Removes the given entity.
	 * @param entity The entity to be removed.
	 * @return The calling object.
	 */
	public Entities remove(Entity entity) {
		entityList.remove(entity);
		return this;
	}
	
	/**
	 * Removes all entities.
	 * @return The calling object.
	 */
	public Entities clear() {
		
		entityList.clear();
		return this;
	}

	/**
	 * Allows iteration on the entities.
	 */
	@Override
	public Iterator<Entity> iterator() {
		return entityList.iterator();
	}

	
}
