package study.step_02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
	private Ball computer;
	@BeforeEach
	void setUp() {
		computer = new Ball(1, 1);
	}

	@Test
	@DisplayName("낫싱")
	void noting(){
		Ball userBall = new Ball(2, 2);
		BallStatus ballStatus = computer.play(userBall);
		assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
	}
	@Test
	@DisplayName("볼")
	void ball(){
		Ball userBall = new Ball(2, 1);
		BallStatus ballStatus = computer.play(userBall);
		assertThat(ballStatus).isEqualTo(BallStatus.BALL);
	}
	@Test
	@DisplayName("스트라이크")
	void strike(){
		Ball userBall = new Ball(1, 1);
		BallStatus ballStatus = computer.play(userBall);
		assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
	}
}
