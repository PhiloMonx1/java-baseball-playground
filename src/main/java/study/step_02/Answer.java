package study.step_02;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Answer {
	private final int ANSWER_SIZE;

	public Answer(int answerSize) {
		if(answerSize > 5){
			throw new IllegalArgumentException(ExceptionMessage.TOO_MANY_BIG_NUMBER);
		}
		this.ANSWER_SIZE = answerSize;
	}

	public Set<Integer> getAnswer() {
		LinkedHashSet<Integer> answerSet = new LinkedHashSet<>();

		while (answerSet.size() < ANSWER_SIZE) {
			Random random = new Random();
			int randomInt = random.nextInt(10);

			answerSet.add(randomInt);
		}
		return answerSet;
	}
}
