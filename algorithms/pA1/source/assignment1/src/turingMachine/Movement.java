package turingMachine;

/**
 * Specifies the next movement for the Turing machine's head 
 *
 * RIGHT move the head to the right 
 * LEFT  move the heat to the left 
 * HALT_PASS halt the head and return "PASS"
 * HALT_FAIL halt the head and return "FAIL"
 */
public enum Movement {
	RIGHT,
	LEFT,
	HALT_PASS,
	HALT_FAIL
}

