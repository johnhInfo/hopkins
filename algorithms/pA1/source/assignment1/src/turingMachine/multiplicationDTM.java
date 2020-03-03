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
public class multiplicationDTM {
	
	public char[] tape;				/*The tape containing input params 		 */
	
	/*************************************************************************
	 * Constructor Creates an object of the multiplicaitonDTM class and initializes
	 *             ... the input tape
	 *             
	 * @param inputTape a char[] modeling an input tape 
	 *************************************************************************/
	public multiplicationDTM(char[] inputTape) {
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
		action q0_1_action = new action('b',Movement.RIGHT, 1);
		transitionFunction tf_q0_1 = new transitionFunction('1', q0_1_action);
		
										/* Input = b 		THEN: 
										 *   - Write: 'f'		
										 *   - Move: HALT_FAIL
										 *   - Next State: 0				*/
		action q0_b_action = new action('f',Movement.HALT_FAIL, 0);
		transitionFunction tf_q0_b = new transitionFunction('b', q0_b_action);
		
										/* Input = 0 		THEN: 
										 *   - Write: 'b'		
										 *   - Move: Right
										 *   - Next State: 6				*/
		action q0_0_action = new action('b',Movement.RIGHT, 6);
		transitionFunction tf_q0_0 = new transitionFunction('0', q0_0_action);
		
										/*Create an array of transition functions 
										 *... for state Q0 					*/
		transitionFunction[] q0TFs = {tf_q0_0, tf_q0_b, tf_q0_1};
		state q0 = new state(0, q0TFs); /* Create state Q0					*/
		
		/********************************************************************
		 * Creation of state Q1
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Right
										 *   - Next State: 2				*/
		action q1_0_action = new action('0',Movement.RIGHT, 2);
		transitionFunction tf_q1_0 = new transitionFunction('0', q1_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Right
										 *   - Next State: 1				*/
		action q1_1_action = new action('1',Movement.RIGHT, 1);
		transitionFunction tf_q1_1 = new transitionFunction('1', q1_1_action);

										/*Create an array of transition functions 
										 *... for state Q1 					*/
		transitionFunction[] q1TFs = {tf_q1_0, tf_q1_1};
		state q1 = new state(1, q1TFs);/* Create state Q1					*/
		
		/********************************************************************
		 * Creation of state Q2
		 ********************************************************************/
										/* Input = 1 THEN: 
										 *   - Write: y
										 *   - Move: Right
										 *   - Next State: 3		*/
		action q2_1_action = new action('y',Movement.RIGHT, 3);
		transitionFunction tf_q2_1 = new transitionFunction('1', q2_1_action);
		
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 5				*/
		action q2_0_action = new action('0',Movement.LEFT, 5);
		transitionFunction tf_q2_0= new transitionFunction('0', q2_0_action);
		
		transitionFunction[] q2TFs = {tf_q2_0, tf_q2_1};
		state q2 = new state(2, q2TFs);
		
		/********************************************************************
		 * Creation of state Q3
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Right
										 *   - Next State: 3				*/
		action q3_0_action = new action('0',Movement.RIGHT, 3);
		transitionFunction tf_q3_0 = new transitionFunction('0', q3_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Right
										 *   - Next State: 3				*/
		action q3_1_action = new action('1',Movement.RIGHT, 3);
		transitionFunction tf_q3_1 = new transitionFunction('1', q3_1_action);
		
										/* Input = b THEN: 
										 *   - Write: 1
										 *   - Move: left
										 *   - Next State: 4				*/
		action q3_b_action = new action('1',Movement.LEFT, 4);
		transitionFunction tf_q3_b = new transitionFunction('b', q3_b_action);
		
		transitionFunction[] q3TFs = {tf_q3_0, tf_q3_1, tf_q3_b};
		state q3 = new state(3, q3TFs);
		
		/********************************************************************
		 * Creation of state Q4
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 4				*/
		action q4_0_action = new action('0',Movement.LEFT, 4);
		transitionFunction tf_q4_0 = new transitionFunction('0', q4_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Left
										 *   - Next State: 4				*/
		action q4_1_action = new action('1',Movement.LEFT, 4);
		transitionFunction tf_q4_1 = new transitionFunction('1', q4_1_action);
		
										/* Input = y THEN: 
										 *   - Write: y
										 *   - Move: right
										 *   - Next State: 2				*/
		action q4_y_action = new action('y',Movement.RIGHT, 2);
		transitionFunction tf_q4_y = new transitionFunction('y', q4_y_action);
		
		transitionFunction[] q4TFs = {tf_q4_0, tf_q4_1, tf_q4_y};
		state q4 = new state(4, q4TFs);
		
		/********************************************************************
		 * Creation of state Q5
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 5				*/
		action q5_0_action = new action('0',Movement.LEFT, 5);
		transitionFunction tf_q5_0 = new transitionFunction('0', q5_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: 1
										 *   - Move: Left
										 *   - Next State: 5				*/
		action q5_1_action = new action('1',Movement.LEFT, 5);
		transitionFunction tf_q5_1 = new transitionFunction('1', q5_1_action);
		
										/* Input = y THEN: 
										 *   - Write: 1
										 *   - Move: Left
										 *   - Next State: 2				*/
		action q5_y_action = new action('1',Movement.LEFT, 5);
		transitionFunction tf_q5_y = new transitionFunction('y', q5_y_action);
		
										/* Input = b THEN: 
										 *   - Write: b
										 *   - Move: right
										 *   - Next State: 0				*/
		action q5_b_action = new action('b',Movement.RIGHT, 0);
		transitionFunction tf_q5_b = new transitionFunction('b', q5_b_action);
		
		
		transitionFunction[] q5TFs = {tf_q5_0, tf_q5_1, tf_q5_y, tf_q5_b};
		state q5 = new state(5, q5TFs);
		
		
		/********************************************************************
		 * Creation of state Q6
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: b
										 *   - Move: Right
										 *   - Next State: HALT_PASS		*/
		action q6_0_action = new action('b',Movement.HALT_PASS, 7);
		transitionFunction tf_q6_0 = new transitionFunction('0', q6_0_action);
		
										/* Input = 1 THEN: 
										 *   - Write: B
										 *   - Move: Right
										 *   - Next State: 6				*/
		action q6_1_action = new action('b',Movement.LEFT, 6);
		transitionFunction tf_q6_1 = new transitionFunction('1', q6_1_action);
		
		transitionFunction[] q6TFs = {tf_q6_0, tf_q6_1};
		state q6 = new state(6, q6TFs);
		
		
		/********************************************************************
		 * Initialize the DTM 
		 ********************************************************************/
		 char[] alphabet = {'0','1','y','f'};
		 char blankSymbol = 'b';
		 state[] states = {q0, q1, q2, q3, q4, q5, q6};
		 int initialState = 0;
		 genericDTM multiplicationDTM = new genericDTM(alphabet, blankSymbol,
				                     this.tape, states, initialState);
		 /********************************************************************
		  * Execute the DTM
		  ********************************************************************/
		 multiplicationDTM.program();
		 
		 return multiplicationDTM.tape.tape; 
	}
}
