package stacksAndQueues;

import java.util.Stack;

public class QueueViaStacks<T> {

	Stack<T> front;
	Stack<T> rear;

	public QueueViaStacks() {
		front = new Stack<T>();
		rear = new Stack<T>();
	}

	public int size() {
		return front.size() + rear.size();
	}

	public void add(T value) {
		rear.push(value);
	}

	public T remove() {
		shiftElements();
		return front.pop();
	}

	public T peek() {
		shiftElements();
		return front.peek();
	}

	void shiftElements() {
		if (front == null || front.isEmpty()) {
			while (!rear.isEmpty()) {
				front.push(rear.pop());
			}
		}
	}

}
