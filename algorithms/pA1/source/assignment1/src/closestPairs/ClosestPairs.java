package closestPairs;

import java.util.ArrayList;

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
		ArrayList<PointList> temp_pl = new ArrayList<PointList>();
		this.pairList = temp_pl;
	}
	
	/**************************************************************************
	 * findSmart Method uses an efficient algorithm to find closest pairs
	 * @return closest pair distance
	 **************************************************************************/
	public double findSmart() {
		return 1;
	}
	
	/**************************************************************************
	 * MinDist Method uses an efficient algorithm to find closest pairs
	 * @return closest pair distance
	 **************************************************************************/
	public static double MinDist(PointList points, ArrayList<PointList> pairs) {
		
												/* If |P| < 3; Try All Pairs */
		if(points.size() < 4 && points.size() > 1){
			return itSearchCP(points, pairs);	
		  }
		else {
			//points.sortXAxis()				//Sort completed above
	        int median = (points.size()) / 2;	//Calculate median
	        
	        //https://stackoverflow.com/questions/5134466/how-to-cast-arraylist-from-list
	        ArrayList<Point> head = new ArrayList<Point>();
	        ArrayList<Point> tail = new ArrayList<Point>();
	        
	        head = points.list.
	        
	        PointList tail = points.subList(4, 8);
		}
		
	}

	/**************************************************************************
	* itSearchCP Method iterative search for closest pair
	* @return closest pair distance
	**************************************************************************/
	public static double itSearchCP(PointList points, ArrayList<PointList> pairs) {
													/*Iterate through list to find 
													 *... smallest distance 	*/
		double smallest = 0;						/*Init smallest with blank  */

		/* Nested For-Loop to Calculate Pair Permutations 						*/
		for(int pivot = 0; pivot < points.size() - 1; pivot++) {
			for(int i = 0; i < points.size() - 1; i++) {
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
