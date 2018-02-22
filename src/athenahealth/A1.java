package athenahealth;

public class A1 {
	public static void main(String[] args) {

		System.out.println(rollTheString("vwxyz", new int[] { 1, 2, 3, 4, 5 }));
	}

	static String rollTheString(String s, int[] roll) {
		StringBuilder sb = new StringBuilder(s);
		int n = roll.length;
		int lastIndex = 0;
		for (int i = 0; i < n; i++) {
			lastIndex = roll[i];
			for (int j = 0; j < lastIndex; j++) {
				char c;
				if (sb.charAt(j) == 'z') {
					c = 'a';
				} else {
					c = (char) (sb.charAt(j) + 1);
				}
				sb.setCharAt(j, c);
			}
		}
		return sb.toString();
	}

}

/*
 * String s = "abz"; int roll = 3;
 * 
 * for (int j = 0; j < 3; j++) { char c; if (s.charAt(j) == 'z') { c = 'a'; }
 * else { c = (char) (s.charAt(j) + 1); } s = s.replace(s.charAt(j), c); }
 * 
 * System.out.println((int) 'a'); System.out.println((int) 'z');
 * 
 * System.out.println(s);
 */