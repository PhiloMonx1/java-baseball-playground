package study.step_02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BullsAndCowsGameTest {
	private final BullsAndCowsGame game = new BullsAndCowsGame();
	@Test
	@DisplayName("게임 종료를 선택했을 때 값이 종료로 변경되는지 확인")
	void isGameOver() {
		boolean actual = game.isGameOver("2");
		assertThat(actual).isTrue();
	}

	@Test
	@DisplayName("1이나 2가 아닌 값을 넣을 경우 예외처리")
	void isGameOverException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					boolean actual = game.isGameOver("x");
				}).withMessageMatching(ExceptionMessage.INVALID_GAME_OVER_INPUT);
	}
}
