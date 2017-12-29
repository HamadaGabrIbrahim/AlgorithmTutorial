package sorting;

import java.util.Arrays;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 7, 8, 5, 0, 2, 5, 8, 3, 5, 9, 8, 7, 41, 23, 85, 96, 58, 55, 22, 35, 6, 9, 8, 5, 4, 1, 2, 3,
				8 };
		System.out.println(Arrays.toString(bucketSort(arr)));
	}

	public static int[] bucketSort(int[] array) {
		if (array.length == 0)
			return array;

		int maxValue = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxValue)
				maxValue = array[i];
		}
		int[] bucket = new int[maxValue + 1];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = 0;
		}

		for (int i = 0; i < array.length; i++) {
			bucket[array[i]]++;
		}

		int pos = 0;

		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				array[pos++] = i;
			}
		}
		return array;
	}

}
