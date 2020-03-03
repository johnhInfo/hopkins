/******************************************************************************
 * File: ActionTest.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*******************************************************************************
 * ActionTest contains unit tests for the Action class 
 *
 ******************************************************************************/
class ActionTest {

	@Test
	void testCase1() {
		Action NewAction =  new Action('1', Movement.LEFT, 3);
		
		assertEquals('1', NewAction.writeSymbol, "*1* assignment failed");
		assertEquals(Movement.LEFT, NewAction.moveTape, "LEFT* assignment failed");
		assertEquals(3, NewAction.nextState, "3 assignment failed");
	}

}
