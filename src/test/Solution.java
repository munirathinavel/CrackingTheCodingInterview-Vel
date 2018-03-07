package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static String timeConversion(String s) {
		if (s == null || s.length() < 10) {
			return "";
		}
		/*
		 * String hh = s.split(":")[0]; String mm = s.split(":")[1]; String ssampm =
		 * s.split(":")[2]; String ss = ssampm.substring(0, 2); String ampm =
		 * ssampm.substring(2, 4);
		 * 
		 * if ("AM".equals(ampm)) { return ("12".equals(hh) ? "00" : hh) + ":" + mm +
		 * ":" + ss; } else { return ("12".equals(hh) ? 12 : (Integer.parseInt(hh) +
		 * 12)) + ":" + mm + ":" + ss; }
		 */

		char[] c = s.toCharArray();
		if (c[8] == 'A' && s.substring(0, 2).equals("12")) {
			c[0] = '0';
			c[1] = '0';
		} else if (c[8] == 'P' && !s.substring(0, 2).equals("12")) {
			String s1 = "" + (Integer.parseInt(s.substring(0, 2)) + 12);
			char[] f = s1.toCharArray();
			c[0] = f[0];
			c[1] = f[1];
		}
		s = String.valueOf(c);
		return s.substring(0, 8);
	}

	public static void main(String[] args) throws ParseException {
		// Scanner in = new Scanner(System.in);
		// String s = in.next();

		String month = "08";
		String day = "05";
		String year = "2005";
		LocalDate.Month
		LocalDate dt = LocalDate.of(yy, mm, dd);
		System.out.print(dt.getDayOfWeek());
		LocalDate localDate = LocalDate.of(Integer.parseInt(year), new Month, Integer.parseInt(day));
		System.out.println(f2.format(d));
		
		Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println("Day: " + calendar.get(Calendar.DAY_OF_WEEK));

		int number = 13;
		String numberAsString = String.format("%03d", number);
		System.out.println(numberAsString);

		String result = timeConversion("12:40:22AM");
		System.out.println(result);

		printSeries();
	}

	static void printSeries() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[][] arr = new int[t][3];
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			arr[i][0] = a;
			arr[i][1] = b;
			arr[i][2] = n;
		}
		in.close();

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr[i][2]; j++) {
				System.out.print((sum + (arr[i][0] + (int) Math.pow(2, j) * arr[i][1])) + " ");
			}
			System.out.println();
		}
	}
}
