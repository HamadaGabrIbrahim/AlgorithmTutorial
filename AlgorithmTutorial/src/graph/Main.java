package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
	//
	// Count BST nodes that lie in a given range
	// Given a Binary Search Tree (BST) and a range, count number of nodes that lie
	// in the given range.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('A' == 'a');
		System.out.println(isbangram("We promptly judged antique ivory buckles for the next prize "));
		System.out.println(isbangram("We promptly judged antique ivory buckles for the prize"));
	}

	public static boolean isbangram(String s) {
		if (s.length() < 26)
			return false;
		int[] arrOChars = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (c != ' ') {
				c = Character.toLowerCase(c) - 'a';
				arrOChars[c]++;
			}
		}
		for (int j = 0; j < arrOChars.length; j++) {
			if (arrOChars[j] == 0) {
				return false;
				}
		}
		return true;
	}

}
