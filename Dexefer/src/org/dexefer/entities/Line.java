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

/**
 * Defines a drawing's Line entities.
 * @author luisro
 */
public class Line extends Entity {
	
	
	@DXFProperty(39)
	private Integer thickness;
	
	@DXFPointProperty(xCode=10,yCode=20,zCode=30)
	private DXFPoint start;
	@DXFPointProperty(xCode=11,yCode=21,zCode=31)
	private DXFPoint end;
	
	/**
	 * Creates a new Line element.
	 * @param p0 The line's start point.
	 * @param p1 The line's end point.
	 */
	public Line(DXFPoint p0, DXFPoint p1) {
		this.start=p0;
		this.end =p1;
		
	}
	
	public Integer getThickness() {
		return thickness;
	}
	public void setThickness(Integer thickness) {
		this.thickness = thickness;
	}
	
	public DXFPoint getStart() {
		return start;
	}
	
	public DXFPoint getEnd(){
		return end;
	}
}
