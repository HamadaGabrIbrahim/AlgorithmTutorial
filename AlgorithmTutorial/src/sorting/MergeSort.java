package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 45, 55, 85, 4, 5, 96, 85, 55, 8, 0, 2, 0, 55, 44, 89, 65, 33, 6, 222, 6332, 8 };
		System.out.println(Arrays.toString(mergeSort(arr)));
	}

	public static int[] mergeSort(int[] arr) {
		int[] helper = new int[arr.length];
		return mergeSort(arr, helper, 0, arr.length - 1);
	}

	public static int[] mergeSort(int[] arr, int[] helper, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, helper, low, mid);
			mergeSort(arr, helper, mid + 1, high);
			merge(arr, helper, low, mid, high);
		}
		return arr;
	}

	public static void merge(int[] arr, int[] helper, int low, int mid, int high) {

		for (int i = low; i <= high; i++) {
			helper[i] = arr[i];
		}

		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;

		while (helperLeft <= mid && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				arr[current] = helper[helperLeft];
				helperLeft++;
			} else {
				arr[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		int remainder = mid - helperLeft;
		for (int i = 0; i < remainder; i++) {
			arr[current + i] = helper[helperLeft + i];
		}

	}

}
