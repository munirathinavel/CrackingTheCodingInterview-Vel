package test;

import java.time.LocalDate;

public class DateFormat {

	public static void main(String[] args) {
		String year = "2005";
		String month = "04";
		String day = "12";
		LocalDate ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		System.out.println(ld.getDayOfWeek());
		System.out.println(ld.getDayOfMonth());
		System.out.println(ld.getDayOfYear());

		System.out.println(ld.getMonthValue());
		System.out.println(ld.getMonth().name());
		System.out.println(ld.getYear());
	}
}
