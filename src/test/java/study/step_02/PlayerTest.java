package study.step_02;

import org.junit.jupiter.api.*;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
	private final Player player = new Player(3);

	@Test
	@DisplayName("플레이어 입력 값 LinkedHashSet으로 변환해서 리턴")
	void getPlayerSwing() {
		Set<Integer> actual = player.getPlayerSwing("329");
		Set<Integer> expected = new LinkedHashSet<>();
		expected.add(3);
		expected.add(2);
		expected.add(9);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@DisplayName("유저가 입력한 값이 3자리를 초과할 경우")
	void getPlayerSwingExceptionWrongInput() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Set<Integer> actual = player.getPlayerSwing("bug");
				}).withMessageMatching(ExceptionMessage.INVALID_SWING_INPUT);
	}

	@Test
	@DisplayName("유저가 입력한 값이 3자리를 초과할 경우")
	void getPlayerSwingExceptionInputLength() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Set<Integer> actual = player.getPlayerSwing("1234");
				}).withMessageMatching(ExceptionMessage.INVALID_SWING_INPUT_LENGTH);
	}

	@Test
	@DisplayName("유저가 입력한 3자리 숫자에 중복이 발생할 경우")
	void getPlayerSwingExceptionDuplicated() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Set<Integer> actual = player.getPlayerSwing("332");
				}).withMessageMatching(ExceptionMessage.DUPLICATED_SWING_INPUT);
	}

	@Test
	@DisplayName("사용자 입력 값이 숫자가 아닐 경우 오류")
	void parseInputToIntegerException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					player.parseInputToInteger("x");
				}).withMessageMatching(ExceptionMessage.INVALID_SWING_INPUT);
	}


	@Test
	@DisplayName("사용자 입력 값 길이가 3이 아닐 경우 오류")
	void validateInputLengthException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					player.validateInputLength("1234");
				}).withMessageMatching(ExceptionMessage.INVALID_SWING_INPUT_LENGTH);
	}

	@Test
	@DisplayName("Set의 길이가 3이 아닐 경우 오류")
	void validateSetSizeException() {
		Set<Integer> actual = new LinkedHashSet<>();
		actual.add(1);
		actual.add(1);
		actual.add(9);

		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					player.validateSetSize(actual);
				}).withMessageMatching(ExceptionMessage.DUPLICATED_SWING_INPUT);
	}
}
