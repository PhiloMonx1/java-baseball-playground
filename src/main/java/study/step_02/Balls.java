package study.step_02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Balls {
	private final int[] ballNumbers;
	public Balls(int[] ballNumbers) {
		this.ballNumbers = ballNumbers;
	}
	public BallStatus play(Ball userBall) {
		if(isEquals(userBall)){
			return BallStatus.STRIKE;
		}
		if(containTargetNumber(userBall.targetNumber)){
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}

	public boolean containTargetNumber(int targetNumber) {
		return Arrays.stream(ballNumbers).anyMatch(ballNumber -> ballNumber == targetNumber);
	}

	public boolean isEquals(Ball ball) {
		return IntStream.range(0, ballNumbers.length)
				.anyMatch(index -> (ball.position == index + 1) && (ball.targetNumber == ballNumbers[index]));
	}
}
