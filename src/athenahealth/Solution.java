package athenahealth;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		sc.close();

		Set<String> combinations = new HashSet<String>();
		int n = s.length();
		int open = 0;
		int close = 0;
		for (int i = 0; i < n; i++) {
			if ('(' == s.charAt(i)) {
				open++;
			} else if (')' == s.charAt(i)) {
				close++;
			}
		}

		StringBuffer sb = new StringBuffer();
		int deleteOpen = 0;
		int deleteClose = 0;
		int openAdded = 0;
		int closeAdded = 0;
		int left = 0;
		if (open > close) {
			for (int i = 0; i < n - 1; i++) {
				sb = new StringBuffer();
				deleteOpen = 0;
				left = 0;
				openAdded = 0;
				closeAdded = 0;
				for (int j = 0; j < n ; j++) {
					if (s.charAt(j) == '(' && left >= i) {
						if (deleteOpen == (open - close)) {
							sb.append(s.charAt(j));
							openAdded++;
						} else {
							deleteOpen++;
						}
					} else {
						if ('(' == s.charAt(j)) {
							openAdded++;
						} else if (')' == s.charAt(j)) {
							closeAdded++;
						}
						sb.append(s.charAt(j));
					}
					left++;
				}
				if (openAdded == closeAdded && deleteOpen == (open - close)) {
					String str = sb.toString();
					if (checkBalancedParentheses(str)) {
						combinations.add(str);
					}

				}
			}
		} else if (close > open) {

			for (int i = 0; i < n - 1; i++) {
				sb = new StringBuffer();
				deleteClose = 0;
				left = 0;
				openAdded = 0;
				closeAdded = 0;
				for (int j = n - 1; j >= 0; j--) {

					if (s.charAt(j) == ')' && left >= i) {
						if (deleteClose == (close - open)) {
							closeAdded++;
							sb.append(s.charAt(j));
						} else {
							deleteClose++;
						}
					} else {
						if ('(' == s.charAt(j)) {
							openAdded++;
						} else if (')' == s.charAt(j)) {
							closeAdded++;
						}
						sb.append(s.charAt(j));
					}
					left++;
				}
				if (openAdded == closeAdded && deleteClose == (close - open)) {
					String str = sb.reverse().toString();
					if (checkBalancedParentheses(str)) {
						combinations.add(str);
					}
				}
			}
		}

		for (String combination : combinations) {
			System.out.println(combination);
		}
	}

	private static boolean checkBalancedParentheses(String input) {
		Stack<String> stack = new Stack<String>();
		boolean isBalanaced = false;

		for (int i = 0; i < input.length(); i++) {
			String str = "" + input.charAt(i); // store characters as String

			// if opening bracket then push into stack
			if (str.equals("(")) {
				stack.push(str);
			}

			// if closing bracket, pop bracket and compare if its a pair
			if (str.equals(")")) {
				// if stack becomes empty in between then also its not balanced
				if (stack.isEmpty()) {
					return false;
				}
				String opening = stack.peek();
				if (str.equals(")") && opening.equals("(")) {
					stack.pop();
				}
			}
		}
		// if stack is empty at end, then its balanced
		if (input.length() > 0 && stack.isEmpty()) {
			isBalanaced = true;
		}

		return isBalanaced;
	}
}