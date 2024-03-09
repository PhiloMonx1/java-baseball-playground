package study.step_02;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Computer {
	private Scanner scanner;
	private final int GAME_SIZE;
	private static int ballCount;
	private static int strikeCount;

	public Computer(int gameSize){
		if(gameSize > 5){
			throw new IllegalArgumentException(ExceptionMessage.TOO_MANY_BIG_NUMBER);
		}
		this.GAME_SIZE = gameSize;
		this.ballCount = 0;
		this.strikeCount = 0;
		scanner = new Scanner(System.in);
	}

	public void computed(){
		Answer answer = new Answer(GAME_SIZE);
		Set<Integer> answerSet = answer.getAnswer();

		while (strikeCount < GAME_SIZE) {
			ballCount = 0;
			strikeCount = 0;

			GameMessage.displaySwingMessage();
			String swingInput = scanner.nextLine();
			Set<Integer> swingSet = new Player(GAME_SIZE).getPlayerSwing(swingInput);
			refereedSwing(swingSet, answerSet);
			GameMessage.displaySwingResult(strikeCount, ballCount);
		}
		GameMessage.displayWinMessage();
	}

	public void refereedSwing(Set<Integer> swingSet, Set<Integer> answerSet) {
		Iterator<Integer> swingIterator = swingSet.iterator();
		Iterator<Integer> answerIterator = answerSet.iterator();

		while (swingIterator.hasNext() && answerIterator.hasNext()) {
			int swingValue = swingIterator.next();
			int answerValue = answerIterator.next();

			if(strike(swingValue, answerValue)) continue;
			ball(swingValue, answerSet);
		}
	}

	public static boolean ball(int swing, Set<Integer> answerSet) {
		if (answerSet.contains(swing)) {
			ballCount++;
			return true;
		}
		return false;
	}

	public static boolean strike(int swing, int answer) {
		if(swing == answer){
			strikeCount++;
			return true;
		}
		return false;
	}

}