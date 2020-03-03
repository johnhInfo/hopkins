package turingMachine;
/**
 * Action class specifies a specific state's action. 
 *
 * This includes: 
 *                (1) Write Symbol
 *                (2) Direction of Tape Movement
 *                (3) The next state
 */
public class Action {
	
	public char writeSymbol; 
	public Movement moveTape;
	public int nextState;
	
	/**
	 * Initializes an object of the "action" class
	 *
	 * @param writeSymbol The character in alphabet Gamma to be written
	 *                    to the tape 
	 * @param moveTape    The direction of tape head movement
	 * @param nextState   The next state in the control machine 
	 */
	public Action(char writeSymbol, Movement moveTape, int nextState) {
		this.writeSymbol = writeSymbol;
		this.moveTape = moveTape;
		this.nextState = nextState;
	}

}
