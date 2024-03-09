package study.step_02;

public class GameMessage {
	public static final String SWING = "숫자를 입력해 주세요 : ";
	public static final String STRIKE = "스트라이크";
	public static final String BALL = "볼";
	public static final String NOTING = "낫싱";
	public static final String WIN = "숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void displaySwingMessage() {
		System.out.println(SWING);
	}

	public static void displayStrikeMessage(int count) {
		if(count > 0) {
			System.out.println(count + STRIKE);
		}
	}

	public static void displayBallMessage(int count) {
		if(count > 0) {
			System.out.println(count + BALL);
		}
	}

	public static void displayNotingMessage() {
		System.out.println(NOTING);
	}

	public static void displayWinMessage() {
		System.out.println(WIN);
	}

	public static void displayReplayMessage() {
		System.out.println(REPLAY);
	}

	public static void displaySwingResult(int strikeCount, int ballCount) {
		displayStrikeMessage(strikeCount);
		displayBallMessage(ballCount);
		if(strikeCount == 0 && ballCount == 0) {
			displayNotingMessage();
		}
	}

}
