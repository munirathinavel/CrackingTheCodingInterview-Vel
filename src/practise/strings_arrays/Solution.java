package practise.strings_arrays;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(Character c: s.toCharArray()) {
        	stack.push(c);
        }
        // Complete this function
        
        return "NO";
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String s = in.next();
			String result = isBalanced(s);
			System.out.println(result);
		}
		in.close();
	}

}
