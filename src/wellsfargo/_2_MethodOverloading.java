package wellsfargo;

import java.io.IOException;

class A {
	int a=10;
	A() throws IOException{
	//	int a=56/0;
	}
	 void m1() {

	}

}

class B extends A {
	int b=20;
	B() throws Exception{
		//int b = 34/0;
	}
	public void m1() {

	}

	public void m2() {

	}
}

public class _2_MethodOverloading {

	public static void main(String[] args) throws Exception {
		A a = new B();
		a.m1();
		B b = (B)a;
		b.m2();
		A c = a;
		a=null;
	}
}
