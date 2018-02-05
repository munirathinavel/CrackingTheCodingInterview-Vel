package target;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class HashTableVsHashMap {
	public static void main(String[] args) {

		Hashtable<Integer, Integer> table = new Hashtable<>();
		Map<Integer, Integer> map = new HashMap<>();

		int hash = new Integer(9).hashCode();
        int index = (hash & 0x7FFFFFFF) % 11;
        		
		for (int i = 0; i < 10; i++) {
			table.put(i, i * 4);
		}
		
		for (int i = 0; i < 20; i++) {
			map.put(i, i * 4);
		}

		for (Entry<Integer, Integer> entry : table.entrySet()) {
			System.out.println("key:" + entry.getKey() + ", value=" + entry.getValue());
		}
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("key:" + entry.getKey() + ", value=" + entry.getValue());
		}
	}

}
