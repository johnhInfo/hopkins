package turingMachine;
/******************************************************************************
 * subtractionDTM 
 * 
 * references: https://www.youtube.com/watch?v=X7bxtpNktAE
 * 
 * 
 * 
 * 
 * 
 * @author johnherrmann
 * @date 3/2/2020
 ******************************************************************************/
public class subtractionDTM {
	
	public char[] tape;				/*The tape containing input params 		 */
	
	/*************************************************************************
	 * Constructor Creates an object of the additionDTM class and initializes
	 *             ... the input tape
	 *             
	 * @param inputTape a char[] modeling an input tape 
	 *************************************************************************/
	public subtractionDTM(char[] inputTape) {
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
		 * 1. Create states Q0-Q3
		 * 2. Create the state[]
		 * 3. Initialize the DTM 
		 *******************************************************************/
		
		/********************************************************************
		 * Creation of state Q0
		 ********************************************************************/
										/* Input = 1 		THEN: 
										 *   - Write: 'b'		SIGNALS START
										 *   - Move: Right
										 *   - Next State: 1				*/
		action q0_0_action = new action('b',Movement.RIGHT, 1);
		transitionFunction tf_q0_0 = new transitionFunction('1', q0_0_action);
		
										/* Input = b 		THEN: 
										 *   - Write: 'f'		
										 *   - Move: HALT_FAIL
										 *   - Next State: 0				*/
		action q0_b_action = new action('f',Movement.HALT_FAIL, 0);
		transitionFunction tf_q0_b = new transitionFunction('b', q0_b_action);
		
										/*Create an array of transition functions 
										 *... for state Q0 					*/
		transitionFunction[] q0TFs = {tf_q0_0, tf_q0_b};
		state q0 = new state(0, q0TFs); /* Create state Q0					*/
		
		/********************************************************************
		 * Creation of state Q1
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Right
										 *   - Next State: 1				*/
		action q1_0_action = new action('0',Movement.RIGHT, 1);
		transitionFunction tf_q1_0 = new transitionFunction('0', q1_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Right
										 *   - Next State: 1				*/
		action q1_1_action = new action('1',Movement.RIGHT, 1);
		transitionFunction tf_q1_1 = new transitionFunction('1', q1_1_action);

										/* Input = b THEN: 
										 *   - Write: b
										 *   - Move: Left
										 *   - Next State: 2				*/
		action q1_b_action = new action('b',Movement.LEFT, 2);
		transitionFunction tf_q1_b = new transitionFunction('b', q1_b_action);
										/*Create an array of transition functions 
										 *... for state Q1 					*/
		transitionFunction[] q1TFs = {tf_q1_0, tf_q1_1, tf_q1_b};
		state q1 = new state(1, q1TFs);/* Create state Q1					*/
		
		/********************************************************************
		 * Creation of state Q2
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 1
										 *   - Move: Left
										 *   - Next State: HALT_PASS		*/
		action q2_0_action = new action('1',Movement.HALT_PASS, 2);
		transitionFunction tf_q2_0 = new transitionFunction('0', q2_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: b
										 *   - Move: Left
										 *   - Next State: 3				*/
		action q2_1_action = new action('b',Movement.LEFT, 3);
		transitionFunction tf_q2_1= new transitionFunction('1', q2_1_action);
		
		transitionFunction[] q2TFs = {tf_q2_1, tf_q2_0};
		state q2 = new state(2, q2TFs);
		
		/********************************************************************
		 * Creation of state Q3
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 3				*/
		action q3_0_action = new action('0',Movement.LEFT, 3);
		transitionFunction tf_q3_0 = new transitionFunction('0', q3_0_action);
		
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 3				*/
		action q3_1_action = new action('1',Movement.LEFT, 3);
		transitionFunction tf_q3_1 = new transitionFunction('1', q3_1_action);
		
										/* Input = b THEN: 
										 *   - Write: b
										 *   - Move: right
										 *   - Next State: 0				*/
		action q3_b_action = new action('b',Movement.RIGHT, 0);
		transitionFunction tf_q3_b = new transitionFunction('b', q3_b_action);
		
		transitionFunction[] q3TFs = {tf_q3_0, tf_q3_1, tf_q3_b};
		state q3 = new state(3, q3TFs);
		
		/********************************************************************
		 * Initialize the DTM 
		 ********************************************************************/
		 char[] alphabet = {'0','1','f'};
		 char blankSymbol = 'b';
		 state[] states = {q0, q1, q2, q3};
		 int initialState = 0;
		 genericDTM subtractionDTM = new genericDTM(alphabet, blankSymbol,
				                     this.tape, states, initialState);
		 /********************************************************************
		  * Execute the Example DTM
		  ********************************************************************/
		 subtractionDTM.program();
		 
		 return subtractionDTM.tape.tape; 
	}
}
