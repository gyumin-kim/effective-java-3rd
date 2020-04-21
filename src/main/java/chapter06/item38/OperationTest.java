package chapter06.item38;

import java.util.Arrays;
import java.util.Collection;

public class OperationTest {

	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		test1(ExtendedOperation.class, x, y);
		test2(Arrays.asList(ExtendedOperation.values()), x, y);
	}

	private static <T extends Enum<T> & Operation> void test1(Class<T> opEnumType, double x, double y) {
		// <T extends Enum<T> & Operation> Class<T>
		// "Class 객체가 Enum인 동시에 Operation의 하위 타입이어야 한다"는 의미
		for (Operation op : opEnumType.getEnumConstants()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}

	// 여러 구현 타입의 Operation을 조합해 호출할 수 있다
	private static void test2(Collection<? extends Operation> opSet, double x, double y) {
		for (Operation op : opSet) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}
}
