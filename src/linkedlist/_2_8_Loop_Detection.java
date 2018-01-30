package linkedlist;

public class _2_8_Loop_Detection {

	public static void main(String[] args) {
		SingleLinkedList l1 = new SingleLinkedList();
		Node node1 = new Node(8);
		Node node2 = new Node(9);
		Node node3 = new Node(10);
		Node node4 = new Node(11);
		Node node5 = new Node(12);
		Node node6 = new Node(7);
		Node node7 = new Node(6);
		Node node8 = new Node(5);

		node5.next = node1;
		l1.add(node5);
		l1.add(node4);
		l1.add(node3);
		l1.add(node2);
		l1.add(node1);
		node6.next = node1;
		l1.add(node6);
		l1.add(node7);
		l1.add(node8);
		// l1.traverse();

		Node startingLoopNode = loopDetection(l1.head);
		System.out.println("\n\rResult:" + (startingLoopNode == null ? "null" : startingLoopNode.data));

	}

	private static Node loopDetection(Node head1) {
		if (head1 == null) {
			return null;
		}
		Node slow = head1;
		Node fast = head1;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		slow = head1;

		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}
