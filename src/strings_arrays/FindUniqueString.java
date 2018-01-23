package strings_arrays;

public class FindUniqueString {

	public static void main(String[] args) {

		String str = "skls";
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
