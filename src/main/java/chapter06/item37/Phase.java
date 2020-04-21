package chapter06.item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public enum Phase {
	SOLID, LIQUID, GAS;

	public enum Transition {
		MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

		private static final Transition[][] TRANSITIONS = {
				{ 	null, 	MELT, 	SUBLIME },
				{ FREEZE, 	null, 	BOIL 	},
				{ DEPOSIT, CONDENSE, null 	}
		};

		public static Transition from(Phase from, Phase to) {
			return TRANSITIONS[from.ordinal()][to.ordinal()];
		}
	}

	public enum TransitionEnumMap {
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
		BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
		SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
		// Phase와 TransitionEnumMap에 새로운 상수를 추가해도, 아래 코드에는 수정이 일어나지 않는다.

		private final Phase from;
		private final Phase to;

		TransitionEnumMap(Phase from, Phase to) {
			this.from = from;
			this.to = to;
		}

//		private final static Map<Phase, Map<Phase, TransitionEnumMap>>
//				m = Stream.of(values()).collect(groupingBy(t -> t.from,
//				() -> new EnumMap<>(Phase.class),
//				toMap(t -> t.to, t -> t,
//						(x, y) -> y, () -> new EnumMap<>(Phase.class))));
		private static final Map<Phase, Map<Phase, TransitionEnumMap>> m = new EnumMap<>(Phase.class);
		static {
			for (Phase p : Phase.values())
				m.put(p, new EnumMap<>(Phase.class));
			for (TransitionEnumMap trans : TransitionEnumMap.values())
				m.get(trans.from).put(trans.to, trans);
		}

		public static TransitionEnumMap from(Phase from, Phase to) {
			return m.get(from).get(to);
		}
	}
}
