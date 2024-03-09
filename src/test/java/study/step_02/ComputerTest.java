package study.step_02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;

public class ComputerTest {
	private final Computer computer = new Computer(3);
	@Test
	@DisplayName("볼")
	void ball() {
		LinkedHashSet<Integer> answerSet = new LinkedHashSet<>();
		answerSet.add(1);
		answerSet.add(2);
		answerSet.add(3);

		int swing = 2;
		boolean actual = computer.ball(swing, answerSet);
		assertThat(actual).isTrue();
	}

	@Test
	@DisplayName("스트라이크")
	void strike() {
		int swing = 2;
		int answer = 2;

		boolean actual = computer.strike(swing, answer);
		assertThat(actual).isTrue();
	}


}
