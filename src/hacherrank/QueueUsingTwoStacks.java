package hacherrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyQueue {
	Stack<Integer> front;
	Stack<Integer> rear;

	MyQueue() {
		front = new Stack<Integer>();
		rear = new Stack<Integer>();
	}

	void enQueue(int data) {
		rear.push(data);
	}

	int deQueue() {
		if (front == null || front.empty()) {
			while (!rear.isEmpty()) {
				front.push(rear.pop());
			}
		}
		return front.pop();
	}

	int peek() {
		if (front == null || front.empty()) {
			while (!rear.isEmpty()) {
				front.push(rear.pop());
			}
		}
		return front.peek();
	}
}

public class QueueUsingTwoStacks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyQueue queue = new MyQueue();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int choice = sc.nextInt();
			if (choice == 1) {
				queue.enQueue(sc.nextInt());
			} else if (choice == 2) {
				queue.deQueue();
			} else if (choice == 3) {
				System.out.println(queue.peek());
			}
		}
	}
}