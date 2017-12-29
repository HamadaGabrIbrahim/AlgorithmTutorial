package sorting;

import java.util.Arrays;

//You are given two sorted arrays, A and B, where A has a large enough buffer at
//the end to hold B. Write a method to merge B into A in sorted order
public class MergingAinToB {

	public static void main(String[] args) {

		int[] arrA = { 1, 2, 5, 8, 9, 10, 11, 12, 18 };
		int[] arrB = { 2, 5, 9, 10, 22, 55, 88, 96 };
		System.out.println(Arrays.toString(mergeArrayintoAnotherExtraSpace(arrA, arrB)));

		int[] a = new int[10];
		a[0] = 2;
		a[1] = 3;
		a[2] = 5;
		a[3] = 27;
		a[4] = 29;

		int[] b = { 4, 8, 45, 96, 100 };

		System.out.println(Arrays.toString(mergeArrayintoAnotherNoExtraSpace(a, b, 4, 4)));
	}

	public static int[] mergeArrayintoAnotherExtraSpace(int[] a, int[] b) {
		int[] newArray = new int[a.length + b.length];

		int aIndex = 0;
		int bIndex = 0;
		int newIndex = 0;

		while (aIndex < a.length || bIndex < b.length) {
			if (aIndex < a.length && bIndex < b.length) {
				if (a[aIndex] <= b[bIndex]) {
					newArray[newIndex++] = a[aIndex++];
				} else {
					newArray[newIndex++] = b[bIndex++];
				}
			} else if (aIndex < a.length) {
				newArray[newIndex++] = a[aIndex++];
			} else {
				newArray[newIndex++] = b[bIndex++];
			}

		}
		return newArray;
	}

	public static int[] mergeArrayintoAnotherNoExtraSpace(int[] a, int[] b, int aLastIndex, int bLastIndex) {

		int mergesLastIndex = aLastIndex + bLastIndex + 1;

		while (aLastIndex >= 0 || bLastIndex >= 0) {
			if (aLastIndex >= 0 && bLastIndex >= 0) {
				if (a[aLastIndex] >= b[bLastIndex]) {
					a[mergesLastIndex--] = a[aLastIndex--];
				} else {
					a[mergesLastIndex--] = b[bLastIndex--];
				}
			} else if (aLastIndex >= 0) {
				a[mergesLastIndex--] = a[aLastIndex--];
			} else {
				a[mergesLastIndex--] = b[bLastIndex--];
			}
		}
		return a;

	}

}
