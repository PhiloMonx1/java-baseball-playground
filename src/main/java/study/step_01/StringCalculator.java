package study.step_01;

import study.step_01.constants.Operator;

import java.util.Scanner;

public class StringCalculator {

	public int calculatorNotPemdas(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		int result = 0;
		Operator operator = Operator.ADD;

		String[] values = input.split(" ");

		for (String value : values){
			switch (value){
				case "+" -> operator = Operator.ADD;
				case "-" -> operator = Operator.SUBTRACT;
				case "*" -> operator = Operator.MULTIPLY;
				case "/" -> operator = Operator.DIVIDE;
				default -> {
					switch (operator){
						case SUBTRACT -> result -= Integer.parseInt(value);
						case MULTIPLY -> result *= Integer.parseInt(value);
						case DIVIDE   -> result /= Integer.parseInt(value);
						default       -> result += Integer.parseInt(value);
					}
					operator = Operator.ADD;
				}
			}
		}

		scanner.close();
		return result;
	}

}
