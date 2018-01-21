package practise;

public class Anagram_SubStringSearch_Permutation {
	static final int MAX = 256;

	public static void main(String[] args) {
		String pattern = "ABC";
		String searchText = "ABCABCACAABCDACBDSACBAABAC";

		searchAllAnagramSubString(searchText, pattern);
	}

	static void searchAllAnagramSubString(String searchText, String pattern) {
		int count = 0;
		int m = pattern.length();
		int n = searchText.length();

		char[] countTextWindow = new char[MAX];
		char[] countPattern = new char[MAX];

		for (int i = 0; i < m; i++) {
			(countTextWindow[searchText.charAt(i)])++;
			(countPattern[pattern.charAt(i)])++;
		}

		for (int i = m; i < n; i++) {
			if (compare(countPattern, countTextWindow)) {
				count++;
				System.out.println("Text:" + searchText.substring(i - m, i) + " & Position: " + (i - m));
			}

			(countTextWindow[searchText.charAt(i)])++;
			(countTextWindow[searchText.charAt(i - m)])--;
		}

		if (compare(countPattern, countTextWindow)) {
			count++;
			System.out.println("Text:" + searchText.substring(n - m, n) + " & Position: " + (n - m));
		}
		System.out.println("Total Combinations:" + count);
	}

	static boolean compare(char[] countPattern, char[] countTextWindow) {
		for (int i = 0; i < MAX; i++) {
			if (countPattern[i] != countTextWindow[i]) {
				return false;
			}
		}
		return true;
	}
}
