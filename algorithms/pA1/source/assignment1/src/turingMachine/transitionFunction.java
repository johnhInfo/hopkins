package turingMachine;

/**
 * transitionFunction class specifies the next state and
 * ... and action taken during the transition 
 *
 * This includes: 
 *                (1) Tape Input
 *                (2) The Action of the Transition
 */
public class transitionFunction {
	
	public char input;
	public action transition; 
	
	/**
	 * Initializes an object of the "transitionFunction" class
	 *
	 * @param input The input from the tape head 
	 * @param transition The action completed during the transition 
	 */
	public transitionFunction(char input, action transition) {
		this.input = input;
		this.transition = transition;
	}

}
