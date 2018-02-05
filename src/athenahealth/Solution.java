package athenahealth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * This is program is used to determine the total number of pairs which present
 * in the diagonal.
 * 
 * @author munirathinavel
 *
 *         Sample Input:
 *
 *         2 
 *         2 
 *         8 5 
 *         1 10 
 *         4  
 *         9 9
 *         3 3 
 *         6 6 
 *         2 2
 * 
 *         Output
 *
 *         0 4
 */
public class Solution {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner scanner = new Scanner(System.in);

		// Reading No. of Test Cases 'T'
		int T = Integer.parseInt(scanner.nextLine().trim());
		if (T > 10 && T < 1) {
			throw new RuntimeException("Input out of Range");
		}
		List<String> trueCells = null;
		List<List<String>> testCases = new ArrayList<List<String>>();
		List<Integer> diagonals = new ArrayList<>();
		int N = 0;

		for (int i = 0; i < T; i++) {
			trueCells = new ArrayList<String>();
			// Reading the no. of True Cells (Co-ordinates)
			N = Integer.parseInt(scanner.nextLine().trim());
			if (N > 100000 && N < 1) {
				throw new RuntimeException("Input out of Range");
			}
			for (int j = 0; j < N; j++) {
				// Reading the co-ordinates
				String str = scanner.nextLine().trim();
				int value1 = Integer.parseInt(str.split(" ")[0]);
				int value2 = Integer.parseInt(str.split(" ")[1]);
				if (value1 > 0 && value1 <= 1000000 && value2 > 0 && value1 <= 1000000) {
					trueCells.add(str);
				} else {
					throw new RuntimeException("Input out of Range");
				}
			}
			testCases.add(trueCells);
		}
		scanner.close();

		// Finding Diagonals
		// Iterating through number of test cases.
		for (List<String> testcase : testCases) {
			Map<Integer, Integer> interDiagonals = new HashMap<>();

			// Iterating through test case inputs
			for (int k = 0; k < testcase.size() && interDiagonals.size() <= testcase.size(); k++) {
				for (int l = k + 1; l < testcase.size() && interDiagonals.size() <= testcase.size(); l++) {

					int i = Integer.parseInt(testcase.get(k).split(" ")[0]);
					int j = Integer.parseInt(testcase.get(k).split(" ")[1]);

					int p = Integer.parseInt(testcase.get(l).split(" ")[0]);
					int q = Integer.parseInt(testcase.get(l).split(" ")[1]);

					if (Math.abs(p - i) == Math.abs(q - j)) {
						interDiagonals.put(i, j);
						interDiagonals.put(p, q);
					}

				}
			}

			if (interDiagonals != null && interDiagonals.size() >= 2) {
				diagonals.add(interDiagonals.size());
			} else {
				diagonals.add(0);
			}
		}
		// Printing the diagonals
		for (Integer i : diagonals) {
			if (i != null) {
				System.out.println(i);
			}
		}

	}
}
