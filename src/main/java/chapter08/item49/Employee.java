package chapter08.item49;

import java.util.Objects;

public class Employee {

	private String name;
	private int age;
	private long[] array;

	public Employee() {
	}

	public Employee(final String name, final int age, final long[] array) {
		this.name = Objects.requireNonNull(name);
		this.age = age;
		this.array = Objects.requireNonNull(array);
	}

	public void sortAndPrint(long a[], int offset, int length) {
		sort(array, offset, length);
	}

	private void sort(long a[], int offset, int length) {
		assert a != null;
		assert offset >= 0 && offset <= a.length;
		assert length >= 0 && length <= a.length - offset;

		// 계산 수행 ...
		System.out.println("sort 완료");
	}
}
