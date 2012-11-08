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
import org.dexefer.annotations.DXFElementType;
import org.dexefer.annotations.DXFPointProperty;
import org.dexefer.annotations.DXFProperty;

/**
 * Defines the aligned Dimension entity subtype.
 * @author luisro
 *
 */
@DXFElementType("DIMENSION")
public class AlignedDimension extends Dimension {

	@DXFProperty(100)
	private String subMarker="AcDbAlignedDimension";
	
	@DXFPointProperty(xCode=13,yCode=23,zCode=33)
	private DXFPoint start;
	
	@DXFPointProperty(xCode=14,yCode=24,zCode=34)
	private DXFPoint end;
	
	public AlignedDimension (DXFPoint start, DXFPoint end) {
		// Aligned (1) + 32 (required by ACAD).
		dimensionType=33;
		
		this.start=start;
		this.end=end;
		
		// We calculate the aligment vector.
		double x=end.X-start.X;
		double y = end.Y-start.Y;
		
		// We normalize then give it a length of five.
		double length = Math.sqrt(x*x+y*y)/10;
		
		
		x=x/length;
		y=y/length;
		
		// We interchange the components and apply the vector to the dimension endpooint.
		this.definitionPoint= new DXFPoint(end.X+y, end.Y-x , end.Z);
		
	}
	
	public String getSubMarker(){
		return subMarker;	
	}
	
	public DXFPoint getStart(){
		return start;
	}
	
	public DXFPoint getEnd(){
		return end;
	}
}
