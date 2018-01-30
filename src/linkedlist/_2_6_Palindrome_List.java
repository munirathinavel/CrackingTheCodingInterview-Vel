package linkedlist;

import java.util.Stack;

public class _2_6_Palindrome_List {

	public static void main(String[] args) {
		SingleLinkedList l1 = new SingleLinkedList();
		l1.addAll(1, 2, 3, 4, 3, 2, 1);
		l1.traverse();

		System.out.println("Result:" + checkPalindromeList(l1.head));

	}

	private static boolean checkPalindromeList(Node head) {
		if (head == null) {
			return false;
		}
		Node slow = head;
		Node fast = head;
		Stack<Integer> stack = new Stack<>();

		while (fast != null & fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		// Move slow to next if length is Odd
		if (head != null) {
			slow = slow.next;
		}

		while (slow != null) {

			if (stack.pop() != slow.data) {
				return false;
			}
			slow = slow.next;
		}

		return true;
	}

}
