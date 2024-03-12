package study.step_02;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Computer {
	public void playGame(){
		Baseball computer = new Baseball(new Balls(createRandomNumbers()));
		Score score = new Score();
		Scanner scanner = new Scanner(System.in);

		while (score.strikeCount < 3) {
			score.strikeCount = 0;
			score.ballCount = 0;

			System.out.println("숫자를 입력해 주세요.");
			String input = scanner.nextLine();
			Balls userBalls = new Balls(userInputParsingNumbers(input));
			score = computer.scoreResults(userBalls);
			System.out.println(score.reportScore());
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public int[] createRandomNumbers(){
		Set<Integer> numbersSet = new HashSet<>();
		while (numbersSet.size() < 3) {
			numbersSet.add((int) (Math.random() * 9) + 1);
		}
		return numbersSet.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] userInputParsingNumbers(String input){
		String[] numbers = input.split("");
		int[] parsedNumbers = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			parsedNumbers[i] = Integer.parseInt(numbers[i]);
		}
		return parsedNumbers;
	}
}
