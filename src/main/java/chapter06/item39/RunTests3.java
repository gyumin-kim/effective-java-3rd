package chapter06.item39;

import java.lang.reflect.Method;

public class RunTests3 {
	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(RepeatableExceptionTest.class)
					|| m.isAnnotationPresent(RepeatableExceptionTestContainer.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", m);
				} catch (Throwable wrappedExc) {
					Throwable exc = wrappedExc.getCause();	// 발생한 예외
					int oldPassed = passed;
					RepeatableExceptionTest[] excTests = m.getAnnotationsByType(RepeatableExceptionTest.class);
					for (RepeatableExceptionTest excTest : excTests) {
						if (excTest.value().isInstance(exc)) {
							passed++;
							break;
						}
					}
					if (passed == oldPassed)
						System.out.printf("테스트 %s 실패: %s %n", m, exc);
				}
			}
		}
		System.out.printf("성공: %d, 실패: %d%n",
				passed, tests - passed);
	}
}
