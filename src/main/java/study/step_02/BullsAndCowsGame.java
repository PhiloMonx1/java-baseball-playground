package study.step_02;

import java.util.Scanner;

public class BullsAndCowsGame {
	public static void main(String[] args) {
		BullsAndCowsGame game = new BullsAndCowsGame();
		game.playGame(4);
	}
	public void playGame(int gameSize) {
		boolean isGameOver = false;
		Scanner scanner = new Scanner(System.in);

		while(!isGameOver){
			Computer computer = new Computer(gameSize);
			computer.computed();

			GameMessage.displayReplayMessage();
			String input = scanner.nextLine();
			isGameOver = isGameOver(input);
		}
		scanner.close();
	}
	public boolean isGameOver(String input) {
		if(!(input.equals("1") || input.equals("2"))){
			throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_OVER_INPUT);
		}
		return input.equals("2");
	}
}
