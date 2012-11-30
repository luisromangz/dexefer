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
package org.dexefer.tables;

import org.dexefer.DXFPoint;
import org.dexefer.annotations.DXFElementType;
import org.dexefer.annotations.DXFPointProperty;
import org.dexefer.annotations.DXFProperty;
import org.dexefer.annotations.DXFTerminator;

@DXFElementType("TABLE")
@DXFTerminator("ENDTAB")
public class VPort extends Table {

	@DXFProperty(100)
	private String subMarker="AcDbViewportTableRecord";
	
	@DXFProperty(2)
	private String name="*ACTIVE";
	
	@DXFPointProperty(xCode=12,yCode=22)
	private DXFPoint center;
	
	@DXFProperty(40)
	private int viewHeight;
	
	@DXFProperty(41)
	private double viewRatio = 1.57620320856;
	
	public VPort(DXFPoint center, int viewHeight) {		
		this.center = center;
		this.viewHeight = viewHeight;
	}
	
	public String getSubMarker() {
		return subMarker;
	}
	
	

	public String getName() {
		return name;
	}

	public VPort setName(String name) {
		this.name = name;
		return this;
	}



	public DXFPoint getCenter() {
		return center;
	}

 


	public int getViewHeight() {
		return viewHeight;
	}



	public VPort setViewHeight(int viewHeight) {
		this.viewHeight = viewHeight;
		return this;
	}



	public double getViewRatio() {
		return viewRatio;
	}



	public VPort setViewRatio(double viewRatio) {
		this.viewRatio = viewRatio;
		return this;
	}

	
	
}
