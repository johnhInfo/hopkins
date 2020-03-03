package turingMachine;
/******************************************************************************
 * File: Movement.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/

/*******************************************************************************
 * Movement Object specifies the next movement for the Turing machine's head 
 *
 * RIGHT move the head to the right 
 * LEFT  move the heat to the left 
 * HALT_PASS halt the head and return "PASS"
 * HALT_FAIL halt the head and return "FAIL"
 ******************************************************************************/
public enum Movement {
	RIGHT,
	LEFT,
	HALT_PASS,
	HALT_FAIL
}

