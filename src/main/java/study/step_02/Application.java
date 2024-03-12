package study.step_02;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Computer computer = new Computer();
		boolean isGameOver = false;
		while (!isGameOver){
			computer.playGame();
			Scanner scanner = new Scanner(System.in);
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			String input = scanner.nextLine();
			if(input.equals("2")){
				isGameOver = true;
			}
		}
	}
}
