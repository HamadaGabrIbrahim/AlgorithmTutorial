package problems;

import java.util.HashMap;

public class Largest2Square {

	public static void main(String[] args) {
		String[] pre = { "67", "85" };
		// System.out.println(isAllowed("67248437110601485", pre));

		TrieNode root = createTree();
		insertWord(root, "abcd");
		insertWord(root, "abcg");
		insertWord(root, "abckk");
		insertWord(root, "abf");

		System.out.println("is Allowed :" + dfsBoolean(root, 0, "abcgefty", 0));
		System.out.println("is Allowed :" + dfsBoolean(root, 0, "abcrolll", 0));
		System.out.println("is Allowed :" + dfsBoolean(root, 0, "xcilll", 0));

	}

	static boolean isAllowed(String card, String[] bannedPrefixes) {
		TrieNode root = createTree();

		for (int i = 0; i < bannedPrefixes.length; i++) {
			insertWord(root, bannedPrefixes[i]);
		}

		return dfsBoolean(root, 0, card, 0);
	}

	static TrieNode createTree() {
		return (new TrieNode('\0'));
	}

	static void insertWord(TrieNode root, String word) {
		int l = word.length();
		char[] letters = word.toCharArray();
		TrieNode curNode = root;
		for (int i = 0; i < l; i++) {
			if (!curNode.children.containsKey(letters[i]))
				curNode.children.put(letters[i], new TrieNode(letters[i]));
			curNode = curNode.children.get(letters[i]);
		}
		curNode.fullWord = true;
	}

	static boolean dfsBoolean(TrieNode node, int depth, String card, int cardDigitIndex) {
		if (node.children.size() == 0 && ("" + node.letter).equals("" + card.charAt(cardDigitIndex))) {
			return false;
		}
		if (("" + node.letter).equals("" + card.charAt(cardDigitIndex)) && card.length() - 1 == cardDigitIndex) {
			return false;
		}

		for (TrieNode tn : node.children.values()) {
			if (("" + tn.letter).equals("" + card.charAt(cardDigitIndex))) {
				return dfsBoolean(tn, depth + 1, card, cardDigitIndex + 1);
			}
		}
		return true;

	}

	static class TrieNode {
		char letter;
		HashMap<Character, TrieNode> children;
		boolean fullWord;

		TrieNode(char letter) {
			this.letter = letter;
			children = new HashMap<Character, TrieNode>();
			this.fullWord = false;
		}
	}

}
