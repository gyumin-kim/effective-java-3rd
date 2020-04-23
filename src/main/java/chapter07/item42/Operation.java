package chapter07.item42;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
	// 각 enum 상수의 동작을 람다로 구현해 생성자에 넘긴다.
	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	TIMES("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y),
	;

	private final String symbol;
	private final DoubleBinaryOperator op;

	Operation(String symbol, DoubleBinaryOperator op) {
		this.symbol = symbol;
		this.op = op;	// 람다를 인스턴스 필드로 저장해둔다.
	}

	@Override
	public String toString() {
		return symbol;
	}

	public double apply(double x, double y) {
		// 필드에 저장된 람다를 호출한다.
		return op.applyAsDouble(x, y);
	}
}
