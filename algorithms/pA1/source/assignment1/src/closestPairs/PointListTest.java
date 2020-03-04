/******************************************************************************
 * File: PointListTest.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/

package closestPairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**************************************************************************
 * Tests the PointList Class
 *
 *************************************************************************/
public class PointListTest {
	@Test
	void testCase_sortXAxis() {
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,0);
		Point p3 = new Point(-1,0);
		Point p4 = new Point(1000,0);
		Point p5 = new Point(-10000,0);
		
		PointList pList = new PointList();
		
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		pList.sortXAxis();
		assertEquals(-10000, pList.list.get(0).x ,"X Sort Failed");
		assertEquals(-1,pList.list.get(1).x,"X Sort Failed");
		assertEquals(0,pList.list.get(2).x,"X Sort Failed");
		assertEquals(1,pList.list.get(3).x,"X Sort Failed");
		assertEquals(1000,pList.list.get(4).x,"X Sort Failed");
	}
	
	@Test
	void testCase_sortYAxis() {
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,1);
		Point p3 = new Point(0,-1);
		Point p4 = new Point(0,1000);
		Point p5 = new Point(0,-10000);
		
		PointList pList = new PointList();
		
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		pList.sortYAxis();
		assertEquals(-10000, pList.list.get(0).y ,"Y Sort Failed");
		assertEquals(-1,pList.list.get(1).y,"Y Sort Failed");
		assertEquals(0,pList.list.get(2).y,"Y Sort Failed");
		assertEquals(1,pList.list.get(3).y,"Y Sort Failed");
		assertEquals(1000,pList.list.get(4).y,"Y Sort Failed");
	}
	@Test
	void testCase_sizeLarge() {
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,1);
		Point p3 = new Point(0,-1);
		Point p4 = new Point(0,1000);
		Point p5 = new Point(0,-10000);
		
		PointList pList = new PointList();
		
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		int size = pList.size();
		assertEquals(5, size,"PointList Size Test Failed");
	}
	@Test
	void testCase_sizeZero() {
		PointList pList = new PointList();
		int size = pList.size();
		assertEquals(0, size,"PointList Size Test Failed");
	}

}
