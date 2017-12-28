package problems;

public class ThreeStacks {

	int size;
	int[] elements = new int[size * 3];

	int[] tops = { -1, -1, -1 };

	public ThreeStacks(int size) {
		this.size = size;
	}

	public void push(int stackNo, int value) {

		if (tops[stackNo]+1 >= size) {
			throw new IndexOutOfBoundsException("There is no space in " + stackNo);
		}
		tops[stackNo]++;
		elements[absSize(stackNo)] = value;

	}

	public int pull(int stackNo) throws Exception {
		if (tops[stackNo] == -1) {
			throw new Exception("Stack " + stackNo + " is empty");
		}
		int element = elements[absSize(stackNo)];
		elements[absSize(stackNo)] = 0;
		tops[stackNo]--;
		return element;
	}

	public int peek(int stackNo) throws Exception {
		if (tops[stackNo] == -1)
			throw new Exception("Stack is empty");
		return elements[absSize(stackNo)];
	}

	public int absSize(int stackNo) {
		return stackNo * size + tops[stackNo];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
