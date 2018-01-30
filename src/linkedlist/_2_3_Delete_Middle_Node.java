package linkedlist;

public class _2_3_Delete_Middle_Node {

	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addAll(1, 5, 2, 3, 3, 4, 5, 3, 5, 6);

		linkedList.traverse();
		deleteMiddleNode(linkedList.head);
		linkedList.traverse();

	}

	/**
	 * Given that there is only one node access given in the list.
	 * 
	 */
	// Time Complexity - O(n) - Space - n
	static boolean deleteMiddleNode(Node deleteNode) {
		if (deleteNode == null || deleteNode.next == null) {
			return false;
		}
		Node next = deleteNode.next;
		deleteNode.data = next.data;
		deleteNode.next = next.next;
		return true;
	}
}
