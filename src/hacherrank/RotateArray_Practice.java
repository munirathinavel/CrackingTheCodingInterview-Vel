package hacherrank;

class RotateArray_Practice {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int n = 7;
		int k = 5;

		rotateArray(a, n, k);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void rotateArray(int[] a, int n, int d) {
		int i, j, k = 0, temp;
		for (i = 0; i < gcd(n, d); i++) {
			j = i;
			temp = a[i];
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

	// Greatest Common Deviser
	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {

			return gcd(b, a % b);
		}
	}
}