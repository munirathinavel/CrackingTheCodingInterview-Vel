package test;

public class Test1 {
	public void foo() {
		assert false; /* Line 5 */
		assert true; /* Line 6 */
	}

	public void bar() {
		while (true) {
			assert false; /* Line 12 */
		}
		assert false; /* Line 14 */
	}
}