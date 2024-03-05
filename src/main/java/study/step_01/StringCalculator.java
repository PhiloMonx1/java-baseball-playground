package study.step_01;

import java.util.Scanner;

public class StringCalculator {
	private final char PLUS = '+';
	private final char MINUS = '-';
	private final char MULTIPLY = '*';
	private final char DIVIDE = '/';


	public int calculatorNotPemdas(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		int result = 0;
		char operator = '+';

		String[] values = input.split(" ");

		for (String value : values){
			switch (value){
				case "+" -> operator = PLUS;
				case "-" -> operator = MINUS;
				case "*" -> operator = MULTIPLY;
				case "/" -> operator = DIVIDE;
				default -> {
					switch (operator){
						case MINUS    -> result -= Integer.parseInt(value);
						case MULTIPLY -> result *= Integer.parseInt(value);
						case DIVIDE   -> result /= Integer.parseInt(value);
						default       -> result += Integer.parseInt(value);
					}
					operator = PLUS;
				}
			}
		}

		scanner.close();
		return result;
	}

}
