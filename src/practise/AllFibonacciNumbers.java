package practise;

public class AllFibonacciNumbers {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int i = 1; i < 40; i++) {
			System.out.println(fib(i));
		}
		System.out.println("Total Time taken:" + (System.currentTimeMillis() - startTime));
	}

	static int fib(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
}
