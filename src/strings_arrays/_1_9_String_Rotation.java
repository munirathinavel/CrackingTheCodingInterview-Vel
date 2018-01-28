package strings_arrays;

public class _1_9_String_Rotation {

	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "CDAB";

		System.out.println(s1.length() == s2.length() && (s1 + s1).indexOf(s2) != -1);

	}
}