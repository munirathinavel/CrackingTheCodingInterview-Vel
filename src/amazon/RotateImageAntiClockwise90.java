package amazon;

public class RotateImageAntiClockwise90 {

	/**
	 * Rotate array to 90 degree
	 * 1 2 3      3 6 9
	 * 4 5 6  ==> 2 5 8
	 * 7 8 9   	  1 4 7
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] b = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		rotateArrayTo90Degree(a);
		printArray(a);

		rotateArrayTo90Degree(b);
		printArray(b);

		int[][] c = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateArrayTo90DegreeSingleStep(c);
		printArray(c);
	}

	private static void printArray(int[][] a) {

		System.out.println("Printing Array:" + a.length + " X " + a[0].length);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Rotate Array with 2 for loops
	private static void rotateArrayTo90Degree(int[][] a) {
		int n = a.length;
		/**
		 * This rotates symmetric elements in the array.
		 * 
		 * 1 4 7
		 * 2 5 8
		 * 3 6 9
		 */
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a[0].length; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}

		/**
		 * This exchanges the columns
		 * 
		 * 3 6 9
		 * 2 5 8
		 * 1 4 7
		 */
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = a[i][j];
				a[i][j] = a[n - 1 - i][j];
				a[n - 1 - i][j] = temp;
			}
		}
	}
	
	/**
	 * Rotate array to 90 degree
	 * 1 2 3      3 6 9
	 * 4 5 6  ==> 2 5 8
	 * 7 8 9   	  1 4 7
	 * 
	 * 
	 */
	// Rotate Array with single step with for loops
	private static void rotateArrayTo90DegreeSingleStep(int[][] a) {
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
	}
	
}
