package org.dexefer;

/**
 * Lists some known colors, indexed the way ACAD indexes them.
 * @author luisro
 *
 */
public enum DXFColor {
	BYBLOCK("0"),
	BYLAYER("256"),
	BLACK("0"),
	RED("1"),
	YELLOW("2"),
	GREEN("3"),
	CYAN("4"),
	BLUE("5"),
	MAGENTA("6"),
	WHITE("7"),
	DARK_GRAY("8"),
	LIGHT_GRAY("9");	
	
	String colorCode;
	
	DXFColor(String colorCode){
		this.colorCode = colorCode;
	}
	
	public String getColorCode() {
		return colorCode;
	}
}
