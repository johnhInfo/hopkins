/******************************************************************************
 * File: MultiplicationDTMTest.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package turingMachine;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
/******************************************************************************
 * multiplicationDTMTest
 * 
 * Executes the multiplicationDTM under four tests cases: 
 * (1) 2*3
 * (2) 3*3
 * (3) 7*2
 * (4) 4*4
 * 
 * 
 * Additional tests cases to be added: 
 * (1) Failure analysis of bad input tapes to confirm robust error checking
 * 
 * @date 3/3/2020
 ******************************************************************************/
class MultiplicationDTMTest {
	/***********************************************************
	 * Test 1: 2*3
	 ***********************************************************/
	@Test
	void testCase1() {
		 char[] tape = {'1', '1','0','1','1','1','0','b','b','b','b','b','b','b','b','b','b','b','b'};
		 char[] success = {'b','b','b','b','1','1','0','1','1','1','1','1','1','b','b','b','b','b','b'};
		 MultiplicationDTM test1 = new MultiplicationDTM(tape);
		 char[] output = test1.program();
		 //System.out.println(output);
		 boolean equals = Arrays.equals(output, success);
		 assertEquals(equals, true, "2*3 Calculation Failed");
	}
	/***********************************************************
	 * Test 2: 3*3
	 ***********************************************************/
	@Test
	void testCase2() {
		
		char[] tape = {'1', '1','1','0','1','1','1','0','b','b','b','b','b','b','b','b','b','b','b','b'};
		 char[] success = {'b','b','b','b','b','1','1','0','1','1','1','1','1','1','1','1','1','b','b', 'b'};
		 MultiplicationDTM test1 = new MultiplicationDTM(tape);
		 char[] output = test1.program();
		 //System.out.println(output);
		 boolean equals = Arrays.equals(output, success);
		 assertEquals(equals, true, "3*3 Calculation Failed");
	}
	/***********************************************************
	 * Test 3: 7*2
	 ***********************************************************/
	@Test
	void testCase3() {
		
		char[] tape = {'1', '1','1','1','1','1','1','0','1','1','0','b','b','b','b','b','b','b','b','b','b','b','b','b','b'};
		char[] success = {'b','b','b','b','b','b','b','b','b','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1'};
		MultiplicationDTM test1 = new MultiplicationDTM(tape);
		char[] output = test1.program();
		//System.out.println(output);
		boolean equals = Arrays.equals(output, success);
		assertEquals(equals, true, "7*2 Calculation Failed");
	}
	/***********************************************************
	 * Test 4: 4*4
	 ***********************************************************/
	@Test
	void testCase4() {
		char[] tape = {'1', '1','1','1','0','1','1','1','1','0','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'};
		char[] success = {'b','b','b','b','b','b','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','b'};
		MultiplicationDTM test1 = new MultiplicationDTM(tape);
		char[] output = test1.program();
		//System.out.println(output);
		boolean equals = Arrays.equals(output, success);
		assertEquals(equals, true, "4*4 Calculation Failed");	
	}
}
