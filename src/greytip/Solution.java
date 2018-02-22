package greytip;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (sc.hasNext()) {
					a[i][j] = sc.nextInt();
				}
			}
		}
		int ROWS = a.length;
		int COLUMNS = a[0].length;

		if (ROWS < 3 || COLUMNS < 3) {
			System.out.println("0");
		}
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ROWS - 2; i++) {
			for (int j = 0; j < COLUMNS - 2; j++) {
				sum = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 1] + a[i + 2][j] + a[i + 2][j + 1]
						+ a[i+2][j + 2];
				if (sum > max) {
					max = sum;
				}
			}
		}
		System.out.println(max);
	}
}