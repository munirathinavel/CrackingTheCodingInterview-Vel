package strings_arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_2_PermutationToEachOther {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "bca1";

		// System.out.println("Result:" + permutationToEachOther(str1, str2));

		System.out.println("Result:" + permutationToEachOtherSort(str1, str2));

		System.out.println("Result:" + permutationToEachOtherBit(str1, str2));

	}

	// Complexity - O(n) - Space - n
	private static boolean permutationToEachOther(String str1, String str2) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < str1.length(); i++) {
			String key = String.valueOf(str1.charAt(i));
			map.put(key, (map.get(key) == null ? 0 : map.get(key)) + 1);
		}

		for (int i = 0; i < str2.length(); i++) {
			String key = String.valueOf(str1.charAt(i));
			map.put(key, (map.get(key) == null ? 0 : map.get(key)) - 1);
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 0) {
				return false;
			}
		}

		return true;
	}

	// Complexity - O(n log n) Space - n
	private static boolean permutationToEachOtherSort(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		return sort(str1).equals(sort(str2));
	}

	static String sort(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	// Complexity - O(n) & space n
	private static boolean permutationToEachOtherBit(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		char[] a = new char[256];

		for (int i = 0; i < str1.length(); i++) {
			a[str1.charAt(i)]++;
		}

		for (int i = 0; i < str2.length(); i++) {
			a[str2.charAt(i)]--;

			if (a[str2.charAt(i)] < 0) {
				return false;
			}
		}

		return true;
	}

}
