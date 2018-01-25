package greytip;

public class ReplaceAllSubString {
	public static void main(String[] args) {
		String input1 = "bkllkbblb";
		String input2 = "kl";
		String input3 = "bl";
		String input4 = "b";

		removeAllSubString(input1, input2, input3, input4);
	}

	private static void removeAllSubString(String input1, String input2, String input3, String input4) {

		while (input1.contains(input2) || input1.contains(input3) || input1.contains(input4)) {
			input1 = input1.replaceFirst(input2, "");
			System.out.println(input1);
			input1 = input1.replaceFirst(input3, "");
			System.out.println(input1);
			input1 = input1.replaceFirst(input4, "");
			System.out.println(input1);

			input1 = input1.replaceFirst(input4, "");
		}
		System.out.println(input1.length());

	}
}
