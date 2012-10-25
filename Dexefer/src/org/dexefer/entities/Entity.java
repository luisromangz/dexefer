package org.dexefer.entities;

import org.dexefer.DXFElement;
import org.dexefer.annotations.DXFProperty;

/**
 * Defines the basic info of an DXF entity.
 * @author luisro
 *
 */
public abstract class Entity implements DXFElement {
	@DXFProperty(5)
	Integer handle;
	
	@DXFProperty(8)
	String layerName;
	
	@DXFProperty(6)
	String lineTypeName = "BYLAYER";
	
	@DXFProperty(62)
	String colorNumber = "BYLAYER";
	
	@DXFProperty(48)
	Double lineTypeScale = 1.0;

}
