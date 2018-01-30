package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _2_1_Remove_Duplicates {

	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addAll(1, 5, 2, 3, 3, 4, 5, 3, 5, 6);

		linkedList.traverse();
		deleteDuplicates(linkedList.head);
		linkedList.traverse();

		SingleLinkedList l2 = new SingleLinkedList();
		l2.addAll(1, 5, 2, 3, 3, 4, 5, 3, 5, 6);
		l2.traverse();
		removeDuplicatesNoSpace(l2.head);
		l2.traverse();
	}

	// Time Complexity - O(n) - Space - n
	static void deleteDuplicates(Node head) {
		Set<Integer> set = new HashSet<Integer>();

		Node temp = head;
		Node previous = null;
		while (temp != null) {
			if (set.contains(temp.data)) {
				previous.next = temp.next;
			} else {
				set.add(temp.data);
				previous = temp;
			}
			temp = temp.next;
		}
	}

	// Time Complexity - O(n2) Space Complexity - n
	static void removeDuplicatesNoSpace(Node head) {
		Node current = head;
		// 1-> 2->3->4->4->5->2->6
		while (current != null) {
			Node runner = current;

			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
}
