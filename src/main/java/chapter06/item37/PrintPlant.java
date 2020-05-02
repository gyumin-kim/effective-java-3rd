package chapter06.item37;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class PrintPlant {

	static Plant[] garden = {
			new Plant("Watermelon", Plant.LifeCycle.ANNUAL),
			new Plant("Strawberry", Plant.LifeCycle.PERENNIAL),
			new Plant("Parsley", Plant.LifeCycle.BIENNIAL)
	};

	public static void main(String[] args) {
		ordinal();
		enumMap();
		streamWithoutEnumMap();
		streamWithEnumMap();
	}

	private static void ordinal() {
		Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
		for (int i = 0; i < plantsByLifeCycle.length; i++) {
			plantsByLifeCycle[i] = new HashSet<>();
		}

		for (Plant p : garden) {
			plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);	// ordinal()을 배열 인덱스로 사용 - 따라 하지 말 것!
		}

		// 결과 출력 (배열은 각 index의 의미를 모르니, 출력 결과에 직접 레이블(ANNUAL/PERENNIAL/BIENNIAL)을 달아야 한다!)
		for (int i = 0; i < plantsByLifeCycle.length; i++) {
			System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
		}
	}

	private static void enumMap() {
		Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
		for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
			plantsByLifeCycle.put(lc, new HashSet<>());
		}
		for (Plant p : garden) {
			plantsByLifeCycle.get(p.lifeCycle).add(p);
		}
		// Map의 key인 Enum이 그 자체로 출력용 문자열을 제공하니, 출력 결과에 직접 레이블을 달지 않아도 된다.
		System.out.println(plantsByLifeCycle);
	}

	private static void streamWithoutEnumMap() {
		System.out.println(Arrays.stream(garden)
				.collect(groupingBy(p -> p.lifeCycle)));
	}

	private static void streamWithEnumMap() {
		System.out.println(Arrays.stream(garden)
				.collect(groupingBy(p -> p.lifeCycle,
						() -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
	}
}
