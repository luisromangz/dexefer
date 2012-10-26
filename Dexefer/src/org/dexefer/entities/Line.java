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

import org.dexefer.annotations.DXFProperty;

/**
 * Defines a drawing's Line entities.
 * @author luisro
 */
public class Line extends Entity {
	
	
	@DXFProperty(39)
	private Integer thickness;
	
	@DXFProperty(10)
	private double X0;
	@DXFProperty(20)
	private double Y0;
	@DXFProperty(30)
	private double Z0;
	@DXFProperty(11)
	private double X1;
	@DXFProperty(21)
	private double Y1;
	@DXFProperty(31)
	private double Z1;
	
	public Line(double x0, double y0, double z0, double x1, double y1, double z1) {
		
		this.X0 = x0;
		this.Y0=y0;
		this.Z0=z0;
		
		this.X1=x1;
		this.Y1=y1;
		this.Z1=z1;
		
	}
	
	public Integer getThickness() {
		return thickness;
	}
	public void setThickness(Integer thickness) {
		this.thickness = thickness;
	}
	public double getX0() {
		return X0;
	}
	public void setX0(double x0) {
		X0 = x0;
	}
	public double getY0() {
		return Y0;
	}
	public void setY0(double y0) {
		Y0 = y0;
	}
	
	public double getZ0() {
		return Z0;
	}
	
	public void setZ0(double z0) {
		Z0 = z0;
	}
	public double getX1() {
		return X1;
	}
	public void setX1(double x1) {
		X1 = x1;
	}
	public double getY1() {
		return Y1;
	}
	public void setY1(double y1) {
		Y1 = y1;
	}
	public double getZ1() {
		return Z1;
	}
	public void setZ1(double z1) {
		Z1 = z1;
	}
	
}
