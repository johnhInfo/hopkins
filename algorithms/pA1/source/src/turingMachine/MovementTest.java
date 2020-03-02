package turingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * Tests the Movement Enum Class
 *
 * RIGHT move the head to the right 
 * LEFT  move the heat to the left 
 * HALT_PASS halt the head and return "PASS"
 * HALT_FAIL halt the head and return "FAIL"
 */
class MovementTest {

	@Test
	void testMovementRight() {
		Movement next = Movement.RIGHT;
		assertEquals(Movement.RIGHT, next, "*Right* assignment failed");
	}
	
	@Test
	void testMovementLEFT() {
		Movement next = Movement.LEFT;
		assertEquals(Movement.LEFT, next, "*Left* assignment failed");
	}
	
	@Test
	void testMovementHALT_PASS() {
		Movement next = Movement.HALT_PASS;
		assertEquals(Movement.HALT_PASS, next, "*HALT_PASS* assignment fails");
	}
	
	@Test
	void testMovementHALT_FAIL() {
		Movement next = Movement.HALT_FAIL;
		assertEquals(Movement.HALT_FAIL, next, "*HALT_FAIL* assignment fails");
	}

}
