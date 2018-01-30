package linkedlist;

public class _2_2_Return_Kth_Last_Value {

	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addAll(1, 5, 2, 3, 3, 4, 5, 3, 5, 6);

		linkedList.traverse();
		returnKthLastValue(linkedList.head, 3);
		returnKthLastValue(linkedList.head, 0);
		returnKthLastValue(linkedList.head, 10);

		returnKthValueWithRunnerPointer(linkedList.head, 3);
		returnKthValueWithRunnerPointer(linkedList.head, 0);
		returnKthValueWithRunnerPointer(linkedList.head, 10);

	}

	// Time Complexity - O(n)
	static void returnKthLastValue(Node head, int position) {
		Node temp = head;
		int length = 0;
		while (temp != null) {
			length++;
			temp = temp.next;
		}

		temp = head;
		for (int i = 0; i < (length - position - 1); i++) {
			temp = temp.next;
		}

		if (temp != null) {
			System.out.println("\nValue at position " + position + " is " + temp.data);
		} else {
			System.out.println("Value Not found for position " + position);
		}

	}

	// Time Complexity - O(n)
	static void returnKthValueWithRunnerPointer(Node head, int position) {
		Node first = head;
		Node second = head;

		for (int i = 0; i < position; i++) {
			if (first == null) {
				System.out.println("Out of Bound!");
			}
			first = first.next;
		}

		if (first == null) {
			System.out.println("\nValue at position " + position + " is " + second.data);
			return;
		}
		while (first.next != null) {
			first = first.next;
			second = second.next;
		}

		if (second != null) {
			System.out.println("\nValue at position " + position + " is " + second.data);
		} else {
			System.out.println("Value Not found for position " + position);
		}

	}
}
