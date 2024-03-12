package study.step_02;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
public class BaseballTest {
	private Baseball baseball;
	@BeforeEach
	void setUp() {
		int[] computerBallNumbers = {1, 2, 3};
		Balls answer = new Balls(computerBallNumbers);
		baseball = new Baseball(answer);
	}
	@Test
	@DisplayName("낫싱")
	void notingScore(){
		Balls userBalls = new Balls(new int[]{4, 5, 6});
		Score score = baseball.scoreResults(userBalls);

		assertThat(score.getStrikeCount()).isEqualTo(0);
		assertThat(score.getBallCount()).isEqualTo(0);
		assertThat(score.reportScore()).isEqualTo("낫싱");
	}

	@Test
	@DisplayName("3볼")
	void ballThreeScore(){
		Balls userBalls = new Balls(new int[]{2, 3, 1});
		Score score = baseball.scoreResults(userBalls);

		assertThat(score.getStrikeCount()).isEqualTo(0);
		assertThat(score.getBallCount()).isEqualTo(3);
		assertThat(score.reportScore()).isEqualTo("3볼");
	}

	@Test
	@DisplayName("3스트라이크")
	void strikeThreeScore(){
		Balls userBalls = new Balls(new int[]{1, 2, 3});
		Score score = baseball.scoreResults(userBalls);

		assertThat(score.getStrikeCount()).isEqualTo(3);
		assertThat(score.getBallCount()).isEqualTo(0);
		assertThat(score.reportScore()).isEqualTo("3스트라이크");
	}

	@Test
	@DisplayName("1스트라이크 2볼")
	void strikeOneAndBallTwoScore(){
		Balls userBalls = new Balls(new int[]{2, 1, 3});
		Score score = baseball.scoreResults(userBalls);

		assertThat(score.getStrikeCount()).isEqualTo(1);
		assertThat(score.getBallCount()).isEqualTo(2);
		assertThat(score.reportScore()).isEqualTo("1스트라이크 2볼");
	}
}
