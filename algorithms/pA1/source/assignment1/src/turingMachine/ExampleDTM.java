/******************************************************************************
 * File: ExampleDTM.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;

/******************************************************************************
 * ExampleDTM Object Models Module 3's Example Turing Machine
 * 
 ******************************************************************************/
public class ExampleDTM {
	
	public GenericDTM exampleDTM;
	public char[] tape;
	/************************************************************************
	 * Constructor Initializes the ExampleDTM and provides the DTM with 
	 *             the input tape
	 * 
	 * @param tape an array that models a Turing Machine's tape 
	 ***********************************************************************/
	public ExampleDTM(char[] tape) {
		
		this.tape = tape;
		
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
		Action q0_0_action = new Action('0',Movement.RIGHT, 0);
		TransitionFunction tf_q0_0 = new TransitionFunction('0', q0_0_action);
		Action q0_1_action = new Action('1',Movement.RIGHT, 0);
		TransitionFunction tf_q0_1 = new TransitionFunction('1', q0_1_action);
		Action q0_b_action = new Action('b',Movement.LEFT, 1);
		TransitionFunction tf_q0_b = new TransitionFunction('b', q0_b_action);
		TransitionFunction[] q0TFs = {tf_q0_0, tf_q0_1, tf_q0_b};
		State q0 = new State(0, q0TFs);		
		/********************************************************************
		 * Creation of state Q1
		 ********************************************************************/
		Action q1_0_action = new Action('b',Movement.LEFT, 2);
		TransitionFunction tf_q1_0 = new TransitionFunction('0', q1_0_action);
		Action q1_1_action = new Action('b',Movement.LEFT, 3);
		TransitionFunction tf_q1_1 = new TransitionFunction('1', q1_1_action);
		Action q1_b_action = new Action('b',Movement.HALT_FAIL, 4);	
		TransitionFunction tf_q1_b = new TransitionFunction('b', q1_b_action);
		TransitionFunction[] q1TFs = {tf_q1_0, tf_q1_1, tf_q1_b};
		State q1 = new State(1, q1TFs);		
		/********************************************************************
		 * Creation of state Q2
		 ********************************************************************/
		Action q2_0_action = new Action('b',Movement.HALT_PASS, 5);
		TransitionFunction tf_q2_0 = new TransitionFunction('0', q2_0_action);
		Action q2_1_action = new Action('b',Movement.HALT_FAIL, 4);
		TransitionFunction tf_q2_1 = new TransitionFunction('1', q2_1_action);
		Action q2_b_action = new Action('b',Movement.HALT_FAIL, 4);
		TransitionFunction tf_q2_b = new TransitionFunction('b', q2_b_action);
		TransitionFunction[] q2TFs = {tf_q2_0, tf_q2_1, tf_q2_b};
		State q2 = new State(2, q2TFs);
		/********************************************************************
		 * Creation of state Q3
		 ********************************************************************/
		Action q3_0_action = new Action('b',Movement.HALT_FAIL, 4);
		TransitionFunction tf_q3_0 = new TransitionFunction('0', q3_0_action);
		Action q3_1_action = new Action('b',Movement.HALT_FAIL, 4);
		TransitionFunction tf_q3_1 = new TransitionFunction('1', q3_1_action);
		Action q3_b_action = new Action('b',Movement.HALT_FAIL, 4);
		TransitionFunction tf_q3_b = new TransitionFunction('b', q3_b_action);
		TransitionFunction[] q3TFs = {tf_q3_0, tf_q3_1, tf_q3_b};
		State q3 = new State(3, q3TFs);
		/********************************************************************
		 * Initialize the DTM 
		 ********************************************************************/
		 char[] alphabet = {'0','1'};
		 char blankSymbol = 'b';
		 State[] states = {q0, q1, q2, q3};
		 int initialState = 0;
		 this.exampleDTM = new GenericDTM(alphabet, blankSymbol,
				                     this.tape, states, initialState);
	}
	/************************************************************************
	 * program Executes the ExampleDTM Turing Machine for a given input 
	 * 
	 ***********************************************************************/
	public char[] program() 
	{	
		exampleDTM.program();
		return this.tape;
	}

}
	