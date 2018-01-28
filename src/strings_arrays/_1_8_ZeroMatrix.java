package strings_arrays;

public class _1_8_ZeroMatrix {

	public static void main(String[] args) {

		makeZeroMatrix(new int[][] { { 7, 2, 4 }, { 2, 0, 3 }, { 1, 1, 1 } });

		makeZeroMatrixWithSameMatrix(new int[][] { { 7, 2, 4 }, { 2, 0, 3 }, { 1, 1, 1 } });
	}

	/**
	 * This Method is used to make all rows & columns to 0 wherever rows & columns
	 * are 0
	 * 
	 */
	static void makeZeroMatrixWithSameMatrix(int[][] m) {
		boolean rowHasZero = false;
		boolean columnHasZero = false;

		for (int j = 0; j < m[0].length; j++) {
			if (m[0][j] == 0) {
				rowHasZero = true;
			}
		}

		for (int i = 0; i < m.length; i++) {
			if (m[i][0] == 0) {
				columnHasZero = true;
			}
		}

		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				if (m[i][j] == 0) {
					m[0][j] = 0;
					m[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < m.length; i++) {
			if (m[i][0] == 0) {
				for (int j = 0; j < m[0].length; j++) {
					m[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < m[0].length; j++) {
			if (m[0][j] == 0) {
				for (int i = 0; i < m.length; i++) {
					m[i][j] = 0;
				}
			}
		}

		if (rowHasZero) {
			for (int j = 0; j < m[0].length; j++) {
				m[0][j] = 0;
			}
		}

		if (columnHasZero) {
			for (int i = 0; i < m.length; i++) {
				m[i][0] = 0;
			}
		}

		printArray(m);

	}

	/**
	 * This Method is used to make all rows & columns to 0 wherever rows & columns
	 * are 0
	 * 
	 */
	static void makeZeroMatrix(int[][] m) {
		boolean[] row = new boolean[m.length];
		boolean[] column = new boolean[m[0].length];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		// Setting all rows to 0 wherever row has 0
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				for (int j = 0; j < m[0].length; j++) {
					m[i][j] = 0;
				}
			}
		}

		// Setting all rows to 0 wherever column has 0
		for (int i = 0; i < column.length; i++) {
			if (column[i]) {
				for (int j = 0; j < m.length; j++) {
					m[j][i] = 0;
				}
			}
		}

		printArray(m);
	}

	private static void printArray(int[][] m) {
		System.out.println("Printing Matrix:");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}
