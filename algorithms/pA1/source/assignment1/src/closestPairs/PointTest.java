/******************************************************************************
 * File: PointTest.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/

package closestPairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/******************************************************************************
 * Point contains a series of test for the Point class
 * 
 * Note: Due to time constraints, the unit tests may have issues or be 
 *       incomplete. Tests were created in an ad hoc manner and modified
 *       freely in order to debug code. 
 *******************************************************************************/
class PointTest {

	@Test
	void testCase_distance1() {
		
		Point p1 = new Point(0,0);
		double dist = p1.distance(5,5);
		//System.out.println((int)dist);
		assertEquals((int)dist,(int)7, "Distance Calculation Failed...");
	}
	
	@Test
	void testCase_distance2() {
		Point p1 = new Point(10,0);
		double dist = p1.distance(25,5);
		//System.out.println((int)dist);
		assertEquals((int)dist,(int)15.8114, "Distance Calculation Failed...");
	}
	
	@Test
	void testCase_distance3() {
		Point p1 = new Point(-10,0);
		double dist = p1.distance(25,-5);
		//System.out.println((int)dist);
		assertEquals((int)dist,(int)35.3553, "Distance Calculation Failed...");
	}
}
