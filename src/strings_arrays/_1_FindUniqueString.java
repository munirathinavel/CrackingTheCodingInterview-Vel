package strings_arrays;

import java.util.Arrays;

public class _1_FindUniqueString {

	public static void main(String[] args) {

		String str = "abcdef1";
		// 11111111 11111111 11111111 11111110
		int x = 4; // 1000 0100 >> 1000 0010
		System.out.println(Integer.toBinaryString(x));
		System.out.println("4 >> 1: (Binary):" + Integer.toBinaryString(x >> 1));
		System.out.println("4 >> 1:" + (x >> 1));
		System.out.println("1 << 4: (Binary):" + Integer.toBinaryString(1 << x));
		System.out.println("1 << 4:" + (1 << x));
		int y = 4; // 0000 0100 >> 0000 0010
		System.out.println(y >> 1);

		System.out.println("Result:" + findUniqueString(str));

		System.out.println("Result:" + findUniqueStringUpdated(str));

		System.out.println("Result:O(n log n):" + findUniqueStringASCII(str));

		System.out.println("Result:O(n) - Extra Space:" + findUniqueStringASCIIExtraSpace(str));

		System.out.println("Result:O(n) - Bit Checker :" + findUniqueStringInBitWithChecker(str));

	}

	// Find Unique String - Complexity - O(n2)
	static boolean findUniqueString(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	// Find Unique String - Complexity - O(n log n)
	static boolean findUniqueStringASCII(String str) {
		char[] a = str.toCharArray();
		Arrays.sort(a);

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] == a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// Find Unique String - Complexity - O(n) - Extra Space
	static boolean findUniqueStringASCIIExtraSpace(String str) {
		if (str.length() > 256) {
			return false;
		}
		boolean[] a = new boolean[256];
		Arrays.fill(a, false);

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i);
			if (a[index] == true) {
				return false;
			} else {
				a[index] = true;
			}
		}
		return true;
	}

	// Find Unique String - Complexity - O(n) - Bit Checker - only applicable to a-z
	// or A-Z
	static boolean findUniqueStringInBitWithChecker(String str) {
		int index = 0;
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			index = str.charAt(i) - 'a';

			if ((checker & (1 << index)) > 0) {
				return false;
			}

			checker = checker | (1 << index);
		}

		return true;
	}

	// Find Unique String - Complexity - O(n)
	static boolean findUniqueStringUpdated(String str) {

		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker = checker | (1 << val);
		}
		return true;
	}

}
