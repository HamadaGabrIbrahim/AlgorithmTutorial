package problems;

//A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
//3 steps at a time. Implement a method to count how many possible ways the child
//can run up the stairs.
public class NStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWays(1));
		System.out.println(countWays(2));
		System.out.println(countWays(3));
		System.out.println(countWays(4));

		System.out.println(countWaysDP(1));
		System.out.println(countWaysDP(2));
		System.out.println(countWaysDP(3));
		System.out.println(countWaysDP(4));
	}

	static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}

	static int countWaysDP(int n) {
		int[] map = new int[n];
		map[0] = 1;
		return countWaysDPImplementation(n, map);
	}

	static int countWaysDPImplementation(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > -1) {
			return map[n];
		} else {
			map[n] = countWaysDPImplementation(n - 1, map) + countWaysDPImplementation(n - 2, map)
					+ countWaysDPImplementation(n - 3, map);
			return map[n];
		}
	}

}
