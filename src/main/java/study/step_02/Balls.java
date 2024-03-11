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
		List<BallStatus> ballStatuses = new ArrayList<>(balls.size());

		for (Ball ComputerBall : balls) {
			ballStatuses.add(ComputerBall.play(userBall));
		}
		if(ballStatuses.contains(BallStatus.STRIKE)){
			return BallStatus.STRIKE;
		}
		if(ballStatuses.contains(BallStatus.BALL)){
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}
}
