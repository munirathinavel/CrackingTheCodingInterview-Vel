package hacherrank;

class RotateArray_Practice2 {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int n = 7;
		int d = 5;

		rotateArray(a, n, d);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static void rotateArray(int[] a, int n, int d) {
		int i, j, temp, k;

		for (i = 0; i < gcd(n, d); i++) {

			temp = a[i];
			j = i;

			while (true) {
				k = j + d;
				if (k >= n) {
					k = k - n;
				}
				if (k == i) {
					break;
				}

				a[j] = a[k];
				j = k;
			}
			a[j] = temp;
		}
	}

	// 5 2
	// gcd(2, 1)
	// gcd(1,0)
	// return 1

	// 16 7
	// gcd(7, 2)
	// gcd(2, 1)
	// gcd(1, 0)
	// return 1

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}