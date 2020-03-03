/******************************************************************************
 * File: StateTest.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/

package turingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**************************************************************************
 * StateTest contains a unit tests for the State class
 *
 *************************************************************************/
class StateTest {
	@Test 
	void testCase1() 	{
	/**
	 * For a test state "Q0", specify the action when the
	 * input from the tape is "0" via "action" variable
	 * 
	 * Create the transition function for Q0 with input "0"
	 */
	Action q0_zero_trans   = new Action('1', Movement.LEFT, 1);
	TransitionFunction q0_zero = new TransitionFunction('0',q0_zero_trans);
	
	/**
	 * For a test state "Q0", specify the action when the
	 * input from the tape is "1" via "action" variable
	 * 
	 * Create the transition function for Q0 with input "1"
	 */
	Action q0_one_trans   = new Action('0', Movement.RIGHT, 2);
	TransitionFunction q0_one = new TransitionFunction('1',q0_one_trans);
	
	/**
	 * For a test state "Q0", specify the action when the
	 * input from the tape is "blank" via "action" variable
	 * 
	 * Create the transition function for Q0 with input "blank"
	 */
	Action q0_blank_trans   = new Action('1', Movement.HALT_PASS, 3);
	TransitionFunction q0_blank = new TransitionFunction('b',q0_blank_trans);
	
	/**
	 * Now that the three possible transition functions have been developed,
	 * create an array of transition functions to specify all possible
	 * transitions for a given state
	 */
	TransitionFunction[] transitions = { q0_zero, q0_one, q0_blank };
	
	
	/**
	 * Create a new state named "1" (which denotes Q1) and assign it
	 * the array of transitionFunctions 
	 */
	State newState = new State(1, transitions);
	
	assertEquals(1, newState.stateName, "State Name assignment failed");
	assertEquals('0', newState.transitionFunctions[0].input, "Read 0 assignment failed");
	assertEquals('1', newState.transitionFunctions[1].input, "Read 1 assignment failed");
	assertEquals('b', newState.transitionFunctions[2].input, "Read b assignment failed");
	
	assertEquals(Movement.LEFT, newState.transitionFunctions[0].transition.moveTape , "Move Left assignment failed");
	assertEquals(Movement.RIGHT, newState.transitionFunctions[1].transition.moveTape, "Move Right assignment failed");
	assertEquals(Movement.HALT_PASS, newState.transitionFunctions[2].transition.moveTape, "Halt Pass assignment failed");
	
	assertEquals('1', newState.transitionFunctions[0].transition.writeSymbol , "Write 1 assignment failed");
	assertEquals('0', newState.transitionFunctions[1].transition.writeSymbol, "Write 0 assignment failed");
	assertEquals('1', newState.transitionFunctions[2].transition.writeSymbol, "Write 1 assignment failed");
	
	assertEquals(1, newState.transitionFunctions[0].transition.nextState , "Move to State 1 assignment failed");
	assertEquals(2, newState.transitionFunctions[1].transition.nextState, "Move to State 2 assignment failed");
	assertEquals(3, newState.transitionFunctions[2].transition.nextState, "Move to State 3 assignment failed");
	
	}
}



