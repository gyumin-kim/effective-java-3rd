package chapter08.item49;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {

	@DisplayName("assert 통과")
	@Test
	void sortAndPrint_test() {
		// given
		long[] a = { 3, 5, 93, 35, 89, 34, 1, 82, 923 };
		Employee employee = new Employee("G", 27, a);

		// when & then
		employee.sortAndPrint(a, 3, 6);
	}

	@DisplayName("assert 실패")
	@Test
	void sortAndPrint_assertionError_test() {
		// given
		long[] a = { 3, 5, 93, 35, 89, 34, 1, 82, 923 };
		Employee employee = new Employee("G", 27, a);

		// when & then
		assertThrows(AssertionError.class, () -> employee.sortAndPrint(a, 3, 20));
	}
}