package closestPairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ClosestPairsTest {
	
	@Test
	void testCase1_testingFindDumb() {
		
		Point p1 = new Point(0,0);
		Point p2 = new Point(10,0);
		Point p3 = new Point(0,11);
		Point p4 = new Point(100,0);
		Point p5 = new Point(0,1000);
		
		PointList pL = new PointList();
		pL.add(p1);
		pL.add(p2);
		pL.add(p3);
		pL.add(p4);
		pL.add(p5);
		
		ClosestPairs cP = new ClosestPairs(pL);
		double distance = cP.findDumb();
		//System.out.println((int)distance);
		assertEquals((int)distance,(int)10, "Closest Pairs Calculation Failed...");
	}
	
	@Test
	void testCase1_testingFindSmart() {
		
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
		
		System.out.printf("The median is %d\n", pList.size()/2);
		
		ClosestPairs cP = new ClosestPairs(pList);
		double distance = cP.findSmart();
		
		System.out.printf("Distance Found was %d\n" , (int)distance);
		System.out.printf("The number of pairs compared were: %d \n", cP.pairList.size());
		System.out.println("The pairs compared were: ");
		cP.ClosestNPairs(3);
		cP.ClosestNPairsDistance(3);
		//assertEquals((int)distance,(int)10, "Finding Closest Parts Smart Failed");
	}
	
	@Test
	void testCase2_testingPrintPairs() {
		
		Point p1 = new Point(0,0);
		Point p2 = new Point(10,0);
		Point p3 = new Point(0,11);
		Point p4 = new Point(100,0);
		Point p5 = new Point(0,1000);
		
		PointList pL = new PointList();
		pL.add(p1);
		pL.add(p2);
		pL.add(p3);
		pL.add(p4);
		pL.add(p5);
		
		ClosestPairs cP = new ClosestPairs(pL);
		cP.findDumb();
		//cP.printPairs();
		int numberOfPairs = cP.pairList.size();
		assertEquals(numberOfPairs,10, "Print Pairs method failed");
	}
	
	@Test
	void testCase3_testingSortinPairs() {
		
		Point p1 = new Point(0,0);
		Point p2 = new Point(10,0);
		Point p3 = new Point(0,11);
		Point p4 = new Point(100,0);
		Point p5 = new Point(0,1000);
		
		PointList pL = new PointList();
		pL.add(p1);
		pL.add(p2);
		pL.add(p3);
		pL.add(p4);
		pL.add(p5);
		
		ClosestPairs cP = new ClosestPairs(pL);
		cP.findDumb();
		cP.sortPairs();
		//cP.printPairs();
		int numberOfPoints = cP.list.size();
		int numberOfPairs = cP.pairList.size();
		//System.out.printf("The number of points is %d \n", numberOfPoints);
		//System.out.printf("The number of pairs is %d \n", numberOfPairs);
		assertEquals(numberOfPairs,10, "Sort Pairs method failed");
	}

}
