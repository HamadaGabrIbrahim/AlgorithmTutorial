package problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//1.3 Given two strings, write a method to decide if one is a permutation of the other.
//pg73
public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPermutation per = new StringPermutation();
		System.out.println(per.isPermutation("ABC", "CAB"));
		System.out.println(per.isPermutation("ABCDEF", "CDABEF"));
		System.out.println(per.isPermutation("ABCDEF", "CDABEFG"));
		System.out.println(per.isPermutation("ABCDEF", "CDZBEF"));
	}

	public boolean isPermutation(String a, String b) {

		Map<Integer, Integer> characters = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length(); i++) {
			int c = a.charAt(i);
			if (characters.containsKey(c)) {
				int value = characters.get(c);
				value++;
				characters.put(c, value);
			} else {
				characters.put(c, 1);
			}
		}

		for (int j = 0; j < b.length(); j++) {
			int c = b.charAt(j);
			if (characters.containsKey(c)) {
				int value = characters.get(c);
				value--;
				characters.put(c, value);
			} else {
				return false;
			}
		}
		Iterator it = characters.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if ((Integer) pair.getValue() != 0) {
				return false;
			}
			// System.out.println(pair.getKey() + " = " + pair.getValue());
			// it.remove(); // avoids a ConcurrentModificationException
		}

		return true;
	}

}
