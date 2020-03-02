package turingMachine;

public class genericDTM {
	
	private char[] alphabet;			//The DTM's alphabet
	private char blankSymbol;			//The tape's blank symbol
	public char[] tape;					//The tape array
	private state[] states;				//An array of possible states
	private int initialStateIndex;		//The start state
	private int currentStateIndex;		//The current state of the DTM
	private int tapeIndex; 				//The current location of the head
	public boolean success;				//DTM decision 
	
	public genericDTM(char[] alphabet, char blankSymbol, char[] tape, state[] states,
					  int initialStateIndex) {
		this.alphabet = alphabet;
		this.blankSymbol = blankSymbol;
		this.tape = tape;
		this.states = states;
		this.initialStateIndex = initialStateIndex;
		this.success = false; 
	}
	
	public void run() {
	/* Initialize Variables for DTM execution */
		this.tapeIndex = 0;					//Initialize the tape head's position
											//Initialize the start state
		this.currentStateIndex = initialStateIndex;   
		boolean compute = true;             //Create variable which computes until halt
		
	/* Attempt to run the DTM */
		while(compute) {
			
		/* Sanity check tape index */
			char tapeElement = '>';          //Initialize tape to garbage value
			if(tapeIndex >= tape.length) {
				compute = false;
				System.out.println("Tape Error - Tape Index >= Tape Length");
			}
			else { tapeElement = tape[tapeIndex]; }
				
		/* Sanity check tape element is in Alphabet or Blank */
			boolean inVocab = false;
			for(int i = 0; i < alphabet.length; i++)
			{
				if(tapeElement == alphabet[i] || tapeElement == blankSymbol)
				{
					inVocab = true;
					break;
				}
			}
			
			if(!inVocab) {
				compute = false;
				System.out.println("Tape Element Error - Value not in DTM's Vocab");
			}
			else { /*Do Nothing*/}
			
			
		/* Sanity check currentState index */ 
			if(currentStateIndex >= this.states.length) {
				compute = false;
				System.out.println("States Error - State Index >= Number of States");
			}
			else { /*Do Nothing*/}
			
		/* Access transition function for current state */
			state currentState = states[currentStateIndex];
			transitionFunction[] tFs = currentState.transitionFunctions;
			transitionFunction tf = null;
			
			for(int i = 0; i < tFs.length; i++) {
				if(tFs[i].input == tapeElement)
				{
					tf = tFs[i];
					break;
				}
				else { /* Do Nothing */ }
			}
			
			/* Confirm the TF exists for Tape's Value*/ 
			if( tf == null) {
				compute = false;
				System.out.println("Transfer Function Error - Input Value DNE for State");
			}
			else { 
				/* write symbol to tape*/
				this.tape[this.tapeIndex] = tf.transition.writeSymbol;
				
				/* Determine head movement */
				if(tf.transition.moveTape == Movement.LEFT) {
					if(tapeIndex > 0) {
						tapeIndex--;
					}
				}
				
				else if(tf.transition.moveTape == Movement.RIGHT) {
					if(tapeIndex < this.tape.length - 1) {
						tapeIndex++;
					}
				}
				
				else if(tf.transition.moveTape == Movement.HALT_PASS) {
					this.success = true;
					compute = false;
				}
				
				else {
					this.success = false;
					compute = false;
				}
				/* Set Next State*/
				currentStateIndex = tf.transition.nextState;
			}
				
			/*End While Loop */	
				
		}
			System.out.println("The turing machine reached a decision of: ");
			System.out.println(this.success);
			System.out.println("The output tape can be viewed below: ");
			System.out.println(this.tape);
	}
}
	


