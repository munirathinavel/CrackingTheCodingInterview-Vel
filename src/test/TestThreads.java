package test;

class MyThread extends Thread {
	MyThread() {
		System.out.print(" MyThread");
	}

	public void run() {
		System.out.print(" bar");
	}

	public void run(String s) {
		System.out.println(" baz");
	}
}

public class TestThreads {
	public static void main(String[] args) {
		Thread t = new MyThread() {
			public void run() {
				System.out.println(" foo");
				run("Cool");
			}
		};
		t.start();
	}
}