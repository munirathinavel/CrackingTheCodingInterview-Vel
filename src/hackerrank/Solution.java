package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
		Set<Integer> diagonals = new HashSet<>();
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
				if (Integer.parseInt(str.split(" ")[0]) > 0 && Integer.parseInt(str.split(" ")[0]) <= 1000000
						&& Integer.parseInt(str.split(" ")[1]) > 0 && Integer.parseInt(str.split(" ")[1]) <= 1000000)
					trueCells.add(str);
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
				for (int l = 0; l < testcase.size() && interDiagonals.size() <= testcase.size(); l++) {
					if (!testcase.get(k).equals(testcase.get(l))) {

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
			}
			if (interDiagonals.size() >= 2) {
				diagonals.add(interDiagonals.size());
			} else {
				diagonals.add(0);
			}
		}
		// Printing the diagonals
		for (Integer i : diagonals) {
			System.out.println(i);
		}

	}
}
