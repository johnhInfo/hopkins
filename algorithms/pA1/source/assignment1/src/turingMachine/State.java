package turingMachine;

/**
 * State class specifies a state. 
 *
 * This includes: 
 *                (1) State's Name
 *                (2) An Array of Transition Functions
 */
public class State {
	
	public int stateName;
	public TransitionFunction[] transitionFunctions;
	
	/********************************************************************
	 * Initializes an object of the "state" class
	 *
	 * @param stateName The state's name
	 * @param transitionFunctions The possible transition functions 
	 **********************************************************************/
	public State(int stateName, TransitionFunction[] transitionFunctions) {
		this.stateName = stateName;
		this.transitionFunctions = transitionFunctions;
	}
	
	/********************************************************************
	 * getInputTf Acquires the transition function for a given input
	 *
	 * @param tapeInput the character present in the under the tape head
	 **********************************************************************/
	public TransitionFunction getInputTf(char tapeInput) {
									/* Initialize output to NULL */
		TransitionFunction tf = null;
									/* Find TF for given character input */
		for(int i = 0; i < this.transitionFunctions.length; i++) {
			if(this.transitionFunctions[i].input == tapeInput)
				{
					tf = this.transitionFunctions[i];
					break;
				}
			else { /* Do Nothing */ }
		}
		
		return tf;
	}
}
