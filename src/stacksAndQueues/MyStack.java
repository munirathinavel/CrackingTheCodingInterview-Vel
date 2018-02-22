package stacksAndQueues;

public class MyStack<T> {

	private class Node<T> {
		Node next;
		T data;

		Node(T data) {
			this.data = data;
		}
	}

	Node<T> top;
	int size;

	public void push(T e) {
		Node newNode = new Node(e);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		size++;
	}

	public T pop() {
		if (top == null) {
			return null;
		} else {
			T value = top.data;
			top = top.next;
			size--;
			return value;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void print() {
		if (size == 0) {
			System.out.println("Stack is Empty!");
		}
		for (Node<T> temp = top; temp != null; temp = temp.next) {
			System.out.print(temp.data + " ");
		}
	}
}
