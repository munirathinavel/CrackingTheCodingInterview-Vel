package strings_arrays;

public class _1_5_OneAway {

	public static void main(String[] args) {

		String s1 = "a2c";
		String s2 = "a1cd";

		System.out.println("Result:" + oneEditAway1(s1, s2));

		System.out.println("Result:" + oneEditAway2(s1, s2));
	}

	static boolean oneEditAway1(String first, String second) {

		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}

		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() > second.length() ? second : first;

		int i = 0, j = 0;
		int diffCount = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				diffCount++;
				if (diffCount > 1) {
					return false;
				}
				// Move shorter pointer only if strings are of same length
				if (s1.length() == s2.length()) {
					i++;
				}
			} else {
				i++; // Move Shorter string pointer
			}
			j++; // Always move longer String pointer
		}

		return false;
	}

	static boolean oneEditAway2(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return oneReplaceAway(s1, s2);
		}
		if (s1.length() + 1 == s2.length()) {
			return oneInsertAway(s1, s2);
		}
		if (s1.length() - 1 == s2.length()) {
			return oneInsertAway(s2, s1);
		}
		return false;
	}

	private static boolean oneReplaceAway(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean oneInsertAway(String s1, String s2) {
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(i)) {
				j++;

				if (i != j) {
					return false;
				}
			} else {
				i++;
				j++;
			}
		}
		return true;
	}

}
