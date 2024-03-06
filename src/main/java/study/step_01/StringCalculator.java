package study.step_01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final char PLUS = '+';
	private static final char MINUS = '-';
	private static final char MULTIPLY = '*';
	private static final char DIVIDE = '/';
	private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
	private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/]");


	public int getInputAndCalculate(){
		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.nextLine();
			String[] values = input.split(" ");
			return calculatorNotPemdas(values);
		}
	}

	public int calculatorNotPemdas(String[] values){
		int result = 0;
		char operator = PLUS;

		for (String value : values){
			operator = getOperator(value, operator);
			result = applyOperation(result, operator, value);
		}
		return result;
	}

	/**
	 * String 형태의 연산자를 char 형태로 parsing 하는 함수
	 *
	 * @param value "+", "-", "*", "/"
	 * @return char PLUS, MINUS, MULTIPLY, DIVIDE
	 */
	public char getOperator(String value) {
		char operator;
		switch (value) {
			case "+" -> operator = PLUS;
			case "-" -> operator = MINUS;
			case "*" -> operator = MULTIPLY;
			case "/" -> operator = DIVIDE;
			default -> throw new IllegalArgumentException("잘못된 연산자입니다.");
		}
		return operator;
	}

	/**
	 * &#064;Override
	 * <p>
	 * String 형태의 연산자를 char 형태로 parsing 하는 함수,
	 * 기존에 주어진 char operator가 존재할 경우 String value에 잘못된 값이 들어와도 두 번째 인자의 operator를 반환.
	 *
	 * @param value "+", "-", "*", "/"
	 * @param operator  PLUS, MINUS, MULTIPLY, DIVIDE
	 * @return char PLUS, MINUS, MULTIPLY, DIVIDE
	 */
	public char getOperator(String value, char operator) {
		if( !OPERATOR_PATTERN.matcher(value).matches() ){
			return operator;
		}
		return getOperator(value);
	}

	/**
	 * 첫 번째 인자와 세 번째 인자를 두 번째 인자로 사칙연산하는 함수
	 *
	 * @param result 왼쪽 피연산자
	 * @param operator PLUS, MINUS, MULTIPLY, DIVIDE
	 * @param operand 오른쪽 피연산자
	 * @return result operator operand = result
	 */
	public int applyOperation(int result, char operator, int operand) {
		switch (operator) {
			case MINUS    -> result -= operand;
			case MULTIPLY -> result *= operand;
			case DIVIDE   -> result /= operand;
			default       -> result += operand;
		}
		return result;
	}

	/**
	 * &#064;Override
	 * <p>
	 * 첫 번째 인자(int)와 세 번째 인자(String)를 두 번째 인자로 사칙연산하는 함수,
	 * 이 때 세 번째 인자는 parseInt()처리 후 계산
	 *
	 * @param result 왼쪽 피연산자
	 * @param operator PLUS, MINUS, MULTIPLY, DIVIDE
	 * @param value 오른쪽 피연산자 (parseInt()처리 후 계산)
	 * @return result operator operand = result
	 */
	public int applyOperation(int result, char operator, String value){
		if(!NUMBER_PATTERN.matcher(value).matches()){
			return result;
		}
		int operand = Integer.parseInt(value);
		return applyOperation(result, operator, operand);
	}

}