package problems;

import java.util.ArrayList;
import java.util.List;

//Google: Given a non-negative number represented as an array of digits,
//
//add 1 to the number ( increment the number represented by the digits ).
//
//The digits are stored such that the most significant digit is at the head of the list.
//
//Example:
//
//If the vector has [1, 2, 3]
//
//the returned vector should be [1, 2, 4]
//
//as 123 + 1 = 124.
public class IncreaseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(6);
		list.add(0);
		list.add(6);
		list.add(4);
		list.add(8);
		list.add(8);
		list.add(1);
		addOneToNumber(list).forEach(number -> {
			System.out.println(number);
		});
	}

	public static List<Integer> addOneToNumber(List<Integer> initialNumbers) {

		int i = 0;
		while (i < initialNumbers.size() - 1 && initialNumbers.get(i) == 0) {
			initialNumbers.remove(i);
		}

		int remainder = 1;

		for (int index = initialNumbers.size() - 1; index >= 0; index--) {
			int sum = initialNumbers.get(index) + remainder;
			initialNumbers.set(index, sum % 10);
			remainder = sum / 10;
			if (remainder == 0)
				break;
		}
		if (remainder == 1)
			initialNumbers.add(0, 1);
		return initialNumbers;
	}

}
