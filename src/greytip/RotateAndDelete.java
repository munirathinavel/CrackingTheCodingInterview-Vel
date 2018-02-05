package greytip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class RotateAndDelete {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println(rotateAndDelete(new int[] { 1, 2, 3, 4, 5, 6 }));

		System.out.println(rotateAndDeleteLinkedList(a));
		System.out.println(rotateAndDeleteArrayList(a));
	}

	// Linked List implementation
	static int rotateAndDeleteArrayList(int a[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : a) {
			list.add(i);
		}

		int i = 0;
		while (list.size() > 1) {
			// This moves last element to first.
			Collections.rotate(list, 1);

			int size = list.size();
			if (size - 1 - i > 0) {
				// Remove ith last element until we reach 0th position
				list.remove(size - 1 - i);
			} else {
				// Remove 0th position once we reach 0
				list.remove(0);
			}
			i++;
		}

		return list.get(0);
	}

	// Linked List implementation
	static int rotateAndDeleteLinkedList(int a[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i : a) {
			list.add(i);
		}
		// Collections.rotate(list, 1);

		for (int i = 0; i < list.size() - 1; i++) {
			list.addFirst(list.removeLast());
			int size = list.size();

			if (size - 1 - i >= 0) {
				list.remove(size - 1 - i);
			} else {
				list.removeFirst();
			}
		}

		return list.getFirst();
	}

	// Simple Array to rotate & delete nth last element and return result.
	static int rotateAndDelete(int a[]) {
		int result = 0;

		int last;

		int counter = 1;

		while (a.length > 0) {

			if (a.length == 0) {
				return 0;
			} else if (a.length == 1) {
				return a[0];
			}

			int index = a.length - 1;
			last = a[index];

			// Shifting the elements
			for (int j = a.length - 1; j > 0; j--) {
				a[j] = a[j - 1];
			}
			a[0] = last;

			// Deleting the element
			int[] temp = new int[index];
			if (counter > a.length) {
				a[0] = 0;
			} else {
				a[a.length - counter] = 0;
			}

			int k = 0;

			for (int i = 0; i < a.length; i++) {
				if (a[i] == 0) {
					continue;
				}
				temp[k] = a[i];
				k++;
			}

			a = temp;
			counter++;
			index--;

		}

		return result;
	}

}
