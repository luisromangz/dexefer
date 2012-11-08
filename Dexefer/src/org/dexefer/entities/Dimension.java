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
package org.dexefer.entities;

import org.dexefer.DXFPoint;
import org.dexefer.annotations.DXFPointProperty;
import org.dexefer.annotations.DXFProperty;

public abstract class Dimension extends Entity {
	
	
	/**
	 * The string used to 
	 */
	public static final String MEASUREMENT_TEXT="<>";
	
	@DXFProperty(100)
	private String marker="AcDbDimension";
	
	/**
	 * The point that defines the position of the dimension line.
	 */
	@DXFPointProperty(xCode=10,yCode=20,zCode=30)
	protected DXFPoint definitionPoint;
	
	/**
	 * The point that defines the position of the text's center.
	 */
	@DXFPointProperty(xCode=11,yCode=21,zCode=31)
	private DXFPoint textMiddlePoint;
	
	/**
	 * Must be set in subclasses.
	 */
	@DXFProperty(70)
	protected int dimensionType;
	
	/**
	 * Attachment type. 
	 */
	@DXFProperty(71)
	private int attachmentType=5;
	
	/**
	 * The dimension displayed text. Use MEASUREMENT_TEXT combined with suffixes/prefixes to get desired text.
	 */
	@DXFProperty(1)
	private String dimensionText=MEASUREMENT_TEXT;

	public Dimension() {
		
	}
	
	public DXFPoint getDefinitionPoint() {
		return definitionPoint;
	}
	

	public DXFPoint getTextMiddlePoint() {
		return textMiddlePoint;
	}

	
	public int getDimensionType() {
		return dimensionType;
	}


	public String getDimensionText() {
		return dimensionText;
	}


	public void setDimensionText(String dimensionText) {
		this.dimensionText = dimensionText;
	}

	public String getMarker() {
		return marker;
	}


	public int getAttachmentType(){
		return attachmentType;
	}
	
}
