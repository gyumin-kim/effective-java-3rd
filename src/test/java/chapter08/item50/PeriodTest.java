package chapter08.item50;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PeriodTest {

	@DisplayName("방어적 복사본을 만들지 않으면 외부에서 불변식을 깨트릴 수 있다")
	@Test
	void Period_불변식_깨트리기() throws ParseException {
		// given
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse("1993-04-22");
		Date end = new Date();
		UnsafePeriod p = new UnsafePeriod(start, end);

		// when
		start.setYear(2019);

		// then
		assertThat(p.start().getYear()).isNotEqualTo(1993);
	}

	@DisplayName("생성자와 접근자에서 방어적 복사본을 활용하면 완벽한 불변을 보장한다")
	@Test
	void Period_불변성_보장() throws ParseException {
		// given
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse("1993-04-22");
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-22");
		Period p = new Period(start, end);

		// when
		p.start().setYear(1917);
		end.setYear(2080);

		// then
		assertThat(p.start()).isEqualTo("1993-04-22");
		assertThat(p.end()).isEqualTo("2020-04-22");
	}

	@DisplayName("start가 end보다 뒤에 있으면 IllegalArgumentException 발생")
	@Test
	void 생성자_validation_check() throws ParseException {
		// given
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-02");
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-22");

		// when & then
		assertThrows(IllegalArgumentException.class, () -> new Period(start, end));
	}
}