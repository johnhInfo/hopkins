/******************************************************************************
 * File: FindClosestPairs.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package closestPairs;
import java.util.ArrayList;
/******************************************************************************
 * FindClosestPairs Class runs a main method which takes a set of point pairs
 *                  from the user and returns a list of the 10 closest pairs
 *                  
 * @param args - Decimal points separated by a space
 *               Ex: 1 2 3 4 5 6 7 8
 *               
 * @return nothing outputs pair stats via command line display
 *******************************************************************************/
public class FindClosestPairs {
	
	public static void main(String args[]){
																//Check for input
		ArrayList<Double> userInput = new ArrayList<Double>();  //ArrayList to store input
	
		for(int i = 0; i < args.length; i++) {                 	//Process the Input
			//System.out.println(args[i]);
		}
		
		double temp;
		
		for(int i = 0; i < args.length; i++) {                 	//Process the Input
			
			try {
				temp = Double.valueOf(args[i]);
				userInput.add(temp);
			}
			catch(Exception e) {
				System.out.println("Error: Invalid Input - Input cannot be converted to double");
				return;
			}
		}
		
		if(userInput.size() % 2 != 0) {
			System.out.println("Error: Invalid Input - Input must contain pairs of numbers");
		}
		
		PointList inputPoints = new PointList();
		
		for(int i = 0; i < userInput.size(); i=i+2)
		{
			inputPoints.add( new Point(userInput.get(i), userInput.get(i+1)));
		}
		
		ClosestPairs cp = new ClosestPairs(inputPoints);
		
		cp.findSmart();
		System.out.println("Resultant Calculation for the closest N pair of points; N set to 10");
		cp.ClosestNPairsDistance(10);
	}
}
	
		
		
		
	

