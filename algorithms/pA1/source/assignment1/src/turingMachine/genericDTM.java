package turingMachine;

public class genericDTM {
	
	private Alphabet alphabet;			//The alphabet model
	private char blankSymbol;			//The tape's blank symbol
	public  Tape tape;					//The tape model
	private state[] states;				//An array of possible states
	private int initialStateIndex;		//The start state
	private int currentStateIndex;		//The current state of the DTM
	public boolean success;				//DTM decision 
	
	/*********************************************************************************
	 * Constructor - Constructs the Generic DTM based on DTM model
	 * 
	 *  @param alphabet - a character array modeling the alphabet
	 *  @param blankSymbol - a character modeling the tape's blank symbol
	 *  @param tape - a character array modeling the tape
	 *  @param states - an array containing Q states
	 *  @param initialStateIndex - the start state index  
	 *********************************************************************************/
	public genericDTM(char[] alphabet, char blankSymbol, char[] tape, state[] states,
					  int initialStateIndex) {
		
											/* Initialize the alphabet model			*/
		Alphabet tempAlphabet = new Alphabet(alphabet);
		this.alphabet = tempAlphabet;
		
		this.blankSymbol = blankSymbol;
		
											/* Initialize the tape model 				*/
		Tape tempTape = new Tape(tape, 0);
		this.tape = tempTape;
		
		this.states = states;
		this.initialStateIndex = initialStateIndex;
		this.success = false; 
	}
	
	
	/************************************************************************************
	 *run attempts to run the DTM for a given input 
	 *
	 ************************************************************************************/
	public void run() {
											/* Keeps track of the index of current state*/
		this.currentStateIndex = initialStateIndex;
		boolean halt = false;               /* Execute until halt                       */
		
											/* Execute the DTM until either of occurs:
											 * ... (1) System Error
											 * ... (2) Halt Condition					*/
		while(!halt) {
			
											/* Read Tape Head							*/
			char tapeElement = this.tape.readHead(); 
				
											/* Confirm Tape's Element is in Alphabet    
											 * ... or Blank Symbol 						*/			
			if(!this.alphabet.inAlphabet(tapeElement, this.blankSymbol)) {
				halt = true;
				System.out.println("Tape Element Error - Value not in DTM's Vocab");
			}
			else { /*Do Nothing*/}
			
											/* Confirm state index is within state[]	*/ 
			if(currentStateIndex >= this.states.length) {
				halt = true;
				System.out.println("States Error - State Index >= Number of States");
			}
			else { /*Do Nothing*/}
			
											/* Acquire the model for the current state  
											 * ... and identify the transition function
											 * ... for the tape head reading			*/
			state currentState = states[currentStateIndex];
			transitionFunction tf = currentState.getInputTf(tapeElement);
			/* Confirm the TF exists for Tape's Value*/ 
			if( tf == null) {
				halt = true;
				System.out.println("Transfer Function Error - Input Value DNE for State");
			}
			else { 
											/* write symbol to tape						*/
				this.tape.writeAtHead(tf.transition.writeSymbol);
				
											/* Determine head movement 					*/
				if(tf.transition.moveTape == Movement.LEFT) {
					this.tape.moveLeft(); 
				}
				
				else if(tf.transition.moveTape == Movement.RIGHT) {
					this.tape.moveRight(); 
				}
				
				else if(tf.transition.moveTape == Movement.HALT_PASS) {
					this.success = true;
					halt = true;
				}
				
				else {
					this.success = false;
					halt = true;
				}
				/* Set Next State*/
				currentStateIndex = tf.transition.nextState;
			}
				
			/*End While Loop */	
				
		}
			System.out.println("The turing machine reached a decision of: ");
			System.out.println(this.success);
			System.out.println("The output tape can be viewed below: ");
			System.out.println(this.tape.tape);
	}
}
	


