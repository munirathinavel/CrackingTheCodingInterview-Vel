package linkedlist;

public class _2_4_Partition_LinkedList {

	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addAll(1, 5, 2, 8, 13, 3, 4, 5, 3, 5, 1, 6, 8, 2, 3, 1, 0);

		linkedList.traverse();
		/*
		 * Node head = partitionByDummyNode(linkedList.head, 5);
		 * 
		 * linkedList.traverse(); System.out.println("\nLinked List after partition:");
		 * while (head != null) { System.out.print(head.data + " "); head = head.next; }
		 */
		/*
		 * partition(linkedList.head, 5);
		 * 
		 * linkedList.traverse();
		 */
		/*
		 * partitionMiddleNode(linkedList.head, 5); linkedList.traverse();
		 */

		partitionByDummyNode(linkedList.head, 5);
		linkedList.traverse();

	}

	/**
	 * Given that there is only one node access given in the list.
	 * 
	 */

	// Time Complexity - O(n)
	static Node partitionByDummyNode(Node head, int x) {
		if (head == null) {
			return head;
		}
		Node head1 = new Node(0);
		Node head2 = new Node(0);
		head1.next = head;

		Node p = head;
		Node prev = head1;
		Node p2 = head2;

		while (p != null) {
			if (p.data < x) {
				p = p.next;
				prev = prev.next;
			} else {
				p2.next = p;
				prev.next = p.next;
				p = p.next;
				p2 = p2.next;
			}
		}
		p2.next = null;

		prev.next = head2.next;
		return head1.next;
	}

	public static Node partition(Node head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		Node head1 = new Node(0); // List with values less than x
		Node head2 = new Node(0); // List with valules greater than x
		head1.next = head; // Setting head to the first head

		Node pointer1 = head1;
		Node pointer2 = head2;

		while (pointer1.next != null) {
			if (pointer1.next.data >= x) {
				pointer2.next = new Node(pointer1.next.data);
				pointer2 = pointer2.next;
				pointer1.next = pointer1.next.next;
			} else {
				pointer1 = pointer1.next;
			}
		}

		pointer1.next = head2.next;

		return head1.next;

	}

	public static Node partition1(Node head, int x) {
		if (head == null)
			return null;

		Node fakeHead1 = new Node(0);
		Node fakeHead2 = new Node(0);
		fakeHead1.next = head;

		Node p = head;
		Node prev = fakeHead1;
		Node p2 = fakeHead2;

		while (p != null) {
			if (p.data < x) {
				p = p.next;
				prev = prev.next;
			} else {

				p2.next = p;
				prev.next = p.next;

				p = prev.next;
				p2 = p2.next;
			}
		}

		// close the list
		p2.next = null;

		prev.next = fakeHead2.next;

		return fakeHead1.next;
	}

}
