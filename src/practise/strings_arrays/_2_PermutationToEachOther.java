package practise.strings_arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2_PermutationToEachOther {

	public static void main(String[] args) {

		String s1 = "abcd";
		String s2 = "badc";

		System.out.println("Result: " + checkPermuatationWithHashTable(s1, s2));

		System.out.println("Result: " + checkPermuatationWithSorting(s1, s2));

		System.out.println("Result: " + checkPermuatationWithBit(s1, s2));

	}

	private static boolean checkPermuatationWithBit(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		char[] a = new char[256];

		for (int i = 0; i < s1.length(); i++) {
			a[s1.charAt(i)]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			a[s2.charAt(i)]--;

			if (a[s2.charAt(i)] < 0) {
				return false;
			}
		}

		return true;
	}

	private static boolean checkPermuatationWithSorting(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		return sort(s1).equals(sort(s2));
	}

	// Convert String into Character Array & Sorting an Array
	// Time Complexity - O(n log n) - Sorting
	static String sort(String s1) {
		char[] a = s1.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

	// Checking permutation with Hashtable
	// Time Complexity - O(n), Space Complexity - n
	private static boolean checkPermuatationWithHashTable(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}

		Map<Character, Integer> map1 = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			map1.put(s1.charAt(i), (map1.get(s1.charAt(i)) == null ? 0 : map1.get(s1.charAt(i))) + 1);
		}

		for (int i = 0; i < s1.length(); i++) {
			map1.put(s1.charAt(i), (map1.get(s1.charAt(i)) == null ? 0 : map1.get(s1.charAt(i))) - 1);
		}

		for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
			if (entry.getValue() != 0) {
				return false;
			}
		}

		return true;
	}

}
