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
		return balls.stream()
				.map(computerBall -> computerBall.play(userBall))
				.filter(status -> status == BallStatus.STRIKE || status == BallStatus.BALL)
				.findFirst()
				.orElse(BallStatus.NOTHING);
	}
}
