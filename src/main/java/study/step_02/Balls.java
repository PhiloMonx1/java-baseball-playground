package study.step_02;

import java.util.ArrayList;
import java.util.List;

public class Balls {
	public final List<Ball> balls;
	public Balls(int[] ballNumbers) {
		List<Ball> balls = new ArrayList<>(ballNumbers.length);

		for (int i = 0; i < ballNumbers.length; i++) {
			Ball ball = new Ball(i+1, ballNumbers[i]);
			balls.add(ball);
		}

		this.balls = balls;
	}
	public BallStatus play(Ball userBall) {
		if(containPositionAndNumber(userBall)){
			return BallStatus.STRIKE;
		}
		if(containTargetNumber(userBall.targetNumber)){
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}

	public boolean containTargetNumber(int targetNumber) {
		return balls.stream()
				.anyMatch(value -> value.targetNumber == targetNumber);
	}

	public boolean containPositionAndNumber(Ball ball) {
		return balls.stream()
				.anyMatch(value -> value.position == ball.position && value.targetNumber == ball.targetNumber);
	}
}
