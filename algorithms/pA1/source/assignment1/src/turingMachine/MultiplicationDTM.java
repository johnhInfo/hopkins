/******************************************************************************
 * File: MultiplicationDTM.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;
/******************************************************************************
 * multiplicationDTM 
 * 
 * The following class emulates a Turing machine which multiplies unary
 * inputs
 * 
 * References: https://www.youtube.com/watch?v=3mrMqNe0MUY
 * 
 * Input Tape Format : 111101110bbbbbbb (represents 4*3)
 * 					   |__| |_| |_____|
 *                       x   y     z
 *                       
 *                     x - First operand
 *                     y - Second operand
 *                     z - Tape where result is stored
 *                     
 *                     1- Consecutive 1's represent a unary number
 *                     0- Acts as a delimeter between numbers and blank cells
 *                     b- Constitute a blank cell
 *                     
 * Output Format : The result is the unary number immediately following the
 *                 last zero present in the input. For example:
 *                 
 *                 bb1101111111111bbbbbbb -> would represent a 10 in decimal
 *                      |________|
 *                        Ten 1's
 * @author johnherrmann
 * @date 3/3/2020
 ******************************************************************************/
public class MultiplicationDTM {
	
	public char[] tape;				/*The tape containing input params 		 */
	
	/*************************************************************************
	 * Constructor Creates an object of the multiplicaitonDTM class and initializes
	 *             ... the input tape
	 *             
	 * @param inputTape a char[] modeling an input tape 
	 *************************************************************************/
	public MultiplicationDTM(char[] inputTape) {
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
		Action q0_1_action = new Action('b',Movement.RIGHT, 1);
		TransitionFunction tf_q0_1 = new TransitionFunction('1', q0_1_action);
		
										/* Input = b 		THEN: 
										 *   - Write: 'f'		
										 *   - Move: HALT_FAIL
										 *   - Next State: 0				*/
		Action q0_b_action = new Action('f',Movement.HALT_FAIL, 0);
		TransitionFunction tf_q0_b = new TransitionFunction('b', q0_b_action);
		
										/* Input = 0 		THEN: 
										 *   - Write: 'b'		
										 *   - Move: Right
										 *   - Next State: 6				*/
		Action q0_0_action = new Action('b',Movement.RIGHT, 6);
		TransitionFunction tf_q0_0 = new TransitionFunction('0', q0_0_action);
		
										/*Create an array of transition functions 
										 *... for state Q0 					*/
		TransitionFunction[] q0TFs = {tf_q0_0, tf_q0_b, tf_q0_1};
		State q0 = new State(0, q0TFs); /* Create state Q0					*/
		
		/********************************************************************
		 * Creation of state Q1
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Right
										 *   - Next State: 2				*/
		Action q1_0_action = new Action('0',Movement.RIGHT, 2);
		TransitionFunction tf_q1_0 = new TransitionFunction('0', q1_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Right
										 *   - Next State: 1				*/
		Action q1_1_action = new Action('1',Movement.RIGHT, 1);
		TransitionFunction tf_q1_1 = new TransitionFunction('1', q1_1_action);

										/*Create an array of transition functions 
										 *... for state Q1 					*/
		TransitionFunction[] q1TFs = {tf_q1_0, tf_q1_1};
		State q1 = new State(1, q1TFs);/* Create state Q1					*/
		
		/********************************************************************
		 * Creation of state Q2
		 ********************************************************************/
										/* Input = 1 THEN: 
										 *   - Write: y
										 *   - Move: Right
										 *   - Next State: 3		*/
		Action q2_1_action = new Action('y',Movement.RIGHT, 3);
		TransitionFunction tf_q2_1 = new TransitionFunction('1', q2_1_action);
		
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 5				*/
		Action q2_0_action = new Action('0',Movement.LEFT, 5);
		TransitionFunction tf_q2_0= new TransitionFunction('0', q2_0_action);
		
		TransitionFunction[] q2TFs = {tf_q2_0, tf_q2_1};
		State q2 = new State(2, q2TFs);
		
		/********************************************************************
		 * Creation of state Q3
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Right
										 *   - Next State: 3				*/
		Action q3_0_action = new Action('0',Movement.RIGHT, 3);
		TransitionFunction tf_q3_0 = new TransitionFunction('0', q3_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Right
										 *   - Next State: 3				*/
		Action q3_1_action = new Action('1',Movement.RIGHT, 3);
		TransitionFunction tf_q3_1 = new TransitionFunction('1', q3_1_action);
		
										/* Input = b THEN: 
										 *   - Write: 1
										 *   - Move: left
										 *   - Next State: 4				*/
		Action q3_b_action = new Action('1',Movement.LEFT, 4);
		TransitionFunction tf_q3_b = new TransitionFunction('b', q3_b_action);
		
		TransitionFunction[] q3TFs = {tf_q3_0, tf_q3_1, tf_q3_b};
		State q3 = new State(3, q3TFs);
		
		/********************************************************************
		 * Creation of state Q4
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 4				*/
		Action q4_0_action = new Action('0',Movement.LEFT, 4);
		TransitionFunction tf_q4_0 = new TransitionFunction('0', q4_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Left
										 *   - Next State: 4				*/
		Action q4_1_action = new Action('1',Movement.LEFT, 4);
		TransitionFunction tf_q4_1 = new TransitionFunction('1', q4_1_action);
		
										/* Input = y THEN: 
										 *   - Write: y
										 *   - Move: right
										 *   - Next State: 2				*/
		Action q4_y_action = new Action('y',Movement.RIGHT, 2);
		TransitionFunction tf_q4_y = new TransitionFunction('y', q4_y_action);
		
		TransitionFunction[] q4TFs = {tf_q4_0, tf_q4_1, tf_q4_y};
		State q4 = new State(4, q4TFs);
		
		/********************************************************************
		 * Creation of state Q5
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 5				*/
		Action q5_0_action = new Action('0',Movement.LEFT, 5);
		TransitionFunction tf_q5_0 = new TransitionFunction('0', q5_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Left
										 *   - Next State: 5				*/
		Action q5_1_action = new Action('1',Movement.LEFT, 5);
		TransitionFunction tf_q5_1 = new TransitionFunction('1', q5_1_action);
		
										/* Input = y THEN: 
										 *   - Write: 1
										 *   - Move: Left
										 *   - Next State: 2				*/
		Action q5_y_action = new Action('1',Movement.LEFT, 5);
		TransitionFunction tf_q5_y = new TransitionFunction('y', q5_y_action);
		
										/* Input = b THEN: 
										 *   - Write: b
										 *   - Move: right
										 *   - Next State: 0				*/
		Action q5_b_action = new Action('b',Movement.RIGHT, 0);
		TransitionFunction tf_q5_b = new TransitionFunction('b', q5_b_action);
		
		
		TransitionFunction[] q5TFs = {tf_q5_0, tf_q5_1, tf_q5_y, tf_q5_b};
		State q5 = new State(5, q5TFs);
		
		
		/********************************************************************
		 * Creation of state Q6
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: b
										 *   - Move: Right
										 *   - Next State: HALT_PASS		*/
		Action q6_0_action = new Action('b',Movement.HALT_PASS, 7);
		TransitionFunction tf_q6_0 = new TransitionFunction('0', q6_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: B
										 *   - Move: Right
										 *   - Next State: 6				*/
		Action q6_1_action = new Action('b',Movement.LEFT, 6);
		TransitionFunction tf_q6_1 = new TransitionFunction('1', q6_1_action);
		
		TransitionFunction[] q6TFs = {tf_q6_0, tf_q6_1};
		State q6 = new State(6, q6TFs);
		
		
		/********************************************************************
		 * Initialize the DTM 
		 ********************************************************************/
		 char[] alphabet = {'0','1','y','f'};
		 char blankSymbol = 'b';
		 State[] states = {q0, q1, q2, q3, q4, q5, q6};
		 int initialState = 0;
		 GenericDTM multiplicationDTM = new GenericDTM(alphabet, blankSymbol,
				                     this.tape, states, initialState);
		 /********************************************************************
		  * Execute the DTM
		  ********************************************************************/
		 multiplicationDTM.program();
		 
		 return multiplicationDTM.tape.tape; 
	}
}
