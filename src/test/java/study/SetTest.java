package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	//요구사항 1
	@Test
	@DisplayName("Set의 크기 알아내기.")
	void getSetSize(){
		int actual = numbers.size();
		assertThat(actual).isEqualTo(3);
	}


	//요구사항 2
	@Test
	void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	@DisplayName("contains()의 중복 부분 제거하여 리펙토링")
	void containsParameterizedRefactoring(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

}
