package chapter08.item50;

import java.util.Date;

public class Period {
	private final Date start;
	private final Date end;

	public Period(final Date start, final Date end) {
		if (start.compareTo(end) > 0) {
			throw new IllegalArgumentException(start + " after " + end);
		}
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
	}

	public Date start() {
		return new Date(start.getTime());
	}

	public Date end() {
		return new Date(end.getTime());
	}
}
