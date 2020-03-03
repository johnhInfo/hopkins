package turingMachine;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


class SubtractionDTMTest {
	
	/***********************************************************
	 * Test: 3-2
	 ***********************************************************/
	@Test
	void test1() {
		
		 char[] tape = {'1', '1','1','0','1','1','b'};
		 char[] success = {'b', 'b','b','1','b','b','b'};
		 SubtractionDTM test1 = new SubtractionDTM(tape);
		 char[] output = test1.program();
		 boolean equals = Arrays.equals(output, success);
		 assertEquals(equals, true, "3-2 Calculation Failed");
	}
	
	/***********************************************************
	 * Test: 3-3
	 ***********************************************************/
	@Test
	void test2() {
		
		 char[] tape = {'1', '1','1','0','1','1','1','b'};
		 char[] success = {'b', 'b','b','0','b','b','b','b'};
		 SubtractionDTM test1 = new SubtractionDTM(tape);
		 char[] output = test1.program();
		 boolean equals = Arrays.equals(output, success);
		 assertEquals(equals, true, "3-3 Calculation Failed");
	}
	/***********************************************************
	 * Test: 7-2
	 ***********************************************************/
	@Test
	void test3() {
		
		char[] tape = {'1', '1','1','1','1','1','1','0','1','1','b'};
		char[] success = {'b', 'b','b','1','1','1','1','1','b','b','b'};
		SubtractionDTM test1 = new SubtractionDTM(tape);
		char[] output = test1.program();
		boolean equals = Arrays.equals(output, success);
		assertEquals(equals, true, "7-2 Calculation Failed");
	}
	/***********************************************************
	 * Test: 9-2
	 ***********************************************************/
	@Test
	void test4() {
		char[] tape = {'1', '1','1','1','1','1','1','1','1','0','1','1','b'};
		char[] success = {'b','b','b','1','1','1','1','1','1','1','b','b','b'};
		SubtractionDTM test1 = new SubtractionDTM(tape);
		char[] output = test1.program();
		System.out.println(output);
		boolean equals = Arrays.equals(output, success);
		assertEquals(equals, true, "9-2 Calculation Failed");	
	}
}
