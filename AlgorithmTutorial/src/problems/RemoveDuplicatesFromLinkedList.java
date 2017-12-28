package problems;
//Write code to remove duplicates from an unsorted linked list.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//FOLLOW UP
//How would you solve this problem if a temporary buffer is not allowed?

public class RemoveDuplicatesFromLinkedList<T> {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("hamada");
		list.add("ahmed");
		list.add("hamada");
		list.add("ali");
		RemoveDuplicatesFromLinkedList<String> removeDuplicates = new RemoveDuplicatesFromLinkedList<String>();
		LinkedList<String> listWithoutDuplicates = removeDuplicates.removeDuplicatesFromLinkedList(list);
		listWithoutDuplicates.forEach(s -> System.out.println(s));
	}

	public LinkedList<T> removeDuplicatesFromLinkedList(LinkedList<T> list) {
		Set<T> tSet = new HashSet<T>();
		for (T element : list) {
			if (tSet.contains(element)) {
				list.remove();
			} else {
				tSet.add(element);
			}
		}
		return list;

	}
	
}
