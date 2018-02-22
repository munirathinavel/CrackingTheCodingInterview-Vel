package stacksAndQueues;

public class StackWithMinExample {

	public static void main(String[] args) {

		StackWithMin stack = new StackWithMin();

		stack.push(8);
		stack.push(6);
		stack.push(14);
		stack.push(2);
		stack.push(7);
		stack.push(1);
		stack.pop();
		stack.pop();
		stack.push(1);
		stack.pop();
		stack.pop();
		stack.pop();
		
	}
}
