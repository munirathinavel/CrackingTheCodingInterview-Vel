package wellsfargo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

class ThreadPool {
	List<Thread> threads;
	MyBlockingQueue blockingQueue;
	int size;

	ThreadPool(int maxThreads, int maxQueueSize) {
		this.size = maxThreads;
		blockingQueue = new MyBlockingQueue(maxQueueSize);
		threads = new ArrayList<>(maxThreads);

		for (int i = 0; i < size; i++) {
			threads.add(new PoolThread(blockingQueue));
		}
		for (Thread t : threads) {
			t.start();
		}
	}

	public void execute(Thread task) throws InterruptedException {
		blockingQueue.put(task);
		
	}
	
	public void sendMsg(){
		System.out.println("Cool");
	}

}

class PoolThread extends Thread {
	MyBlockingQueue blockingQueue;
	boolean isStopped = false;

	PoolThread(MyBlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		while (!isStopped) {
			System.out.println("Running Task");
			try {
				Runnable task = (Runnable) blockingQueue.take();
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void doStop() {
		isStopped = true;
		this.interrupt();

	}

	public synchronized boolean isStopped() {
		return isStopped;
	}

}

public class _3_ThreadPoolImplementation {

	public static void main(String[] args) throws InterruptedException {

		ThreadPool threadPool = new ThreadPool(3, 40);

		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread t");
			}
		};
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Runnable 1");
			}
		};
		for (int i = 0; i < 100; i++) {
			Thread task = new Thread(r);
			threadPool.execute(task);

		}

	}
}
