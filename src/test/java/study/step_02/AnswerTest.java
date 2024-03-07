package study.step_02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {
	private final Answer answer = new Answer(3);

	@Test
	@DisplayName("생성한 정답 배열의 길이가 3인지 확인")
	void getAnswerSize() {
		int actual = answer.getAnswer().size();
		assertThat(actual).isEqualTo(3);
	}
}
