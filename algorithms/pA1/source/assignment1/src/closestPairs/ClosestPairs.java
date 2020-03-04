package closestPairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPairs {

	
	public PointList list;
	public int median;
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
	}
	
	/**************************************************************************
	 * findDumb Method uses an brute-force algorithm to find closest pairs
	 * @return closest pair distance
	 **************************************************************************/
	public double findDumb() {
		
		return itSearchCP(this.list, this.pairList);
	}
	
	/**************************************************************************
	 * printPairs Method uses an brute-force algorithm to find closest pairs
	 * @return closest pair distance
	 **************************************************************************/
	public void printPairs() {
		
		if(this.pairList.size() > 0) {
			
			for(int i = 0; i < this.pairList.size(); i++) {
				
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
			
			int median = (numPoints) / 2;		/*Calculate median 			*/
												/*Create a sublist from [0-Median]*/
			List<Point> head = points.list.subList(0,  median);
												/*Create a sublist from [Median-End]*/
	        List<Point> tail = points.list.subList(median, numPoints);

	        									/* Create A Sub PointList for Head*/
			PointList headPL = new PointList();
			headPL.list = new ArrayList<Point>(head); 
			
												/* Create A Sub PointList for Tail*/
			PointList tailPL = new PointList();
			tailPL.list = new ArrayList<Point>(tail); 
			
												/* Calculate upper bounds of min */
			double minTail = MinDist(tailPL, pairs);
			double minHead = MinDist(headPL, pairs);
			minDist = (minTail < minHead) ? minTail : minHead;
			
			PointList BL = new PointList();
			PointList BR = new PointList();
			
			
			
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
