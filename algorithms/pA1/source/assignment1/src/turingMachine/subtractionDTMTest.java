package turingMachine;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


class subtractionDTMTest {
	
	/***********************************************************
	 * Test: 1+1
	 ***********************************************************/
	@Test
	void test1() {
		
		 char[] tape = {'0', 'b', '0','b'};
		 char[] success = {'p', '0', '0', 'b'};
		 subtractionDTM test1 = new subtractionDTM(tape);
		 char[] output = test1.program();
		 
		 
		 boolean equals = Arrays.equals(output, success);
		 System.out.println(equals);
		 assertEquals(equals, true, "1+1 Calculation Failed");
	}
	
	/***********************************************************
	 * Test: 2+1
	 ***********************************************************/
	@Test
	void test2() {
		
		 char[] tape = {'0', '0','b', '0','b'};
		 char[] success = {'p', '0','0', '0', 'b'};
		 subtractionDTM test1 = new subtractionDTM(tape);
		 char[] output = test1.program();
		 
		 
		 boolean equals = Arrays.equals(output, success);
		 System.out.println(equals);
		 assertEquals(equals, true, "2+1 Calculation Failed");
	}
	/***********************************************************
	 * Test: 2+2
	 ***********************************************************/
	@Test
	void test3() {
		
		 char[] tape = {'0', '0','b', '0','0','b'};
		 char[] success = {'p', '0','0', '0','0', 'b'};
		 subtractionDTM test1 = new subtractionDTM(tape);
		 char[] output = test1.program();
		 
		 
		 boolean equals = Arrays.equals(output, success);
		 System.out.println(equals);
		 assertEquals(equals, true, "2+2 Calculation Failed");
	}
	/***********************************************************
	 * Test: 5+7
	 ***********************************************************/
	@Test
	void test4() {
		
		 char[] tape = {'0', '0','0', '0', '0','b','0', '0', '0', '0', '0', '0','0','b'};
		 char[] success = {'p', '0','0', '0','0','0','0', '0','0','0','0', '0','0', 'b'};
		 subtractionDTM test1 = new subtractionDTM(tape);
		 char[] output = test1.program();
		 
		 
		 boolean equals = Arrays.equals(output, success);
		 System.out.println(equals);
		 assertEquals(equals, true, "5+7 Calculation Failed");
	}
}
