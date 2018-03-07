package test;

class Boo {
	Boo(String s) {
	}

	Boo() {
	}
}

class Bar extends Boo {
	Bar() {
	}

	Bar(String s) {
		super(s);
	}

	void zoo() {
		// insert code here
	}
}

public class C {
	public static void main(String[] args) {
		// Boo f = new Boo(24) { };
		Boo f1 = new Bar() {
		};
		// Bar f2 = new Boo(String s) { };
		// Boo f3 = new Boo.Bar(String s) { };
		int s = 12;
	}
}
