package practise;

import java.util.Hashtable;

public class FindPairsWithDifferenceK {

	public static void main(String[] args) {

		int[] pairs = new int[] { 2, 3, 5, 4, 7, 8, 11, 9, 12 };
		int difference = 2;
		bruteForce(pairs, difference);
		optimalSolution(pairs, difference);
	}

	static void bruteForce(int[] pairs, int k) {
		int count = 0;
		for (int i = 0; i < pairs.length; i++) {
			for (int j = i + 1; j < pairs.length; j++) {
				if (pairs[i] - pairs[j] == k || pairs[j] - pairs[i] == k) {
					System.out.println("Pair:" + pairs[i] + " & " + pairs[j]);
					count++;
				}
			}
		}
		System.out.println("Total No. of Pairs:" + count);
	}

	static void optimalSolution(int[] pairs, int difference) {
		int count = 0;
		Hashtable<Integer, Integer> hashTable = new Hashtable<>();
		for (int i = 0; i < pairs.length; i++) {
			if (hashTable.get(pairs[i]) != null) {
				hashTable.put(pairs[i], hashTable.get(pairs[i] + 1));
			} else {
				hashTable.put(pairs[i], 1);

			}
		}

		for (int i = 0; i < pairs.length; i++) {
			if (hashTable.containsKey(pairs[i] - difference)) {
				System.out.println("Pair-1:" + pairs[i] + " & " + (pairs[i] - difference));
				count++;
			} else if (hashTable.containsKey(pairs[i] + difference)) {
				System.out.println("Pair-2:" + pairs[i] + " & " + (pairs[i] + difference));
				count++;
			}
			hashTable.remove(pairs[i]);
		}
		System.out.println("Total No. of Pairs:" + count);
	}

}
