package chapter5.datesAndTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class DatesAndTimes {

	public static void main(String... strings) {
		System.out.println(LocalDate.now());
		System.out.println(LocalDate.of(2018, 2, 28));

		System.out.println(LocalTime.now());
		System.out.println(LocalTime.of(23, 59, 59, 999999999));

		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		System.out.println(LocalDateTime.of(2018, 12, 12, 12, 30));

		System.out.println(ZonedDateTime.now());
	}
}
