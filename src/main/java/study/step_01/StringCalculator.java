package study.step_01;

import study.step_01.constants.Operator;

import java.util.Scanner;

public class StringCalculator {
	private Scanner scanner = new Scanner(System.in);

	public int calculatorNotPemdas(){
		String value = scanner.nextLine();
		int result = 0;
		Operator operator = Operator.ADD;
		String[] values = value.split(" ");

		for (String var : values){
			switch (var){
				case "+" -> operator = Operator.ADD;
				case "-" -> operator = Operator.SUBTRACT;
				case "*" -> operator = Operator.MULTIPLY;
				case "/" -> operator = Operator.DIVIDE;
				default -> {
					switch (operator){
						case SUBTRACT -> result -= Integer.parseInt(var);
						case MULTIPLY -> result *= Integer.parseInt(var);
						case DIVIDE   -> result /= Integer.parseInt(var);
						default       -> result += Integer.parseInt(var);
					}
					operator = Operator.ADD;
				}
			}
		}

		scanner.close();
		return result;
	}

}
