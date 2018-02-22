package hacherrank;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		for (int i = 0; i < a.length - 1; i++) {
			int temp = a[i];
			if (i + k < n - 1) {
				a[i] = a[(i + k)];
				a[(i + k)] = temp;
			} else {
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}

		}
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
