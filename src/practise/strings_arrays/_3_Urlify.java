package practise.strings_arrays;

public class _3_Urlify {

	public static void main(String[] args) {

		char[] str = "Mr CM Vel    ".toCharArray();
		int trueLength = 9;
		int spaceCount = 0;

		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		int index = trueLength + spaceCount * 2;
		if (trueLength < str.length)
			str[trueLength] = '\0';

		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}

		System.out.println(str);
	}
}
