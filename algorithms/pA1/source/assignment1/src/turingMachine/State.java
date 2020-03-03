/******************************************************************************
 * File: State.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/

package turingMachine;

/*********************************************************************************
 * State Object models a state in Q for a given Turing Machine
 *
 * This includes: 
 *                (1) State's Name [represented by a number]
 *                (2) An Array of Transition Functions
 *********************************************************************************/
public class State {
	
	public int stateName;
	public TransitionFunction[] transitionFunctions;
	
	/********************************************************************
	 * Initializes an object of the "state" class
	 *
	 * @param stateName The state's name
	 * @param transitionFunctions The possible transition functions 
	 **********************************************************************/
	public State(int stateName, TransitionFunction[] transitionFunctions) {
		this.stateName = stateName;
		this.transitionFunctions = transitionFunctions;
	}
	
	/********************************************************************
	 * getInputTf Acquires the transition function for a given input
	 *
	 * @param tapeInput the character present in the under the tape head
	 **********************************************************************/
	public TransitionFunction getInputTf(char tapeInput) {
									/* Initialize output to NULL */
		TransitionFunction tf = null;
									/* Find TF for given character input */
		for(int i = 0; i < this.transitionFunctions.length; i++) {
			if(this.transitionFunctions[i].input == tapeInput)
				{
					tf = this.transitionFunctions[i];
					break;
				}
			else { /* Do Nothing */ }
		}
		
		return tf;
	}
}
