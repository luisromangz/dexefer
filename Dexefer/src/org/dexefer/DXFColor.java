package org.dexefer;

/**
 * Lists some known colors, indexed the way ACAD indexes them.
 * @author luisro
 *
 */
public enum DXFColor {
	HIDDEN(-1),
	BYBLOCK(0),
	BYLAYER(256),
	BLACK(0),
	RED(1),
	YELLOW(2),
	GREEN(3),
	CYAN(4),
	BLUE(5),
	MAGENTA(6),
	WHITE(7),
	DARK_GRAY(8),
	LIGHT_GRAY(9);	
	
	int colorCode;
	
	DXFColor(int colorCode){
		this.colorCode = colorCode;
	}
	
	public int getColorCode() {
		return colorCode;
	}
}
