package athenahealth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		sc.close();

		// Checking if given string is null or empty
		if (s == null || s.isEmpty()) {
			return;
		}

		// Remove and add all valid parenthesis recursively
		List<String> ss = removeAndPrintBalancedParanthesis(s);

		// Printing all valid parenthesis
		ss.forEach(str -> {
			System.out.println(str);
		});
	}

	public static List<String> removeAndPrintBalancedParanthesis(String s) {
		List<String> result = new ArrayList<>();
		char[] p = new char[] { '(', ')' };

		// Calling Making this method to collect all valid parenthesis recursively.
		addValidPatenthesisRecursively(result, s, p, 0, 0);
		return result;
	}

	private static void addValidPatenthesisRecursively(List<String> result, String s, char[] p, int iStart,
			int jStart) {
		int stack = 0, i;
		for (i = iStart; i < s.length(); i++) {
			if (s.charAt(i) == p[0])
				stack++;
			if (s.charAt(i) == p[1])
				stack--;
			// remove each (not consecutive) p[1] from jStart to i to make valid
			if (stack < 0) {
				for (int j = jStart; j <= i; j++) {
					if (s.charAt(j) == p[1] && (j == jStart || s.charAt(j - 1) != p[1])) {
						String r = s.substring(0, j) + s.substring(j + 1);
						addValidPatenthesisRecursively(result, r, p, i, j);
					}
				}
				return;
			}
		}
		// stack >= 0 : Reverse the string by calling addValidPatenthesisRecursively,
		// else add to result
		String reverse = new StringBuilder(s).reverse().toString();
		if (p[0] == '(')
			// To reverse pass initial state with the balanced string s
			addValidPatenthesisRecursively(result, reverse, new char[] { ')', '(' }, 0, 0);
		else
			result.add(reverse);
	}
}