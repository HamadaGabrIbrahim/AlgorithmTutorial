/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hibrahim
 */
public class AllPermutationOfString {
	public static void main(String[] args) {

		getAllPermutationsOfString("").forEach(word -> {
			System.out.println(word);
		});

		System.out.println();

		getAllPermutationsOfString("a").forEach(word -> {
			System.out.println(word);
		});

		System.out.println();

		getAllPermutationsOfString("ab").forEach(word -> {
			System.out.println(word);
		});

		System.out.println();

		getAllPermutationsOfString("abd").forEach(word -> {
			System.out.println(word);
		});

		System.out.println();

		getAllPermutationsOfString("hamada").forEach(word -> {
			System.out.println(word);
		});

	}

	public static List<String> getAllPermutationsOfString(String str) {
		return getAllPermutationsOfString(str, 0);
	}

	public static List<String> getAllPermutationsOfString(String str, int index) {
		List<String> allPermutations = new ArrayList<>();

		if (index == str.length()) {
			allPermutations.add("");
		} else {

			char first = str.charAt(index);

			List<String> words = getAllPermutationsOfString(str, index + 1);

			words.forEach(word -> {
				for (int j = 0; j <= word.length(); j++) {
					String newWord = insertCharAt(word, first, j);
					allPermutations.add(newWord);
				}
			});

		}

		return allPermutations;
	}

	public static String insertCharAt(String word, char character, int index) {

		String before = word.substring(0, index);
		String after = word.substring(index);
		return before + character + after;

	}
}
