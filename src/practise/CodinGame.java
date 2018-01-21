package practise;

import java.util.Arrays;

public class CodinGame {

	public static void main(String[] args) {
		System.out.println(exists(new int[] { -9, 14, 37, 102 }, 102));

		System.out.println(binarySearch(new int[] { -9, 14, 37, 102 }, 102));
	}

	static boolean exists(int[] ints, int k) {
		if (Arrays.binarySearch(ints, k) >= 0)
			return true;

		int start = 0;
		int end = ints.length - 1;
		while (start <= end) {
			int mid = (end + start) / 2;
			if (k == ints[mid]) {
				return true;
			} else if (k < ints[mid]) {
				end = mid - 1;
			} else if (k > ints[mid]) {
				start = mid + 1;
			}
		}
		return false;
	}

	static int binarySearch(int[] inputArr, int key) {

		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
