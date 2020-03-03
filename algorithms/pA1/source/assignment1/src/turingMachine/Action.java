/******************************************************************************
 * File: Action.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;
/*******************************************************************************
 * Action Model Object which specifies a state's response to a given input. 
 *
 * This includes: 
 *                (1) Write Symbol
 *                (2) Direction of Tape Movement
 *                (3) The next state
 ********************************************************************************/
public class Action {
	
	public char writeSymbol; 				//Symbol to be written to tape
	public Movement moveTape;				//Direction to move the head
	public int nextState;					//The next state in the control scheme
	
	/*************************************************************************
	 * Constructor Initializes an object of the "action" class
	 *
	 * @param writeSymbol The character in alphabet Gamma to be written
	 *                    to the tape 
	 * @param moveTape    The direction of tape head movement
	 * @param nextState   The next state in the control machine 
	 ************************************************************************/
	public Action(char writeSymbol, Movement moveTape, int nextState) {
		this.writeSymbol = writeSymbol;
		this.moveTape = moveTape;
		this.nextState = nextState;
	}

}
