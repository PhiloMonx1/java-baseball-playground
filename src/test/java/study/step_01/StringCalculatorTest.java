package study.step_01;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
	protected void systemIn(String input) {
		System.setIn(new ByteArrayInputStream(input.getBytes()));
	}

	@Test
	void testCalculatorNotPemdas(){
		systemIn("2 + 3 * 4 / 2");
		StringCalculator stringCalculator = new StringCalculator();

		assertEquals(10 , stringCalculator.calculatorNotPemdas());
	}
}
