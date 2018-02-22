package stacksAndQueues;

public class QueueViaStacksTest {
	public static void main(String[] args) {

		QueueViaStacks<Integer> queue = new QueueViaStacks<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);

		System.out.println(queue.peek());

		queue.add(5);
		queue.add(6);

		queue.remove();

		queue.add(7);
		queue.add(8);

		queue.remove();
	}

}
