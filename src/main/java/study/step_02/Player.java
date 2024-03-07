package study.step_02;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Player {
	private final int INPUT_SIZE;
	private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

	public Player(int inputSize) {
		if(inputSize > 5){
			throw new IllegalArgumentException(ExceptionMessage.TOO_MANY_BIG_NUMBER);
		}
		this.INPUT_SIZE = inputSize;
	}

	public Set<Integer> getPlayerSwing(String input) {
		LinkedHashSet<Integer> swingSet = new LinkedHashSet<>();
		validateInputLength(input);
		for(int i = 0; i < input.length(); i++) {
			int inputInteger = parseInputToInteger(input.substring(i, i+1));
			swingSet.add(inputInteger);
		}
		validateSetSize(swingSet);
		return swingSet;
	}

	public int parseInputToInteger(String input) {
		if(! NUMBER_PATTERN.matcher(input).matches()) {
			throw new IllegalArgumentException(ExceptionMessage.INVALID_SWING_INPUT);
		}
		return Integer.parseInt(input);
	}
	public void validateInputLength(String input) {
		if(input.length() != INPUT_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.INVALID_SWING_INPUT_LENGTH);
		}
	}

	public void validateSetSize(Set<Integer> inputSet) {
		if(inputSet.size() != INPUT_SIZE){
			throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_SWING_INPUT);
		}
	}

}
