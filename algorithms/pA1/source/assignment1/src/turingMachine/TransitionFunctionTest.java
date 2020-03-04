/******************************************************************************
 * File: TransitionFunctionTest.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * The following class tests the transitionFunction class. 
 *
 */
class TransitionFunctionTest {

	@Test
	void test() {
		
		Action newAction =  new Action('1', Movement.LEFT, 3);
		
		TransitionFunction tf = new TransitionFunction('1', newAction);
			
		assertEquals('1', tf.input, "*1* assignment failed");
		assertEquals('1', tf.transition.writeSymbol, "*1* assignment failed");
		assertEquals(Movement.LEFT, tf.transition.moveTape, "LEFT* assignment failed");
		assertEquals(3, tf.transition.nextState, "3 assignment failed");
		}
	}

