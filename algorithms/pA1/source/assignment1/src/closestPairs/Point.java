/******************************************************************************
 * File: Point.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package closestPairs;

/*******************************************************************************
 * Point Object models a 2D point in a Cartesian coordinate system (X,Y)
 *******************************************************************************/
public class Point {
	
	public double x;						/*Point's position on X-Axis			 */ 
	public double y; 					/*Point's position on Y-Axis			 */

	
	
	/*****************************************************************************
	 * Constructor Initializes an object of the Point class
	 * 
	 * 
	 * @param x The Point's position on the X-Axis
	 * @param y The Point's position on the Y-Axis
	 *****************************************************************************/
	public Point(double x, double y) {
		
		this.x = x;
		this.y = y;
	}
	
	/*****************************************************************************
	 * distance method calculates the distance between Point and a point in space
	 *          ... specified by the (x,y) coordinates of the input.
	 * 
	 * 
	 * @param x The point in space's position on the X-Axis
	 * @param y The point in space's position on the Y-Axis
	 *****************************************************************************/
	public double distance(double x, double y) {
		
		return Math.sqrt((this.y - y) * (this.y - y) + (this.x - x) * (this.x - x));
		
	}
	
	
}

