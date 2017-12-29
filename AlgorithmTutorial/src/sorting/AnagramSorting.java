package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Write a method to sort an array of strings so that all the anagrams are next to
//each other
public class AnagramSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("ali", "ahmed", "demah", "zeinab", "aseel", "gabe", "beinaz");
		sortStrings(list).forEach(string -> {
			System.out.println(string);
		});
	}

	public static List<String> sortStrings(List<String> strings) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> newList = new ArrayList<String>();
		strings.forEach(word -> {
			String key = getSortedWord(word);
			if (!map.containsKey(key)) {
				map.put(key, new LinkedList<String>());

			}
			List<String> listOfAnagrams = map.get(key);
			listOfAnagrams.add(word);
			map.put(key, listOfAnagrams);
		});

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			entry.getValue().forEach(string -> {
				newList.add(string);
			});
		}
		return newList;
	}

	private static String getSortedWord(String word) {
		char[] wordChars = word.toCharArray();

		Arrays.sort(wordChars);
		return new String(wordChars);
	}

}
