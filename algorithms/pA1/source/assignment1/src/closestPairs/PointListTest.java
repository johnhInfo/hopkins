/******************************************************************************
 * File: PointListTest.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/

package closestPairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/******************************************************************************
 * PointListTest contains a series of test for the PointList class
 * 
 * Note: Due to time constraints, the unit tests may have issues or be 
 *       incomplete. Tests were created in an ad hoc manner and modified
 *       freely in order to debug code. 
 *******************************************************************************/
public class PointListTest {
	@Test
	void testCase_sortXAxis() {
		Point p1 = new Point(10,0);
		Point p2 = new Point(12,0);
		Point p3 = new Point(-1123,0);
		Point p4 = new Point(1020,0);
		Point p5 = new Point(-22000,0);
		Point p6 = new Point(124,0);
		Point p7 = new Point(41,0);
		Point p8 = new Point(-41,0);
		Point p9 = new Point(2200,0);
		Point p10 = new Point(-1200,0);
		Point p11 = new Point(550,0);
		Point p12 = new Point(15,0);
		Point p13 = new Point(-15,0);
		Point p14 = new Point(1050,0);
		Point p15 = new Point(1051,0);
		
		PointList pList = new PointList();
		
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		pList.add(p6);
		pList.add(p7);
		pList.add(p8);
		pList.add(p9);
		pList.add(p10);
		pList.add(p11);
		pList.add(p12);
		pList.add(p13);
		pList.add(p14);
		pList.add(p15);
		
		pList.sortXAxis();
		
		
		//pList.print();
		
		//assertEquals(-22000, pList.list.get(0).x ,"X Sort Failed");
		//assertEquals(-1,pList.list.get(1).x,"X Sort Failed");
		//assertEquals(0,pList.list.get(2).x,"X Sort Failed");
		//assertEquals(1,pList.list.get(3).x,"X Sort Failed");
		//assertEquals(1000,pList.list.get(4).x,"X Sort Failed");
	}
	
	@Test
	void testCase_sortYAxis() {
		Point p1 = new Point(0,10);
		Point p2 = new Point(0,11);
		Point p3 = new Point(0,-11);
		Point p4 = new Point(0,1000);
		Point p5 = new Point(0,-10000);
		Point p6 = new Point(0,20);
		Point p7 = new Point(0,11);
		Point p8 = new Point(0,-21);
		Point p9 = new Point(0,1200);
		Point p10 = new Point(0,-12000);
		Point p11 = new Point(0,-10);
		Point p12 = new Point(0,121);
		Point p13 = new Point(0,-12221);
		Point p14 = new Point(0,1200);
		Point p15 = new Point(0,-1005500);
		Point p16 = new Point(0,15);
		Point p17 = new Point(0,115);
		Point p18 = new Point(0,-21);
		Point p19 = new Point(0,-200);
		Point p20 = new Point(0,-201);
		
		
		PointList pList = new PointList();
		
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		pList.add(p6);
		pList.add(p7);
		pList.add(p8);
		pList.add(p9);
		pList.add(p10);
		pList.add(p11);
		pList.add(p12);
		pList.add(p13);
		pList.add(p14);
		pList.add(p15);
		pList.add(p16);
		pList.add(p17);
		pList.add(p18);
		pList.add(p19);
		pList.add(p20);
		
		pList.sortYAxis();
		//pList.print();
		
		//assertEquals(-12000, pList.list.get(0).y ,"Y Sort Failed");
		//assertEquals(-11,pList.list.get(3).y,"Y Sort Failed");
		//assertEquals(0,pList.list.get(2).y,"Y Sort Failed");
		//assertEquals(1,pList.list.get(3).y,"Y Sort Failed");
		//assertEquals(1000,pList.list.get(4).y,"Y Sort Failed");
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
	
	
	@Test
	void testCase_splitList() {
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,1);
		Point p3 = new Point(0,-1);
		Point p4 = new Point(0,1000);
		Point p5 = new Point(0,-10000);
		
		Point p6 = new Point(0,0);
		Point p7 = new Point(0,1);
		Point p8 = new Point(0,-1);
		Point p9 = new Point(0,1000);
		Point p10 = new Point(0,-10000);
		
		PointList pList = new PointList();
		
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		pList.add(p6);
		pList.add(p7);
		pList.add(p8);
		pList.add(p9);
		pList.add(p10);
		
		int median = (pList.size()) / 2;	//Calculate median
		
		/***********************************************************************
		 * Sublist Creation
		 * 
		 * (1) Create sublist 1
		 * (2) Create sublist 2
		 * 
		 * (3) Copy sublist 1 to new ArrayList
		 * (4) Copy sublist 2 to new ArrayList
		 * 
		 ***********************************************************************/
        List<Point> head = pList.list.subList(0,  median);
        //System.out.println("Head List: ");
        for(int i = 0; i < head.size(); i++) {
        	//System.out.printf("Point (%f, %f)\n", head.get(i).x, head.get(i).y);
        }
        
        List<Point> tail = pList.list.subList(median,  pList.size());
        //System.out.println("Tail List: ");
        for(int i = 0; i < tail.size(); i++) {
        	//System.out.printf("Point (%f, %f)\n", tail.get(i).x, tail.get(i).y);
        }
        
		int headSize = head.size();
		int tailSize = tail.size();
		
		pList.list = new ArrayList<Point>(head); /* Create Copy */
		
		assertEquals(5, headSize,"Split Test Failed");
		assertEquals(5, tailSize,"Split Test Failed");
		assertEquals(5, pList.list.size(),"Store ArrayList Failed");
	}
	
	@Test
	void testCase_withinRangeX() {
		Point p1 = new Point(10,0);
		Point p2 = new Point(20,1);
		Point p3 = new Point(30,-1);
		Point p4 = new Point(40,1000);
		Point p5 = new Point(50,-10000);
		
		Point p6 = new Point(60,0);
		Point p7 = new Point(70,1);
		Point p8 = new Point(80,-1);
		Point p9 = new Point(90,1000);
		Point p10 = new Point(110,-10000);
		
		PointList pList = new PointList();
		
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		pList.add(p6);
		pList.add(p7);
		pList.add(p8);
		pList.add(p9);
		pList.add(p10);
		
		PointList BL = new PointList();
		BL.list = pList.withinRange(40, 80, Cartesian.xSort);
		//BL.print();
	}
	@Test
	void testCase_withinRangeY() {
		Point p1 = new Point(10,70);
		Point p2 = new Point(20,31);
		Point p3 = new Point(30,-1);
		Point p4 = new Point(40,1000);
		Point p5 = new Point(50,-10000);
		
		Point p6 = new Point(60,0);
		Point p7 = new Point(70,66);
		Point p8 = new Point(80,-1);
		Point p9 = new Point(90,1000);
		Point p10 = new Point(110,-10000);
		
		PointList pList = new PointList();
		
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		pList.add(p6);
		pList.add(p7);
		pList.add(p8);
		pList.add(p9);
		pList.add(p10);
		System.out.println("Printing List:");
		pList.print();
		
		
		PointList BL = new PointList();
		BL.list = pList.withinRange(40, 80, Cartesian.ySort);
		System.out.println("Printing Within Range:");
		BL.print();
	}
}
