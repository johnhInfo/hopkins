package turingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * The following class tests the transitionFunction class. 
 *
 */
class transitionFunctionTest {

	@Test
	void test() {
		
		action newAction =  new action('1', Movement.LEFT, 3);
		
		transitionFunction tf = new transitionFunction('1', newAction);
			
		assertEquals('1', tf.input, "*1* assignment failed");
		assertEquals('1', tf.transition.writeSymbol, "*1* assignment failed");
		assertEquals(Movement.LEFT, tf.transition.moveTape, "LEFT* assignment failed");
		assertEquals(3, tf.transition.nextState, "3 assignment failed");
		
		
		}
	}

