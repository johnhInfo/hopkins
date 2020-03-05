package closestPairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPairs {

	
	public PointList list;				    /* Models a list of points   */
	private boolean analyzed;			    /* Denotes whether closest pair
											   algorithm has been completed 
											   for findSmart*/
	              
	public ArrayList<PointList> pairList;  /* Stores Analyzed Pair Data*/
	
	
	/**************************************************************************
	 * Constructor Creates an object of the ClosestPairs Class
	 * 
	 * @param PointList A PointList Object
	 **************************************************************************/
	public ClosestPairs(PointList p) {
											/* Check to see if PointList Exists*/
		if(p == null) {
			PointList temp = new PointList();
			this.list = temp;
		}
											/* If so, initialize the ClosestPairs 
											 * ... class						*/
		else { this.list = p;}
		
											/*Create an arrayList of Pairs to 
											 *... store analyzed pair data     */
		ArrayList<PointList> temp_pairs = new ArrayList<PointList>();
		this.pairList = temp_pairs;
		this.analyzed = false;
	}
	
	/**************************************************************************
	 * findDumb Method uses an brute-force algorithm to find closest pairs
	 * @return closest pair distance
	 **************************************************************************/
	public double findDumb() {
		
		ArrayList<PointList> temp_pairs = new ArrayList<PointList>();
		this.pairList = temp_pairs;
		this.analyzed = false;
		return itSearchCP(this.list, this.pairList);
	}
	
	/**************************************************************************
	 * ClosestNPairs Method prints the closest N pairs
	 **************************************************************************/
	public void ClosestNPairs(int n) {
		
		n = Math.abs(n);								/* Insure N is positive */						
		
		if(this.pairList.size() > 0) {
			Collections.sort(this.pairList, new SortByDistance());
			
			int nOrAll = (n < this.pairList.size()) ? n : this.pairList.size();
			
			for(int i = 0; i < nOrAll; i++) {
														/* Acquire a pair */
				PointList tempPair = this.pairList.get(i);
				Point a;
				Point b;
				double distance; 
														    /*Confirm list is pair */
				if(tempPair.size() == 2) {	
					a = tempPair.list.get(0);				/*Acquire Points A & B */			
					b = tempPair.list.get(1);
					distance = tempPair.distance;
					System.out.printf("Point A (%f, %f) and Point B(%f, %f)\n" ,
							a.x, a.y, b.x, b.y);
				}		
			}
		}
	}
	
	/**************************************************************************
	 * ClosestNPairsDistance Method prints the closest N pairs & distances
	 **************************************************************************/
	public void ClosestNPairsDistance(int n) {
		
		n = Math.abs(n);								/* Insure N is positive */						
		
		if(this.pairList.size() > 0) {
			Collections.sort(this.pairList, new SortByDistance());
			
			int nOrAll = (n < this.pairList.size()) ? n : this.pairList.size();
			
			for(int i = 0; i < nOrAll; i++) {
														/* Acquire a pair */
				PointList tempPair = this.pairList.get(i);
				Point a;
				Point b;
				double distance; 
														    /*Confirm list is pair */
				if(tempPair.size() == 2) {	
					a = tempPair.list.get(0);				/*Acquire Points A & B */			
					b = tempPair.list.get(1);
					distance = tempPair.distance;
					System.out.printf("Point A (%f, %f) and Point B(%f, %f) are distance %f apart \n" ,
							a.x, a.y, b.x, b.y, distance);
				}		
			}
		}
	}
	
	/***************************************************************
	 * sortPairs Sorts Pairs in PairList by distance 
	 ***************************************************************/
		public void sortPairs()
		{
			Collections.sort(this.pairList, new SortByDistance());
		}
		
	/**************************************************************************
	 * findSmart Method uses an efficient algorithm to find closest pairs
	 * @return closest pair distance
	 **************************************************************************/
	public double findSmart() {
		
		ArrayList<PointList> temp_pairs = new ArrayList<PointList>();
		this.pairList = temp_pairs;
		this.list.sortXAxis();
		this.analyzed = true;
		return MinDist(this.list, this.pairList);
		
	}
	/**************************************************************************
	 * MinDist Method uses an efficient algorithm to find closest pairs
	 * @return closest pair distance
	 **************************************************************************/
	public static double MinDist(PointList points, ArrayList<PointList> pairs) {
		double minDist;
		int numPoints = points.size();
												/* If |P| < 3; Try All Pairs */
		if(numPoints < 4 && numPoints > 1){
			return itSearchCP(points, pairs);	
		  }
		else {
			
			int median = (numPoints) / 2;		/*Calculate median Index		*/
												/*Calculate median value           */
			double medianValue = points.list.get(median).x;
												/*Create a sublist from [0-Median)*/
			
			List<Point> head = points.list.subList(0,  median);
												/*Create a sublist from [Median-End)*/
	        List<Point> tail = points.list.subList(median, numPoints);

	        									/* Create A Sub PointList for Head*/
			PointList headPoints = new PointList();
			headPoints.list = new ArrayList<Point>(head); 
			
												/* Create A Sub PointList for Tail*/
			PointList tailPoints = new PointList();
			tailPoints.list = new ArrayList<Point>(tail); 
			
												/* Calculate upper bounds of min */
			double minTail = MinDist(tailPoints, pairs);
			double minHead = MinDist(headPoints, pairs);
			minDist = (minTail < minHead) ? minTail : minHead;
			
			PointList BL = new PointList();
			PointList BR = new PointList();
			
												/* Find points in head and tail within a minimum
												 * distance from the median
												 */
			BL.list = headPoints.withinRange(medianValue - minDist, median, Cartesian.xSort);
			BR.list = tailPoints.withinRange(medianValue, median + minDist, Cartesian.xSort);
			
												/* Combine BL and BR Lists 			*/
			PointList combined = new PointList();
			if(BL.list == null && BR.list == null) { return minDist; }
			if(BL.list != null) { combined.list.addAll(BL.list); }
			if(BR.list != null) { combined.list.addAll(BR.list); }
			
			double innerMin = itSearchCP(combined, pairs);									
												/*Return the minimum distance found */
			return (innerMin < minDist) ? innerMin : minDist;
			}	
		}
	/**************************************************************************
	* itSearchCP (Iterative-Search-Closest Pair)Method iterative search 
	*                                           ...for closest pair
	* @return closest pair distance
	**************************************************************************/
	public static double itSearchCP(PointList points, ArrayList<PointList> pairs) {
													/*Iterate through list to find 
													 *... smallest distance 	*/
		double smallest = 0;						/*Init smallest with blank  */

		/* Nested For-Loop to Calculate Pair Permutations 						*/
		for(int pivot = 0; pivot < points.size(); pivot++) {
			for(int i = 0; i < points.size(); i++) {
				/* ************************************************************
				 * Only do calculation if I > Pivot.. Otherwise calculation:
				 *   (1) Is Not necessary  (I = Pivot)
				 *   (2) Already been done (I < Pivot)
				 * 							 
				 * [A] [B] [C] [D]												
				 *   ^       ^
				 *   |       |
				 * Pivot     I
				 **************************************************************/
				if(i > pivot) {
					Point A = points.list.get(pivot);
					Point B = points.list.get(i);

												/*Create a structure to store 
												 *... a single pair of points */
					PointList single_pair = new PointList();
					
												/*Store A & B in single pair 
												 *... structure
												 */
					single_pair.createPair(A, B);
					
					pairs.add(single_pair);		/*Add single pair structure to the
												/*list of all pairs

												/*If we're looking at beginning
					 							 *... of array, initialize
					 							 *... smallest variable 	*/
					if(pivot == 0 && i == 1) {
						smallest = single_pair.distance;
					}
					else if (single_pair.distance < smallest) {
						smallest = single_pair.distance;
					}	
				}
			}
		}
	 return smallest;
	}
}
