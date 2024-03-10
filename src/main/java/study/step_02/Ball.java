package study.step_02;

public class Ball {
	int position;
	int targetNumber;
	public Ball(int position, int targetNumber) {
		this.position = position;
		this.targetNumber = targetNumber;
	}

	public BallStatus play(Ball ball) {
		if(isEquals(ball)){
			return BallStatus.STRIKE;
		}
		if(isMatchTargetNumber(ball.targetNumber)){
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}

	public boolean isMatchTargetNumber(int targetNumber) {
		return this.targetNumber == targetNumber;
	}
	public boolean isEquals(Ball ball) {
		return position == ball.position && targetNumber == ball.targetNumber;
	}
}
