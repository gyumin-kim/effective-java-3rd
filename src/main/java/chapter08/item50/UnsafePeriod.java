package chapter08.item50;

import java.util.Date;

public final class UnsafePeriod {
	private final Date start;
	private final Date end;

	public UnsafePeriod(final Date start, final Date end) {
		if (start.compareTo(end) > 0) {
			throw new IllegalArgumentException(start + " after " + end);
		}
		this.start = start;
		this.end = end;
	}

	public Date start() {
		return start;
	}

	public Date end() {
		return end;
	}
}
