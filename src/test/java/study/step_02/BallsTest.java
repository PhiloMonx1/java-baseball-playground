package study.step_02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {
	private Balls computer;
	@BeforeEach
	void setUp() {
		int[] computerBallNumbers = {1, 2, 3};
		computer = new Balls(computerBallNumbers);
	}
	@Test
	@DisplayName("낫싱")
	void noting(){
		Ball userBall = new Ball(1, 4);
		BallStatus ballStatus = computer.play(userBall);
		assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
	}

	@Test
	@DisplayName("볼")
	void ball(){
		Ball userBall = new Ball(2, 3);
		BallStatus ballStatus = computer.play(userBall);
		assertThat(ballStatus).isEqualTo(BallStatus.BALL);
	}

	@Test
	@DisplayName("스트라이크")
	void strike(){
		Ball userBall = new Ball(2, 2);
		BallStatus ballStatus = computer.play(userBall);
		assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
	}
}
