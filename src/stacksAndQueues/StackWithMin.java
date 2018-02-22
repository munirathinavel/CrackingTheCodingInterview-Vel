package stacksAndQueues;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {

	Stack<Integer> s2;

	public StackWithMin() {
		s2 = new Stack();
	}

	public void push(int value) {
		if (value <= min()) {
			s2.push(value);
		}

		super.push(value);
		System.out.println("Top=" + super.peek() + " & Min=" + s2.peek());
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		System.out.println("Pop=" + value + " & Min=" + s2.peek());
		return value;
	}

	int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}
