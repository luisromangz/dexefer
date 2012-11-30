package org.dexefer.entities;

import org.dexefer.DXFPoint;
import org.dexefer.annotations.DXFPointProperty;
import org.dexefer.annotations.DXFProperty;

/**
 * Represents a TEXT entity.
 * @author luisro
 *
 */
public class Text extends Entity {
	
	public static final String TEXT_STYLE_STANDARD="STANDARD";
	public static final int TEXT_MIRRORING_STANDARD_FLAG=0;
	public static final int TEXT_MIRRORING_BACKWARDS_FLAG=2;
	public static final int TEXT_MIRRORING_UPSIDEDOWN_FLAG=4;
	
	public static final int JUSTIFICATION_LEFT=0;
	public static final int JUSTIFICATION_CENTER=1;
	public static final int JUSTIFICATION_RIGHT=2;
	public static final int JUSTIFICATION_ALIGNED=3;
	public static final int JUSTIFICATION_MIDDLE=4;
	public static final int JUSTIFICATION_FIT=5;
	
	public static final int VALIGN_BASELINE=0;
	public static final int VALIGN_BOTTOM=1;
	public static final int VALIGN_MIDDLE=2;
	public static final int VALIGN_TOP=3;

	@DXFProperty(100)
	private String entityMarker="AcDbText";
	
	@DXFProperty(39)
	private int thickness=0;
	
	@DXFPointProperty(xCode=10,yCode=20,zCode=30)
	private DXFPoint alignmentStart;
	
	@DXFProperty(40)
	private int textHeight=1;
	
	@DXFProperty(1)
	private String text;	
	
	@DXFProperty(50)
	private int textRotation=0;
	
	@DXFProperty(7)
	private String textStyle=TEXT_STYLE_STANDARD;
	
	@DXFProperty(71)
	private int textMirroring=TEXT_MIRRORING_STANDARD_FLAG;
	
	@DXFProperty(72)
	private int justification=JUSTIFICATION_LEFT;
	
	@DXFPointProperty(xCode=11,yCode=21,zCode=31)
	private DXFPoint alignmentEnd;
	
	@DXFProperty(100)
	private String subMarker="AcDbText";
	
	@DXFProperty(73)
	private int verticalAlignment;	
	
	
	public Text(String text, DXFPoint alignmentStart){
		this.text=text;
		// We share the same point as that JUST WORKS(tm).
		this.alignmentStart=alignmentStart;
		this.alignmentEnd=alignmentStart;
	}
	
	
	public String getEntityMarker(){
		return entityMarker;
	}



	public int getThickness() {
		return thickness;
	}



	public void setThickness(int thickness) {
		this.thickness = thickness;
	}



	public DXFPoint getAlignmentStart() {
		return alignmentStart;
	}



	public int getTextHeight() {
		return textHeight;
	}



	public void setTextHeight(int textHeight) {
		this.textHeight = textHeight;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public int getTextRotation() {
		return textRotation;
	}



	public void setTextRotation(int textRotation) {
		this.textRotation = textRotation;
	}



	public String getTextStyle() {
		return textStyle;
	}



	public void setTextStyle(String textStyle) {
		this.textStyle = textStyle;
	}



	public int getTextMirroring() {
		return textMirroring;
	}



	public void setTextMirroring(int textMirroring) {
		this.textMirroring = textMirroring;
	}



	public int getJustification() {
		return justification;
	}



	public void setJustification(int justification) {
		this.justification = justification;
	}



	public DXFPoint getAlignmentEnd() {
		return alignmentEnd;
	}






	public String getSubMarker() {
		return subMarker;
	}



	public int getVerticalAlignment() {
		return verticalAlignment;
	}


	public void setVerticalAlignment(int verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

}
