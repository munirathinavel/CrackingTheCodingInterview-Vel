package practise.strings_arrays;

public class _1_6_String_Compression {
	public static void main(String[] args) {
		System.out.println("Result:" + compressString("aaaaavcommmmpressssss"));
		System.out.println("Result:" + compressString("compress"));
		System.out.println("Result:" + compressString("cool"));
	}

	static String compressString(String s) {

		int compressedLength = 0;
		int repeatedCharacters = 0;
		for (int i = 0; i < s.length(); i++) {
			repeatedCharacters++;
			if ((i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1))) {
				compressedLength += 1 + String.valueOf(repeatedCharacters).length();
				repeatedCharacters = 0;
			}
		}
		System.out.println("compressedLength=" + compressedLength);
		if (compressedLength > s.length()) {
			return s;
		}

		StringBuilder compressed = new StringBuilder(compressedLength);
		for (int i = 0; i < s.length(); i++) {
			repeatedCharacters++;
			if ((i + 1 >= s.length()) || s.charAt(i) != s.charAt(i + 1)) {
				compressed.append(s.charAt(i));
				compressed.append(repeatedCharacters);

				repeatedCharacters = 0;
			}
		}

		return compressed.toString();
	}
}
