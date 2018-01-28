package strings_arrays;

import java.util.HashMap;
import java.util.Map;

public class _1_4_PalindromePermutation {

	public static void main(String[] args) {
		String str = "tactcoaddf";

		System.out.println("Result:" + checkPalindromePermutation(str));
		System.out.println("Result:" + checkPalindromePermutationWithBit(str));

	}

	// Time Complexity - O(n) with space - O(n)
	static boolean checkPalindromePermutation(String str) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), (map.get(str.charAt(i)) == null ? 0 : map.get(str.charAt(i))) + 1);
		}

		int oddCount = 0;
		for (int value : map.values()) {
			if (value % 2 == 1) {
				oddCount++;
			}
			if (oddCount > 1) {
				return false;
			}
		}

		return true;
	}

	static boolean checkPalindromePermutationWithBit(String str) {
		int bitString = 0;
		int cValue = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('a' <= c && c <= 'z') {
				cValue = Character.getNumericValue(c) - Character.getNumericValue('a');
			}

			if (cValue >= 0) {
				int mask = 1 << cValue;

				// Checking if current value & integer bit is returning zero.
				// 1111 0000 & 0000 0010 => 0000
				if ((bitString & mask) == 0) {
					// Setting corresponding character bit to 1
					// 1111 0000 | 0000 0010 => 1111 0010
					bitString = bitString | mask;
				} else {
					// 1111 0000 & 1111 1101 => 1111 0000
					// Set corresponding bit of the character to 0 again.
					bitString = bitString & ~mask;
				}
			}
		}

		// To check only bit odd bit available
		if ((bitString & (bitString - 1)) != 0) {
			return false;
		}

		return true;
	}
}
