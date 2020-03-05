/******************************************************************************
 * File: RunAdditionDTM.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;
/******************************************************************************
 * RunAdditionDTM Class runs a main method which takes a set of characters
 *                and uses said characters as an input to the Addition DTM
 *                  
 * @param args - characters separated by a space
 *               0 0 b 0 b                  	(Expected Output: p000b)
 *               
 * @return nothing outputs pair stats via command line display
 *******************************************************************************/
public class RunAdditionDTM {
	
	public static void main(String args[]){
		
		char[] ch = new char[args.length];			//Convert input to char array 
		  
        for (int i = 0; i < args.length; i++) { 
            ch[i] = args[i].charAt(0); 
        } 
        											//Init DTM with char array
		AdditionDTM dtm = new AdditionDTM(ch);
		
													//Run the example program
		System.out.println("AdditionDTM Output: ");
		
		for(int i = 0; i < 1; i++) {
			System.out.print(dtm.program());
		}
	}
}