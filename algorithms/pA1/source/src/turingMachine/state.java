package turingMachine;

/**
 * State class specifies a state. 
 *
 * This includes: 
 *                (1) State's Name
 *                (2) An Array of Transition Functions
 */
public class state {
	
	public int stateName;
	public transitionFunction[] transitionFunctions;
	
	/**
	 * Initializes an object of the "state" class
	 *
	 * @param stateName The state's name
	 * @param transitionFunctions The possible transition functions 
	 */
	public state(int stateName, transitionFunction[] transitionFunctions) {
		this.stateName = stateName;
		this.transitionFunctions = transitionFunctions;
	}

}
