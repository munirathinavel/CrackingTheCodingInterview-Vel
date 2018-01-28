package strings_arrays;

public class _1_7_Rotate_Array {

	public static void main(String[] args) {

		rotateArray90DegreeRight(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

		rotateArray90DegreeRight(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });

		rotateArray180DegreeRight(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

		rotateArray180DegreeRight(
				new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });

		rotateArrayLeftOr180DegreeRight(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
	}

	private static void rotateArrayLeftOr180DegreeRight(int[][] a) {
		if (a.length == 0 || a.length != a[0].length) {
			return;
		}

		int n = a.length;

		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][n - 1 - i];
				a[j][n - 1 - i] = a[n - 1 - i][n - 1 - j];
				a[n - 1 - i][n - 1 - j] = a[n - 1 - j][i];
				a[n - 1 - j][i] = temp;
			}
		}

		printArray(a, n);

	}

	static void rotateArray90DegreeRight(int[][] a) {
		if (a.length == 0 || a.length != a[0].length) {
			return;
		}
		int n = a.length;

		// Logic is to shift elements in the different layers
		// left -> top
		// bottom -> left
		// right -> left
		// top -> right
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				// Store Top
				int temp = a[i][j];

				// set left -> top
				a[i][j] = a[n - 1 - j][i];

				// set bottom -> left
				a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];

				// set right -> bottom
				a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];

				// set top -> right
				a[j][n - 1 - i] = temp;
			}
		}

		printArray(a, n);
	}

	private static void printArray(int[][] a, int n) {
		System.out.println("\n\rPrinting rotated Array:");
		for (int i = 0; i < n; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
		}
	}

	static void rotateArray180DegreeRight(int[][] a) {
		if (a.length == 0 || a.length != a[0].length) {
			return;
		}
		int n = a.length;

		// Logic is to shift elements in the different layers
		// bottom -> top
		// top -> bottom
		// right -> left
		// left -> right
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = a[i][j];
				a[i][j] = a[n - 1 - i][n - 1 - j];
				a[n - 1 - i][n - 1 - j] = temp;

				temp = a[n - 1 - j][i];
				a[n - 1 - j][i] = a[j][n - 1 - i];
				a[j][n - 1 - i] = temp;
			}
		}

		printArray(a, n);
	}
}
