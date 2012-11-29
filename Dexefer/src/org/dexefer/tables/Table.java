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

import org.dexefer.DXFElement;
import org.dexefer.annotations.DXFProperty;

public abstract class Table implements DXFElement {
	
	@DXFProperty(5)
	private Integer handler;
	
	@DXFProperty(100)
	private String marker="AcDbSymbolTableRecord";	
	

	public Integer getHandler() {
		return handler;
	}

	public void setHandler(int handler) {
		this.handler = handler;
	}

	public String getMarker() {
		return marker;
	}
}
