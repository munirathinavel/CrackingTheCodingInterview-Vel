package practise;

public class NthFibonacciNumber {

	public static void main(String[] args) {
		System.out.println(fib(-1));
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
		System.out.println(fib(7));
	}

	static int fib(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}
}
