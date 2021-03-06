package amazon;

public class RotateImage {

	/**
	 * Rotate array to 90 degree
	 * 1 2 3      7 4 1
	 * 4 5 6  ==> 8 5 2
	 * 7 8 9   	  9 6 3
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
		
		int[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(d);
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
		 * 7 4 1
		 * 8 5 2
		 * 9 6 3
		 */
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = a[i][j];
				a[i][j] = a[i][n - 1 - j];
				a[i][n - 1 - j] = temp;
			}
		}
	}
	
	// Rotate Array with single step with for loops
	private static void rotateArrayTo90DegreeSingleStep(int[][] a) {
		int n = a.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = a[i][j];
				a[i][j] = a[n - 1 - j][i];
				a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
				a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
				a[j][n - 1 - i] = temp;
			}
		}
	}
	
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}

		if (matrix != null && matrix.length > 1) {
			System.out.println("[");
			for (int i = 0; i < n; i++) {
				System.out.print("[");
				for (int j = 0; j < n; j++) {
					System.out.print(matrix[i][j] + ", ");
				}
				System.out.print("]");
				if (i < n - 1) {
					System.out.println(",");
				} else {
					System.out.println();
				}
			}
			System.out.println("]");
		}

	}

}
