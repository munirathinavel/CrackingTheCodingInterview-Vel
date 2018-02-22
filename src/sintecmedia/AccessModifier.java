package sintecmedia;

/*class A {
	protected void m1() {
		System.out.println("A:m1()");
	}

	void m2() {

	}

	protected void m3() {
		System.out.println("A:m1()");
	}

}

class B extends A {

	void m1() {
		System.out.println("B:m1()");
	}

	private void m2() {

	}

	protected void m1() {
		System.out.println("A:m1()");
	}
}
*/
class C {

	int m2() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

}

public class AccessModifier {

	public static void main(String[] args) {
		/*B b = (B) new A();
		b.m1();
		 */

		System.out.println(new C().m2());
		/*
		 * String a = "one"; String b = "two";
		 * 
		 * String s1 = "hello" + "good" + new String("cool").toString();
		 * 
		 * System.out.println(s1);
		 */
	}

}
