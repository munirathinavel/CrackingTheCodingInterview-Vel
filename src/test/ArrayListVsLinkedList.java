package test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVsLinkedList {
	public static void main(String args[]) {
		ArrayList al = new ArrayList();
		LinkedList ll = new LinkedList();
		int max_value = 100000000;

		// --------------------------------ArrayList-----------------------------------

		for (int i = 0; i <= max_value; i++) {
			ll.add(Integer.valueOf(i));
			al.add(Integer.valueOf(i));
		}

		int middle = max_value / 2;

		long d1 = System.currentTimeMillis();
		al.add(middle, Integer.valueOf(5));
		al.add(middle, Integer.valueOf(5));
		al.remove(middle);
		al.add(middle, Integer.valueOf(5));
		al.remove(middle);
		al.add(middle, Integer.valueOf(5));
		al.remove(middle);
		al.add(middle, Integer.valueOf(5));
		al.remove(middle);
		al.add(middle, Integer.valueOf(5));

		long d2 = System.currentTimeMillis();
		System.out.println("Time Taken in ArrayList:  " + (d2 - d1));

		// --------------------------------LinkedList-----------------------------------

		long d3 = System.currentTimeMillis();
		ll.add(middle, Integer.valueOf(5));
		ll.add(middle, Integer.valueOf(5));
		ll.remove(middle);
		ll.add(middle, Integer.valueOf(5));
		ll.remove(middle);
		ll.add(middle, Integer.valueOf(5));
		ll.remove(middle);
		ll.add(middle, Integer.valueOf(5));
		ll.remove(middle);
		ll.add(middle, Integer.valueOf(5));

		long d4 = System.currentTimeMillis();
		System.out.println("Time Taken in LinkedList:  " + (d4 - d3));

	}

}
