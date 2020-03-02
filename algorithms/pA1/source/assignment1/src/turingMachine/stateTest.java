package turingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class stateTest {
	@Test 
	void test() 	{
	/**
	 * For a test state "Q0", specify the action when the
	 * input from the tape is "0" via "action" variable
	 * 
	 * Create the transition function for Q0 with input "0"
	 */
	action q0_zero_trans   = new action('1', Movement.LEFT, 1);
	transitionFunction q0_zero = new transitionFunction('0',q0_zero_trans);
	
	/**
	 * For a test state "Q0", specify the action when the
	 * input from the tape is "1" via "action" variable
	 * 
	 * Create the transition function for Q0 with input "1"
	 */
	action q0_one_trans   = new action('0', Movement.RIGHT, 2);
	transitionFunction q0_one = new transitionFunction('1',q0_one_trans);
	
	/**
	 * For a test state "Q0", specify the action when the
	 * input from the tape is "blank" via "action" variable
	 * 
	 * Create the transition function for Q0 with input "blank"
	 */
	action q0_blank_trans   = new action('1', Movement.HALT_PASS, 3);
	transitionFunction q0_blank = new transitionFunction('b',q0_blank_trans);
	
	/**
	 * Now that the three possible transition functions have been developed,
	 * create an array of transition functions to specify all possible
	 * transitions for a given state
	 */
	transitionFunction[] transitions = { q0_zero, q0_one, q0_blank };
	
	
	/**
	 * Create a new state named "1" (which denotes Q1) and assign it
	 * the array of transitionFunctions 
	 */
	state newState = new state(1, transitions);
	
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



