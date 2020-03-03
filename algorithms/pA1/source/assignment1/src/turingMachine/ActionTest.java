package turingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * The following class tests the Action class. 
 *
 */
class ActionTest {

	@Test
	void testAction() {
		Action NewAction =  new Action('1', Movement.LEFT, 3);
		
		assertEquals('1', NewAction.writeSymbol, "*1* assignment failed");
		assertEquals(Movement.LEFT, NewAction.moveTape, "LEFT* assignment failed");
		assertEquals(3, NewAction.nextState, "3 assignment failed");
	}

}
