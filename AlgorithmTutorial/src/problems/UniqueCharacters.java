package problems;

import java.util.HashSet;
import java.util.Set;

//Implement an algorithm to determine if a string has all unique characters. What if

//you cannot use additional data structures?

public class UniqueCharacters {
	public static void main(String[] args) {
		System.out.println(1 << 0);
		// System.out.println(isUniqueCharacters("hamada"));
		// System.out.println(isUniqueCharacters("abcdefhgioplzr"));
		// System.out.println(isUniqueByHash("hamada"));
		System.out.println(isUniqueByBit("abcdefhgioplzr"));
	}

	public static boolean isUniqueByBit(String s) {
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if ((checker & (1 << val)) > 0) {
				return false;
			} else {
				checker |= 1 << val;
			}
		}
		return true;
	}

	public static boolean isUniqueCharacters(String s) {
		int[] charcters = new int[26];
		int a = (int) 'a';
		for (int i = 0; i < s.length(); i++) {
			int c = (int) s.charAt(i) - a;
			if (charcters[c] > 0) {

				return false;
			} else {
				charcters[c]++;
			}
		}
		return true;
	}

	public static boolean isUniqueByHash(String s) {
		Set<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charSet.contains(c)) {
				return false;
			} else {
				charSet.add(c);
			}
		}
		return true;

	}
}
