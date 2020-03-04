/******************************************************************************
 * File: Point.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package closestPairs;
import java.util.*;

/*******************************************************************************
 * Point Object models a 2D point in a Cartesian coordinate system (X,Y)
 *******************************************************************************/
class Point {
	
	public double x;						/*Point's position on X-Axis			 */ 
	public double y; 						/*Point's position on Y-Axis			 */
	public Cartesian sort;

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

/*****************************************************************************
 * SortXAxis Compares two Points by their X Axis 
 * 
 * @param Point The first point to compare
 * @param Point The second point to compare
 *****************************************************************************/
class SortXAxis implements Comparator<Point>{
	/*******************************************************************************
	 * SortXAxis Class assist with sorting Points based on their X Axis value
	 * o.x > d.x <----- [Returns 1]
	 * o.x < d.x <----- [Returns -1]
	 * else [Returns 0]
	 * 
	 ******************************************************************************/
	public int compare(Point o, Point d) {
			if(o.x > d.x){return 1;}
			else if(o.x < d.x) {return -1;}
			else {return 0;}
		}
	}

/*****************************************************************************
 * SortYAxis Compares two Points by their Y Axis 
 * 
 * @param Point The first point to compare
 * @param Point The second point to compare
 *****************************************************************************/
class SortYAxis implements Comparator<Point>{
	/*******************************************************************************
	 * SortYAxis Class assist with sorting Points based on their Y Axis value
	 * o.y > d.y <----- [Returns 1]
	 * o.y < d.y <----- [Returns -1]
	 * else [Returns 0]
	 * 
	 ******************************************************************************/
	public int compare(Point o, Point d) {
			if(o.y > d.y){return 1;}
			else if(o.y < d.y) {return -1;}
			else {return 0;}
		}
	}


