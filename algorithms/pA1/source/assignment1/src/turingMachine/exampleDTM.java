package turingMachine;

public class exampleDTM {
	
	public static void main(String[] args) {
		
		/********************************************************************
		 * Control Flow:
		 * 1. Create states Q0-Q5
		 * 2. Create the state[]
		 * 3. Initialize the DTM 
		 * 4. Run the DTM
		 *******************************************************************/
		
		/********************************************************************
		 * Creation of state Q0
		 ********************************************************************/
		action q0_0_action = new action('0',Movement.RIGHT, 0);
		transitionFunction tf_q0_0 = new transitionFunction('0', q0_0_action);
		action q0_1_action = new action('1',Movement.RIGHT, 0);
		transitionFunction tf_q0_1 = new transitionFunction('1', q0_1_action);
		action q0_b_action = new action('b',Movement.LEFT, 1);
		transitionFunction tf_q0_b = new transitionFunction('b', q0_b_action);
		transitionFunction[] q0TFs = {tf_q0_0, tf_q0_1, tf_q0_b};
		state q0 = new state(0, q0TFs);		
		/********************************************************************
		 * Creation of state Q1
		 ********************************************************************/
		action q1_0_action = new action('b',Movement.LEFT, 2);
		transitionFunction tf_q1_0 = new transitionFunction('0', q1_0_action);
		action q1_1_action = new action('b',Movement.LEFT, 3);
		transitionFunction tf_q1_1 = new transitionFunction('1', q1_1_action);
		action q1_b_action = new action('b',Movement.HALT_FAIL, 4);	
		transitionFunction tf_q1_b = new transitionFunction('b', q1_b_action);
		transitionFunction[] q1TFs = {tf_q1_0, tf_q1_1, tf_q1_b};
		state q1 = new state(1, q1TFs);		
		/********************************************************************
		 * Creation of state Q2
		 ********************************************************************/
		action q2_0_action = new action('b',Movement.HALT_PASS, 5);
		transitionFunction tf_q2_0 = new transitionFunction('0', q2_0_action);
		action q2_1_action = new action('b',Movement.HALT_FAIL, 4);
		transitionFunction tf_q2_1 = new transitionFunction('1', q2_1_action);
		action q2_b_action = new action('b',Movement.HALT_FAIL, 4);
		transitionFunction tf_q2_b = new transitionFunction('b', q2_b_action);
		transitionFunction[] q2TFs = {tf_q2_0, tf_q2_1, tf_q2_b};
		state q2 = new state(2, q2TFs);
		/********************************************************************
		 * Creation of state Q3
		 ********************************************************************/
		action q3_0_action = new action('b',Movement.HALT_FAIL, 4);
		transitionFunction tf_q3_0 = new transitionFunction('0', q3_0_action);
		action q3_1_action = new action('b',Movement.HALT_FAIL, 4);
		transitionFunction tf_q3_1 = new transitionFunction('1', q3_1_action);
		action q3_b_action = new action('b',Movement.HALT_FAIL, 4);
		transitionFunction tf_q3_b = new transitionFunction('b', q3_b_action);
		transitionFunction[] q3TFs = {tf_q3_0, tf_q3_1, tf_q3_b};
		state q3 = new state(3, q3TFs);
		/********************************************************************
		 * Initialize the DTM 
		 ********************************************************************/
		 char[] alphabet = {'0','1'};
		 char blankSymbol = 'b';
		 char[] tape = {'1', '0', '1', '0', '0', 'b', 'b'};
		 state[] states = {q0, q1, q2, q3};
		 int initialState = 0;
		 genericDTM mod3exampleDTM = new genericDTM(alphabet, blankSymbol,
				                     tape, states, initialState);
		 /********************************************************************
		  * Execute the Example DTM
		  ********************************************************************/
		 mod3exampleDTM.run();
		 
	}

}
	