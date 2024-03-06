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

			if(OPERATOR_PATTERN.matcher(value).matches()){
				operator = getOperator(value);
				continue;
			}

			if(NUMBER_PATTERN.matcher(value).matches()){
				int operand = Integer.parseInt(value);
				result = applyOperation(result, operator, operand);
				operator = PLUS;
			}

		}
		return result;
	}

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

	public int applyOperation(int result, char operator, int operand) {
		switch (operator) {
			case MINUS    -> result -= operand;
			case MULTIPLY -> result *= operand;
			case DIVIDE   -> result /= operand;
			default       -> result += operand;
		}
		return result;
	}

}