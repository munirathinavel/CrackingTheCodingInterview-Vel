package multithreading.create_thread;

public class MyThread extends Thread {

	MyThread(String name) {
		super(name);
	}

	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Exception occured!");
		}
		System.out.println("This is Multi-Threading Programming!");
	}
}
