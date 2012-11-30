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

import org.dexefer.DXFElement;
import org.dexefer.annotations.DXFProperty;

/**
 * Defines the basic info of an DXF entity.
 * @author luisro
 *
 */
public abstract class Entity implements DXFElement {
	@DXFProperty(5)
	private
	Integer handle;
	
	@DXFProperty(100)
	private String classMarker="AcDbEntity";
	
	@DXFProperty(8)
	private
	String layerName = "Default";
	
	@DXFProperty(6)
	private
	String lineTypeName = "BYLAYER";
	
	@DXFProperty(62)
	private
	int colorNumber = 0;
	
	@DXFProperty(48)
	private
	Double lineTypeScale = 1.0;

	public Integer getHandle() {
		return handle;
	}
	
	public String getClassMarker(){
		return classMarker;
	}

	public void setHandle(Integer handle) {
		this.handle = handle;
	}

	public String getLayerName() {
		return layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public String getLineTypeName() {
		return lineTypeName;
	}

	public void setLineTypeName(String lineTypeName) {
		this.lineTypeName = lineTypeName;
	}

	public int getColorNumber() {
		return colorNumber;
	}

	public void setColorNumber(int colorNumber) {
		this.colorNumber = colorNumber;
	}

	public Double getLineTypeScale() {
		return lineTypeScale;
	}

	public void setLineTypeScale(Double lineTypeScale) {
		this.lineTypeScale = lineTypeScale;
	}
	
	public abstract String getEntityMarker();

}
