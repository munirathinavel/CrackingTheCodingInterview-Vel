package linkedlist;

public class SingleLinkedList {

	Node head;
	int length = 0;

	void add(int data) {
		addFirst(data);
	}

	void add(Node newNode) {
		// Check if the list is not null
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
		length++;
	}

	void addAll(int... is) {
		for (int i = 0; i < is.length; i++) {
			addFirst(is[i]);
		}
	}

	void addFirst(int data) {

		// Creating New Node.
		Node newNode = new Node(data);

		// Check if the list is not null
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
		length++;

	}

	// This method is used to print all values in the list.
	void traverse() {
		System.out.println("\n\nPrinting Linked List Elements:\n");
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	// This method is used to add elements at the end of the List.
	public void addEnd(int i) {
		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		Node newNode = new Node(i);
		temp.next = newNode;
		length++;
	}

	public void addAt(int data, int position) {

		if (position < 0) {
			throw new RuntimeException("Invalid position: below lower limit");
		}

		if (position > length) {
			throw new RuntimeException("Invalid position: above upper limit");
		}
		if (head == null) {
			head = new Node(data);
		} else if (position == 0) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			int k = 0;
			while (temp != null && k < position - 1) {
				k++;
				temp = temp.next;
			}
			Node newNode = new Node(data);
			newNode.next = temp.next;
			temp.next = newNode;
		}

		length++;
	}

	public int removeFirst() {
		Node deleteNode = head;
		head = head.next;
		int deletedValue = deleteNode.data;
		deleteNode = null;
		length--;
		return deletedValue;
	}

	public int removeLast() {
		Node temp = head;
		Node previous = null;

		if (head == null) {
			throw new RuntimeException("No element in List");
		}
		if (head.next == null) {
			head = null;
		}

		while (temp.next != null) {
			previous = temp;
			temp = temp.next;

		}
		int deletedValue = temp.data;
		previous.next = null;
		temp = null;
		length--;
		return deletedValue;

	}

	public int removeAt(int position) {
		int deletedValue;
		if (position < 0) {
			throw new RuntimeException("Below Lower Bound");
		}

		if (position > length) {
			throw new RuntimeException("Apove Lower Bound");
		}

		if (head.next == null) {
			head = null;
		}

		if (position == 0) {
			Node temp = head;
			head = head.next;
			deletedValue = temp.data;
			temp = null;
			length--;
			return deletedValue;
		}

		Node temp = head;
		int i = 0;
		while (temp != null && i < position - 1) {
			temp = temp.next;
			i++;
		}

		Node deleteNode = temp.next;
		temp.next = temp.next.next;
		deletedValue = deleteNode.data;
		deleteNode = null;
		length--;
		return deletedValue;
	}

	int getSize() {
		return length;
	}

}
