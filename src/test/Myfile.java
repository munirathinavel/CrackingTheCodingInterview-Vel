package test;

import java.io.*;

public class Myfile {
	public static void main(String[] args) {
		/*String biz = args[1];
		String baz = args[2];
		String rip = args[3];
		System.out.println("Arg is " + rip);*/

		int x = 0;
		assert (x > 0) : "assertion failed"; /* Line 6 */
		System.out.println("finished");

		int i = 4, j = 2;
		leftshift(i, j);
		System.out.println(i);
		
		System.out.println((8 >> 2) << 4);
		System.out.println(128 >>> 2);
	}

	public static void leftshift(int i, int j) {
		i <<= j;
	}
}