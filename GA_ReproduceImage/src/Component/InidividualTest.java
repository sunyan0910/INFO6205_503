package Component;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InidividualTest {

	@Test
	public void test() {
		Individual in1 = new Individual();
		assertEquals(true,in1.checkEquality(in1));
		Individual in2 = new Individual();
		assertEquals(false,in1.checkEquality(in2));
	}

}
