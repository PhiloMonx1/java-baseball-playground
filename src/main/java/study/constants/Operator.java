package study.constants;

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