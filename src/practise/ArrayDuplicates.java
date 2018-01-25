package practise;

public class ArrayDuplicates {

	public static void main(String[] args) {
		int a[] = { 2, 4, 5, 6, 3, 7, 4 };

		//System.out.println("Result:" + findDuplicate(a));
		
		hasDuplicates(a);
	}

	private static boolean findDuplicate(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (Math.abs(a[i]) < 0) {
				return true;
			} else {
				a[Math.abs(a[i])] = a[Math.abs(a[i])] * -1;
			}
		}

		return false;
	}
	
	private static void hasDuplicates(int[] arrA) {

        for (int i = 0; i < arrA.length; i++) {
            //check if element is negative, if yes the we have found the duplicate
            if (arrA[Math.abs(arrA[i])] < 0) {
                System.out.println("Array has duplicates : " + Math.abs(arrA[i]));
            } else {
                arrA[Math.abs(arrA[i])] = arrA[Math.abs(arrA[i])] * -1;
            }
        }
    }

}
