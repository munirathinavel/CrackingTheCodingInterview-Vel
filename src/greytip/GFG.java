package greytip;

/*package whatever //do not write package name here */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

	static int itrNo = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			itrNo = 0;
			int size = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			for (int j = 0; j < size; j++) {
				list.add(sc.nextInt());
			}
			System.out.println(getLastElem(list));
		}
	}

	public static int getLastElem(LinkedList<Integer> list) {
		while (list.size() > 1) {
			int end = list.size() - 1;
			list.add(0, list.get(end));
			list.remove(end + 1);
			if (list.size() > 1) {
				if (end > itrNo)
					list.remove(end - itrNo);
				else
					list.removeFirst();
			}
			itrNo++;
			getLastElem(list);
		}

		return list.get(0);
	}

}