/******************************************************************************
 * File: MovementTest.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**************************************************************************
 * Tests the Movement Enum Class
 *
 * RIGHT move the head to the right 
 * LEFT  move the heat to the left 
 * HALT_PASS halt the head and return "PASS"
 * HALT_FAIL halt the head and return "FAIL"
 *************************************************************************/
class MovementTest {

	@Test
	void testCase_MovementRight() {
		Movement next = Movement.RIGHT;
		assertEquals(Movement.RIGHT, next, "*Right* assignment failed");
	}
	
	@Test
	void testCase_MovementLEFT() {
		Movement next = Movement.LEFT;
		assertEquals(Movement.LEFT, next, "*Left* assignment failed");
	}
	
	@Test
	void testCase_MovementHALT_PASS() {
		Movement next = Movement.HALT_PASS;
		assertEquals(Movement.HALT_PASS, next, "*HALT_PASS* assignment fails");
	}
	
	@Test
	void testCase_MovementHALT_FAIL() {
		Movement next = Movement.HALT_FAIL;
		assertEquals(Movement.HALT_FAIL, next, "*HALT_FAIL* assignment fails");
	}

}
