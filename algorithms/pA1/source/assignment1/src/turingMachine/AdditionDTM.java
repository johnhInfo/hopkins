package turingMachine;
/******************************************************************************
 * additionDTM 
 * 
 * references: https://www.geeksforgeeks.org/turing-machine-addition/
 * 
 * 
 * @author johnherrmann
 * @date 3/2/2020
 ******************************************************************************/
public class AdditionDTM {
	
	public char[] tape;				/*The tape containing input params 		 */
	
	/*************************************************************************
	 * Constructor Creates an object of the additionDTM class and initializes
	 *             ... the input tape
	 *             
	 * @param inputTape a char[] modeling an input tape 
	 *************************************************************************/
	public AdditionDTM(char[] inputTape) {
		this.tape = inputTape;		
	}
	
	/*************************************************************************
	 * program The program method takes the inputTape stored during object
	 *         ...initialization and attempts to execute the DTM
	 * 
	 * @return char[] the output tape 
	 ************************************************************************/
	public char[] program()
	{
		/********************************************************************
		 * Control Flow:
		 * 1. Create states Q0-Q4
		 * 2. Create the state[]
		 * 3. Initialize the DTM 
		 * 4. Run the DTM
		 *******************************************************************/
		
		/********************************************************************
		 * Creation of state Q0
		 ********************************************************************/
										/* Input = 0 		THEN: 
										 *   - Write: 'X'		SIGNALS START
										 *   - Move: Right
										 *   - Next State: 1				*/
		Action q0_0_action = new Action('x',Movement.RIGHT, 1);
		TransitionFunction tf_q0_0 = new TransitionFunction('0', q0_0_action);
		
										/* Input = B 		THEN: 
										 *   - Write: 'f'		SIGNALS FAIL
										 *   - Move: HALT
										 *   - Next State: 5				*/
		Action q0_b_action = new Action('f',Movement.HALT_FAIL, 5);
		TransitionFunction tf_q0_b = new TransitionFunction('b', q0_b_action);
		
										/*Create an array of transition functions 
										 *... for state Q0 					*/
		TransitionFunction[] q0TFs = {tf_q0_0, tf_q0_b};
		State q0 = new State(0, q0TFs); /* Create state Q0					*/
		
		/********************************************************************
		 * Creation of state Q1
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Right
										 *   - Next State: 1				*/
		Action q1_0_action = new Action('0',Movement.RIGHT, 1);
		TransitionFunction tf_q1_0 = new TransitionFunction('0', q1_0_action);
		
										/* Input = B THEN: 
										 *   - Write: B
										 *   - Move: Right
										 *   - Next State: 2				*/
		Action q1_b_action = new Action('b',Movement.RIGHT, 2);
		TransitionFunction tf_q1_b = new TransitionFunction('b', q1_b_action);
										/*Create an array of transition functions 
										 *... for state Q1 					*/
		TransitionFunction[] q1TFs = {tf_q1_0, tf_q1_b};
		State q1 = new State(1, q1TFs);/* Create state Q1					*/
		
		/********************************************************************
		 * Creation of state Q2
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Right
										 *   - Next State: 2				*/
		Action q2_0_action = new Action('0',Movement.RIGHT, 2);
		TransitionFunction tf_q2_0 = new TransitionFunction('0', q2_0_action);
		
										/* Input = B THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 3				*/
		Action q2_b_action = new Action('b',Movement.LEFT, 3);
		TransitionFunction tf_q2_b = new TransitionFunction('b', q2_b_action);
		
		TransitionFunction[] q2TFs = {tf_q2_0, tf_q2_b};
		State q2 = new State(2, q2TFs);
		
		/********************************************************************
		 * Creation of state Q3
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Left
										 *   - Next State: 3				*/
		Action q3_0_action = new Action('0',Movement.LEFT, 3);
		TransitionFunction tf_q3_0 = new TransitionFunction('0', q3_0_action);
		
										/* Input = B THEN: 
										 *   - Write: B
										 *   - Move: Left
										 *   - Next State: 4				*/
		Action q3_b_action = new Action('0',Movement.LEFT, 4);
		TransitionFunction tf_q3_b = new TransitionFunction('b', q3_b_action);
		
		TransitionFunction[] q3TFs = {tf_q3_0, tf_q3_b};
		State q3 = new State(3, q3TFs);
		
		/********************************************************************
		 * Creation of state Q4
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Left
										 *   - Next State: 4				*/
		Action q4_0_action = new Action('0',Movement.LEFT, 4);
		TransitionFunction tf_q4_0 = new TransitionFunction('0', q4_0_action);
		
										/* Input = X THEN: 
										 *   - Write: "P"
										 *   - Move: HALT PASS
										 *   - Next State: 0				*/
		Action q4_x_action = new Action('p',Movement.HALT_PASS, 0);
		TransitionFunction tf_q4_x = new TransitionFunction('x', q4_x_action);
		
		TransitionFunction[] q4TFs = {tf_q4_0, tf_q4_x};
		State q4 = new State(4, q4TFs);
		
		/********************************************************************
		 * Initialize the DTM 
		 ********************************************************************/
		 char[] alphabet = {'0','x','p','f',};
		 char blankSymbol = 'b';
		 //char[] tape = {'0', 'b', '0','b'};
		 State[] states = {q0, q1, q2, q3, q4};
		 int initialState = 0;
		 GenericDTM additionDTM = new GenericDTM(alphabet, blankSymbol,
				                     this.tape, states, initialState);
		 /********************************************************************
		  * Execute the Example DTM
		  ********************************************************************/
		 additionDTM.program();
		 
		 return additionDTM.tape.tape; 
	}
}
