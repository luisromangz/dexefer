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
