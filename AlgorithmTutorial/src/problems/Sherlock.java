package problems;

public class Sherlock {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int[] arr2 = {1, 2, 3, 3};
		System.out.println(solve(arr));
		System.out.println(solve(arr2));
	}

	static String solve(int[] a) {

		int[] rightSums = new int[a.length];
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
			rightSums[i] = sum;
		}

		int leftSum = 0;
		for (int j = a.length - 1; j <= 0; j--) {
			int index = a.length - 1 - j;
			leftSum += a[j];
			System.out.println("leftIndex : "+j+ " rightIndex : "+index);
			if (rightSums[index] == leftSum) {
				return "YES";
			}
		}

		return "NO";
	}
}
