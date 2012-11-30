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

package org.dexefer.sections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dexefer.DXFElement;
import org.dexefer.annotations.DXFElementType;
import org.dexefer.annotations.DXFProperty;
import org.dexefer.annotations.DXFSubElements;
import org.dexefer.annotations.DXFTerminator;
import org.dexefer.annotations.DXFValueMap;



/**
 * The header of an DXF File
 * @author luisro
 *
 */
@DXFElementType("SECTION")
@DXFTerminator("ENDSEC")
public class Header implements DXFElement {
	@DXFSubElements
	private List<HeaderVar> vars;
	
	public Header(){
		vars = new ArrayList<HeaderVar>();
		
		vars.add((new HeaderVar("$ACADVER")).putValue(1, "AC1015"));
		vars.add((new HeaderVar("$HANDSEED")).putValue(5, "FFFF"));		
	}
	
	public List<HeaderVar> getVars() {
		return vars;		
	}
	
	public Header addVar(HeaderVar var) {
		vars.add(var);
		return this;
	}
		
	@DXFElementType(shown=false, value = "")
	public class HeaderVar implements DXFElement {
		@DXFProperty(9)
		private String varName;
		
		@DXFValueMap
		private Map<Integer, Object> values;	
		
		public HeaderVar (String varName) {
			this.varName = varName;
			values = new HashMap<Integer, Object>();			
		}
		
		public String getVarName(){
			return varName;			
		}
		
		public HeaderVar setVarName(String varName){
			this.varName = varName;
			return this;
		}
		
		public Map<Integer,Object> getValues() {
			return values;			
		}
		
		public HeaderVar putValue(int code, Object value) {
			values.put(code, value);
			return this;
		}
	}
	
	
	
}


