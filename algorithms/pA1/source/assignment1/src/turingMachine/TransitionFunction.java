/******************************************************************************
 * File: TransitionFunction.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;

/**
 * transitionFunction class specifies the next state and
 * ... and action taken during the transition 
 *
 * This includes: 
 *                (1) Tape Input
 *                (2) The Action of the Transition
 */
public class TransitionFunction {
	
	public char input;
	public Action transition; 
	
	/**
	 * Initializes an object of the "transitionFunction" class
	 *
	 * @param input The input from the tape head 
	 * @param transition The action completed during the transition 
	 */
	public TransitionFunction(char input, Action transition) {
		this.input = input;
		this.transition = transition;
	}

}
