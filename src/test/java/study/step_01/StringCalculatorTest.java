package study.step_01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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
	@DisplayName("String[]의 식을 Pemdas를 무시하고 순서대로 사칙연산")
	void calculatorNotPemdas() {
		String[] values = {"2", "+", "3", "*", "4", "/", "2"};
		int actual = stringCalculator.calculatorNotPemdas(values);
		assertThat(actual).isEqualTo(10);
	}

	@Test
	@DisplayName("String으로 되어 있는 연산자를 char 형식으로 바꾸기")
	void getOperator() {
		char actual = stringCalculator.getOperator("+");
		assertThat(actual).isEqualTo('+');
	}

	@Test
	@DisplayName("getOperator() 예외 발생 : 잘못된 연산자")
	void getOperatorIllegalArgumentException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					char actual = stringCalculator.getOperator("@");
				}).withMessageMatching("잘못된 연산자입니다.");
	}

	@Test
	@DisplayName("getOperator()의 두 번째 인자에 기존 operator를 넘겨주어 첫 번째 인자에 잘못된 값이 들어와도 두 번째 인자의 operator를 반환.")
	void getOperatorOverride() {
		char operator = '+';
		char actual = stringCalculator.getOperator("@", operator);
		assertThat(actual).isEqualTo('+');
	}

	@Test
	@DisplayName("첫 번째 인자(int)와 세번 째 인자(int)를 가운데 인자의 연산자로 계산")
	void applyOperation() {
		int actual = stringCalculator.applyOperation(2, '*', 3);
		assertThat(actual).isEqualTo(6);
	}

	@Test
	@DisplayName("첫 번째 인자(int)와 파싱한 세번 째 인자(String)를 가운데 인자의 연산자로 계산")
	void applyOperationOverride(){
		int actual = stringCalculator.applyOperation(2, '*', "31");
		assertThat(actual).isEqualTo(62);
	}
}
