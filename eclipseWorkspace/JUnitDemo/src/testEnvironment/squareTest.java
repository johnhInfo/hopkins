package testEnvironment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class squareTest {

	@Test
	void test() {
		JunitTesting test = new JunitTesting();
		int  output = test.square(5);
		assertEquals(25, output);
		
	}
	
	@Test
	void test2() {
		JunitTesting test = new JunitTesting();
		int  output = test.square(6);
		assertEquals(36, output);
		
	}

}
