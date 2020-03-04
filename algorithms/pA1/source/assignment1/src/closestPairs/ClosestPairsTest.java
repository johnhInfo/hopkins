package closestPairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
		
		System.out.printf("The median is %d\n", pL.size()/2);
		
		ClosestPairs cP = new ClosestPairs(pL);
		double distance = cP.findSmart();
		
		System.out.printf("Distance Found was %d\n" , (int)distance);
		System.out.printf("The number of pairs compared were: %d \n", cP.pairList.size());
		System.out.println("The pairs compared were: ");
		cP.printPairs();
		assertEquals((int)distance,(int)10, "Finding Closest Parts Smart Failed");
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
