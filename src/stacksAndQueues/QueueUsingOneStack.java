package stacksAndQueues;

import java.util.Stack;

public class QueueUsingOneStack<T> {

	Stack<T> stack;

	public QueueUsingOneStack() {
		stack = new Stack();
	}

	public void enQueue(T value) {
		stack.push(value);
	}

	public T deQueue() {
		return deQueue(stack);
	}

	public T deQueue(Stack<T> stack) {
		T x, result;
		if (stack == null || stack.isEmpty()) {
			throw new RuntimeException("Stack Overflow!");
		} else if (stack.size() == 1) {
			return (T) stack.pop();
		} else {
			x = (T) stack.pop();
			result = deQueue(stack);
			stack.push(x);
			return result;
		}
	}

	public static void main(String[] args) {
		QueueUsingOneStack<Integer> queue = new QueueUsingOneStack<>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		queue.enQueue(8);

		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
	}

}
