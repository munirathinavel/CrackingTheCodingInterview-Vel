package linkedlist;

public class _2_7_Intersection {

	public static void main(String[] args) {
		SingleLinkedList l1 = new SingleLinkedList();

		Node node1 = new Node(6);
		Node node2 = new Node(4);
		Node node3 = new Node(2);
		Node node4 = new Node(21);

		l1.add(node1);
		l1.add(node2);
		l1.add(node3);
		l1.add(node4);

		l1.addAll(7, 4, 3, 2, 1);
		l1.traverse();

		SingleLinkedList l2 = new SingleLinkedList();
		l2.add(node1);
		l2.add(node2);
		l2.add(node3);
		l2.add(node4);
		l2.addAll(1, 2, 3, 4, 3, 2, 1);
		l2.traverse();

		Node node = checkIntersection(l1.head, l2.head);
		System.out.println("\n\rResult:" + (node == null ? "null" : node.data));

	}

	private static Node checkIntersection(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}

		// Find the size & tail of the listS
		Result result1 = findSizeAndTail(head1);
		Result result2 = findSizeAndTail(head2);

		// If tail is different, then return false right away
		if (result1.tail != result2.tail) {
			return null;
		}

		Node shorter = result1.size < result2.size ? head1 : head2;
		Node longer = result1.size < result2.size ? head2 : head1;

		// Find the difference & Move longer list pointer to that difference
		int k = Math.abs(result1.size - result2.size);
		while (k > 0 && longer != null) {
			longer = longer.next;
			k--;
		}

		// Move longer & shorter togther until the collusion occurs
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		return longer;
	}

	static Result findSizeAndTail(Node head) {
		int size = 0;
		while (head.next != null) {
			size++;
			head = head.next;
		}

		Result result = new Result();
		result.size = size + 1;
		result.tail = head;

		return result;
	}

}

class Result {
	int size;
	Node tail;
}