package study.step_01.constants;

public enum Operator {
	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/");

	private final String operator;

	Operator(String operator) {
		this.operator = operator;
	}

	public String getSymbol() {
		return operator;
	}
}