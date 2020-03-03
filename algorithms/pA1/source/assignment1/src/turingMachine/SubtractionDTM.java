/******************************************************************************
 * File: SubtractionDTM.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/

package turingMachine;
/******************************************************************************
 * subtractionDTM Object models a Turing Machine that completes subtraction
 *                ... of two unary numbers  
 * 
 * references: https://www.youtube.com/watch?v=X7bxtpNktAE
 * 
 * @author johnherrmann
 * @date 3/2/2020
 ******************************************************************************/
public class SubtractionDTM {
	
	public char[] tape;				/*The tape containing input params 		 */
	
	/*************************************************************************
	 * Constructor Creates an object of the subtractionDTM class and initializes
	 *             ... the input tape
	 *             
	 * @param inputTape a char[] modeling an input tape 
	 *************************************************************************/
	public SubtractionDTM(char[] inputTape) {
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
		Action q0_0_action = new Action('b',Movement.RIGHT, 1);
		TransitionFunction tf_q0_0 = new TransitionFunction('1', q0_0_action);
		
										/* Input = b 		THEN: 
										 *   - Write: 'f'		
										 *   - Move: HALT_FAIL
										 *   - Next State: 0				*/
		Action q0_b_action = new Action('f',Movement.HALT_FAIL, 0);
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
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Right
										 *   - Next State: 1				*/
		Action q1_1_action = new Action('1',Movement.RIGHT, 1);
		TransitionFunction tf_q1_1 = new TransitionFunction('1', q1_1_action);

										/* Input = b THEN: 
										 *   - Write: b
										 *   - Move: Left
										 *   - Next State: 2				*/
		Action q1_b_action = new Action('b',Movement.LEFT, 2);
		TransitionFunction tf_q1_b = new TransitionFunction('b', q1_b_action);
										/*Create an array of transition functions 
										 *... for state Q1 					*/
		TransitionFunction[] q1TFs = {tf_q1_0, tf_q1_1, tf_q1_b};
		State q1 = new State(1, q1TFs);/* Create state Q1					*/
		
		/********************************************************************
		 * Creation of state Q2
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 1
										 *   - Move: Left
										 *   - Next State: HALT_PASS		*/
		Action q2_0_action = new Action('1',Movement.HALT_PASS, 2);
		TransitionFunction tf_q2_0 = new TransitionFunction('0', q2_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: b
										 *   - Move: Left
										 *   - Next State: 3				*/
		Action q2_1_action = new Action('b',Movement.LEFT, 3);
		TransitionFunction tf_q2_1= new TransitionFunction('1', q2_1_action);
		
		TransitionFunction[] q2TFs = {tf_q2_1, tf_q2_0};
		State q2 = new State(2, q2TFs);
		
		/********************************************************************
		 * Creation of state Q3
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 3				*/
		Action q3_0_action = new Action('0',Movement.LEFT, 3);
		TransitionFunction tf_q3_0 = new TransitionFunction('0', q3_0_action);
		
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 3				*/
		Action q3_1_action = new Action('1',Movement.LEFT, 3);
		TransitionFunction tf_q3_1 = new TransitionFunction('1', q3_1_action);
		
										/* Input = b THEN: 
										 *   - Write: b
										 *   - Move: right
										 *   - Next State: 0				*/
		Action q3_b_action = new Action('b',Movement.RIGHT, 0);
		TransitionFunction tf_q3_b = new TransitionFunction('b', q3_b_action);
		
		TransitionFunction[] q3TFs = {tf_q3_0, tf_q3_1, tf_q3_b};
		State q3 = new State(3, q3TFs);
		
		/********************************************************************
		 * Initialize the DTM 
		 ********************************************************************/
		 char[] alphabet = {'0','1','f'};
		 char blankSymbol = 'b';
		 State[] states = {q0, q1, q2, q3};
		 int initialState = 0;
		 GenericDTM subtractionDTM = new GenericDTM(alphabet, blankSymbol,
				                     this.tape, states, initialState);
		 /********************************************************************
		  * Execute the subtractionDTM 
		  ********************************************************************/
		 subtractionDTM.program();
		 
		 return subtractionDTM.tape.tape; 
	}
}
