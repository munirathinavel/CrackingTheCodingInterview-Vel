package linkedlist;

public class _2_5_Sum_Linked_List {

	public static void main(String[] args) {
		SingleLinkedList l1 = new SingleLinkedList();
		l1.addAll(6, 1);
		l1.traverse();

		SingleLinkedList l2 = new SingleLinkedList();
		l2.addAll(2, 9, 5);
		l2.traverse();

		SingleLinkedList resultList = sum2list(l1.head, l2.head);
		resultList.traverse();

		Node node = sum2listWithCarry(l1.head, l2.head, 0);

		System.out.println("\nPrinting List:\n");
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	static SingleLinkedList sum2list(Node l1, Node l2) {
		SingleLinkedList l3 = new SingleLinkedList();
		int carry = 0;

		while (l1 != null || l2 != null) {
			if (l1 == null) {
				l3.add((l2.data + carry) % 10);
				carry = (l2.data + carry) / 10;
				l2 = l2.next;
			} else if (l2 == null) {
				l3.add((l1.data + carry) % 10);
				carry = (l1.data + carry) / 10;
				l1 = l1.next;
			} else {
				l3.add((l1.data + l2.data) % 10 + carry);
				carry = (l1.data + l2.data) / 10;
				l1 = l1.next;
				l2 = l2.next;
			}
		}

		return l3;
	}

	static Node sum2listWithCarry(Node l1, Node l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		Node result = new Node(0);
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}

		if (l2 != null) {
			value += l2.data;
		}

		result.data = value % 10;

		if (l1 != null || l2 != null) {
			Node more = sum2listWithCarry((l1 == null ? null : l1.next), (l2 == null ? null : l2.next),
					value >= 10 ? 1 : 0);
			result.next = more;
		}

		return result;
	}
}
