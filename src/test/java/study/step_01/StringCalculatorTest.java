package study.step_01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
	private static final StringCalculator stringCalculator = new StringCalculator();

	protected void systemIn(String input) {
		System.setIn(new ByteArrayInputStream(input.getBytes()));
	}

	@Test
	@DisplayName("systemIn 인풋 값을 Pemdas를 무시하고 순서대로 사칙연산")
	void testGetInputAndCalculate() {
		systemIn("2 + 3 * 4 / 2");

		assertEquals(10, stringCalculator.getInputAndCalculate());
	}

	@Test
	@DisplayName("첫 번째 인자와 세번 째 인자를 가운데 인자의 연산자로 계산")
	void applyOperation() {
		int actual = stringCalculator.applyOperation(2, '*', 3);
		assertThat(actual).isEqualTo(6);
	}

	@Test
	@DisplayName("String[]의 식을 Pemdas를 무시하고 순서대로 사칙연산")
	void calculatorNotPemdas() {
		String[] values = {"2", "+", "3", "*", "4", "/", "2"};
		int actual = stringCalculator.calculatorNotPemdas(values);
		assertThat(actual).isEqualTo(10);
	}
}
