package turingMachine;

public class additionDTM {
	
public static void main(String[] args) {
		
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
		action q0_0_action = new action('x',Movement.RIGHT, 1);
		transitionFunction tf_q0_0 = new transitionFunction('0', q0_0_action);
		
										/* Input = B 		THEN: 
										 *   - Write: 'f'		SIGNALS FAIL
										 *   - Move: HALT
										 *   - Next State: 5				*/
		action q0_b_action = new action('f',Movement.HALT_FAIL, 5);
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
		
										/* Input = B THEN: 
										 *   - Write: B
										 *   - Move: Right
										 *   - Next State: 2				*/
		action q1_b_action = new action('b',Movement.RIGHT, 2);
		transitionFunction tf_q1_b = new transitionFunction('b', q1_b_action);
										/*Create an array of transition functions 
										 *... for state Q1 					*/
		transitionFunction[] q1TFs = {tf_q1_0, tf_q1_b};
		state q1 = new state(1, q1TFs);/* Create state Q1					*/
		
		/********************************************************************
		 * Creation of state Q2
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Right
										 *   - Next State: 2				*/
		action q2_0_action = new action('0',Movement.RIGHT, 2);
		transitionFunction tf_q2_0 = new transitionFunction('0', q2_0_action);
		
										/* Input = B THEN: 
										 *   - Write: 0
										 *   - Move: Left
										 *   - Next State: 3				*/
		action q2_b_action = new action('b',Movement.LEFT, 3);
		transitionFunction tf_q2_b = new transitionFunction('b', q2_b_action);
		
		transitionFunction[] q2TFs = {tf_q2_0, tf_q2_b};
		state q2 = new state(2, q2TFs);
		
		/********************************************************************
		 * Creation of state Q3
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Left
										 *   - Next State: 3				*/
		action q3_0_action = new action('0',Movement.LEFT, 3);
		transitionFunction tf_q3_0 = new transitionFunction('0', q3_0_action);
		
										/* Input = B THEN: 
										 *   - Write: B
										 *   - Move: Left
										 *   - Next State: 4				*/
		action q3_b_action = new action('0',Movement.LEFT, 4);
		transitionFunction tf_q3_b = new transitionFunction('b', q3_b_action);
		
		transitionFunction[] q3TFs = {tf_q3_0, tf_q3_b};
		state q3 = new state(3, q3TFs);
		
		/********************************************************************
		 * Creation of state Q4
		 ********************************************************************/
										/* Input = 0 THEN: 
										 *   - Write: Zero
										 *   - Move: Left
										 *   - Next State: 4				*/
		action q4_0_action = new action('0',Movement.LEFT, 4);
		transitionFunction tf_q4_0 = new transitionFunction('0', q4_0_action);
		
										/* Input = X THEN: 
										 *   - Write: "P"
										 *   - Move: HALT PASS
										 *   - Next State: 0				*/
		action q4_x_action = new action('p',Movement.HALT_PASS, 0);
		transitionFunction tf_q4_x = new transitionFunction('x', q4_x_action);
		
		transitionFunction[] q4TFs = {tf_q4_0, tf_q4_x};
		state q4 = new state(4, q4TFs);
		
		/********************************************************************
		 * Initialize the DTM 
		 ********************************************************************/
		 char[] alphabet = {'0','x','p','f',};
		 char blankSymbol = 'b';
		 char[] tape = {'0', 'b', '0','b'};
		 state[] states = {q0, q1, q2, q3, q4};
		 int initialState = 0;
		 genericDTM additionDTM = new genericDTM(alphabet, blankSymbol,
				                     tape, states, initialState);
		 /********************************************************************
		  * Execute the Example DTM
		  ********************************************************************/
		 additionDTM.program();
		 
	}


}
