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


