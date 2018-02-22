package stacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
	int data;
	int height;
	Node next;

	public Node(int data, int height) {
		this.data = data;
		this.height = height;
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Stack<Node> s3 = new Stack<Node>();
		int value = 0;
		int h1 = 0;
		int h2 = 0;
		int h3 = 0;
        int a1[] =new  int[n1];
        int a2[] = new  int[n2];
        int a3[] = new int[n3];
        for (int h1_i = 0; h1_i < n1; h1_i++) {
			a1[h1_i]= in.nextInt();
		}
        for (int h1_i = 0; h1_i < n2; h1_i++) {
			a2[h1_i]= in.nextInt();
		}
        for (int h1_i = 0; h1_i < n3; h1_i++) {
			a3[h1_i]= in.nextInt();
		}
        
		for (int h1_i = n1-1; h1_i >= 0; h1_i--) {
			value = a1[h1_i];
			h1 += value;
			s1.push(new Node(value, h1));
		}
		for (int h2_i = n2-1; h2_i >= 0; h2_i--) {
			value = a2[h2_i];
			h2 += value;
			s2.push(new Node(value, h2));
		}
		for (int h3_i = n3-1; h3_i >=0; h3_i--) {
			value = a3[h3_i];
			h3 += value;
			s3.push(new Node(value, h3));
		}
		in.close();
		
		if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
			System.out.println(0);
		}
		
		while(!((h1==h2)&&(h2==h3)&&(h1==h3))){
			if(h1>=h2 && h1>=h3){
				h1 -=s1.remove();
			}else if(h2 >=h1 && h2>=h3){
				h2 -=stack2.remove();
			}else{
				h3 -=stack3.remove();
			}
		}
		
		/*while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
			h1 = s1.pop().height;
			h2 = s2.pop().height;
			h3 = s3.pop().height;

			if (h1 == h2 && h2 == h3 && h3 == h1) {
				System.out.println(h1);
                break;
			} else if (h1 > h2 && h1 > h3) {
				s1.pop();
			} else if (h2 > h1 && h2 > h3) {
				s2.pop();
			} else if (h3 > h1 && h3 > h1) {
				s3.pop();
			}
		}*/

	}
}
