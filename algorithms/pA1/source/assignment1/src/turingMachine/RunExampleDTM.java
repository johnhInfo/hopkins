/******************************************************************************
 * File: RunExampleDTM.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;
/******************************************************************************
 * RunExampleDTM Class runs a main method which takes a set of characters
 *                  and uses said characters as an input to the Example DTM
 *                  
 * @param args - characters separated by a space
 *               1 0 1 0 0 b b                  	(Expected Output: 101bbbb)
 *               
 * @return nothing outputs pair stats via command line display
 *******************************************************************************/
public class RunExampleDTM {
	
	public static void main(String args[]){
		
		char[] ch = new char[args.length];			//Convert input to char array 
		  
        for (int i = 0; i < args.length; i++) { 
            ch[i] = args[i].charAt(0); 
        } 
        											//Init DTM with char array
		ExampleDTM mod3exampleDTM = new ExampleDTM(ch);
													
													//Run the example program
		System.out.println("ExampleDTM Output: ");
		System.out.print(mod3exampleDTM.program());
	}
}