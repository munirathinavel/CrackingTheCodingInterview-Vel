package practise;

public class AllFibonacciMemoization {
	public static void main(String[] args) {
		fib(40);
	}

	private static void fib(int n) {
		int memo[] = new int[n + 1];
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			System.out.println(fib(i, memo));
		}
		System.out.println("Total Time taken:" + (System.currentTimeMillis() - startTime));
	}

	static int fib(int n, int[] values) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (values[n] > 0)
			return values[n];
		values[n] = fib(n - 1, values) + fib(n - 2, values);
		return values[n];
	}

}
