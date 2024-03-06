package study.step_01;

import java.util.Scanner;

public class StringCalculator {
	private static final char PLUS = '+';
	private static final char MINUS = '-';
	private static final char MULTIPLY = '*';
	private static final char DIVIDE = '/';


	public int getInputAndCalculate(){
		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.nextLine();
			String[] values = input.split(" ");
			return calculatorNotPemdas(values);
		}
	}

	public int calculatorNotPemdas(String[] values){
		int result = 0;
		char operator = '+';

		for (String value : values){
			switch (value){
				case "+" -> operator = PLUS;
				case "-" -> operator = MINUS;
				case "*" -> operator = MULTIPLY;
				case "/" -> operator = DIVIDE;
				default -> {
					int operand = Integer.parseInt(value);
					result = applyOperation(result, operator, operand);
					operator = PLUS;
				}
			}
		}

		return result;
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