package stacksAndQueues;

public class MyQueue<T> {
	private MyStack<T> input;
	private MyStack<T> output;
	private int size;

	public MyQueue() {
		input = new MyStack<>();
		output = new MyStack<>();
	}

	public void enqueue(T value) {
		input.push(value);
		size++;
	}

	public T dequeue() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		size--;
		return output.pop();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

}
