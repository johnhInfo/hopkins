/******************************************************************************
 * File: RunSubtractionDTM.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;
/******************************************************************************
 * RunSubtraction Class runs a main method which takes a set of characters
 *                and uses said characters as an input to the Subtraction DTM
 *                  
 * @param args - characters separated by a space
 *               1 1 1 0 1 1 b                	(Expected Output: bbb1bbb)
 *               
 * @return nothing outputs pair stats via command line display
 *******************************************************************************/
public class RunSubtractionDTM {
	
	public static void main(String args[]){
		
		char[] ch = new char[args.length];			//Convert input to char array 
		  
        for (int i = 0; i < args.length; i++) { 
            ch[i] = args[i].charAt(0); 
        } 
        											//Init DTM with char array
		SubtractionDTM dtm = new SubtractionDTM(ch);
													//Run the program
		System.out.println("SubtractionDTM Output: ");
		System.out.print(dtm.program());
	}
}
