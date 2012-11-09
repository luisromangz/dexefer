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

@DXFElementType("TABLE")
public class VPort extends Table {

	@DXFProperty(100)
	private String subMarker="AcDbViewportTableRecord";
	
	@DXFProperty(2)
	private String name="*ACTIVE";
	
	@DXFPointProperty(xCode=10,yCode=20,zCode=30)
	private DXFPoint leftBottom;
	@DXFPointProperty(xCode=11,yCode=21,zCode=31)
	private DXFPoint rightTop;
	
	public String getSubMarker() {
		return subMarker;
	}
	
	public DXFPoint getLeftBottom(){
		return leftBottom;
	}
	
	public DXFPoint getRightTop(){
		return rightTop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
