package study.step_02;

public class Score {
	int strikeCount = 0;
	int ballCount = 0;
	public int getStrikeCount() {
		return strikeCount;
	}
	public int getBallCount() {
		return ballCount;
	}

	public String reportScore() {
		String report = "낫싱";

		if(strikeCount > 0) {
			report = strikeCount + "스트라이크";
		}

		if (ballCount > 0) {
			report = ballCount + "볼";
		}

		if (strikeCount > 0 && ballCount > 0) {
			report = strikeCount + "스트라이크 " + ballCount + "볼";
		}

		return report;
	}
}
