package study.step_02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
	@Test
	@DisplayName("낫싱")
	void noting(){
		Ball computer = new Ball(1, 1);
		Ball userBall = new Ball(2, 2);
		BallStatus ballStatus = computer.play(userBall);
		assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
	}
	@Test
	@DisplayName("볼")
	void ball(){
		Ball computer = new Ball(1, 1);
		Ball userBall = new Ball(2, 1);
		BallStatus ballStatus = computer.play(userBall);
		assertThat(ballStatus).isEqualTo(BallStatus.BALL);
	}
	@Test
	@DisplayName("스트라이크")
	void strike(){
		Ball computer = new Ball(1, 1);
		Ball userBall = new Ball(1, 1);
		BallStatus ballStatus = computer.play(userBall);
		assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
	}
}
