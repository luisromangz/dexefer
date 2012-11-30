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
 * Defines a drawing's CIRCLE entities.
 * @author luisro
 *
 */
public class Circle extends Entity {
	
	@DXFProperty(100)
	private String entityMarker = "AcDbCircle";

	@DXFProperty(39)
	private
	Integer thickess;
	@DXFPointProperty(xCode=10,yCode=20,zCode=30)
	private DXFPoint center;	
	@DXFProperty(40)
	private
	double radius;
	
	/**
	 * Creates a Circle instance.
	 * @param x0
	 * @param y0
	 * @param z0
	 * @param radius
	 */
	public Circle (DXFPoint center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Integer getThickess() {
		return thickess;
	}
	public void setThickess(Integer thickess) {
		this.thickess = thickess;
	}
	
	public DXFPoint getCenter() {
		return center;		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius<0) {
			throw new IllegalArgumentException("Circle radius can't be a negative number!");
		}
		this.radius = radius;
	}
	
	public String getEntityMarker(){
		return entityMarker;
	}
}
