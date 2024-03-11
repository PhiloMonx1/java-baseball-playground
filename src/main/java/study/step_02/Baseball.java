package study.step_02;

public class Baseball {

	private final Balls answer;
	public Baseball(Balls balls) {
		this.answer = balls;
	}

	public Score scoreResults(Balls userBalls) {
		Score score = new Score();

		userBalls.balls.forEach(ball -> {
			BallStatus ballStatus = answer.play(ball);
			if(ballStatus == BallStatus.STRIKE) {
				score.strikeCount++;
			}
			if(ballStatus == BallStatus.BALL) {
				score.ballCount++;
			}
		});
		return score;
	}
}
