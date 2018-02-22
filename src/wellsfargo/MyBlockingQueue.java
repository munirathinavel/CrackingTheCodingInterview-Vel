package wellsfargo;

import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue {
	List<Object> queue = new LinkedList<>();
	int capacity;

	MyBlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	public synchronized void put(Object item) throws InterruptedException {
		while (this.capacity == this.queue.size()) {
			System.out.println("Queue is full! " + Thread.currentThread().getName() + " is waiting");
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object take() throws InterruptedException {
		while (this.queue.size() == 0) {
			System.out.println("Queue is empty! " + Thread.currentThread().getName() + " is waiting");
			wait();
		}
		if (this.queue.size() == capacity) {
			notifyAll();
		}
		return this.queue.remove(0);

	}

	public static void main(String[] args) {
		MyBlockingQueue blockingQueue = new MyBlockingQueue(10);
		for (int i = 0; i < 20; i++) {
			final int val = i;
			new Thread() {
				public void run() {
					try {
						System.out.println("put:" + val);
						blockingQueue.put(val);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();

			new Thread() {
				public void run() {
					try {
						System.out.println("get:" + blockingQueue.take());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}

	}
}
