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
package org.dexefer;

/**
 * Represents a 3D point.
 * @author luisro
 *
 */
public class DXFPoint {
	/**
	 * The point's X component.
	 */
	public double X;
	/**
	 * The point's Y component.
	 */
	public double Y;
	/**
	 * The point's Z component.
	 */
	public double Z;
	
	/**
	 * Creates a point in space.
	 * @param x
	 * @param y
	 * @param z
	 */
	public DXFPoint(double x, double y, double z) {
		X=x;
		Y=y;
		Z=z;
	}
	
	/**
	 * Creates a point in the z=0 plane.
	 * @param x
	 * @param y
	 */
	public DXFPoint(double x, double y) {
		this(x,y,0);
	}
}
