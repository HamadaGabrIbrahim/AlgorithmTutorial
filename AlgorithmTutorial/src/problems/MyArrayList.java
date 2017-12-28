package problems;

public class MyArrayList {

	int size;
	int[] myArray;

	public MyArrayList(int size) {
		this.size = 0;

		myArray = new int[size];
	}

	public void insert(int index, int number) {
		if (index < size && index >= 0) {
			myArray[index] = number;
		}
	}

	public void add(int number) {
		if (size < myArray.length) {
			myArray[size] = number;
			size++;
		}
	}

	public boolean search(int number) {
		for (int i = 0; i < size; i++) {
			if (myArray[i] == number)
				return true;
		}
		return false;
	}

	public void remove(int index) {
		if (index == 0)
			removeFirst();
		if (index == size - 1)
			removeLast();
		for (int i = index; i <size-1; i++) {
			myArray[i] = myArray[i+1];
		}
		myArray[size-1] = -1;
		size--;

	}

	public void removeLast() {
		myArray[size-1] = -1;
		size--;
	}

	public void removeFirst() {
		for (int i = 0; i < size - 1; i++) {
			myArray[i] = myArray[i + 1];
		}
		size--;
	}

	public void sort() {
		for (int i = 0; i < size - 1; i++) {
			int min = myArray[i];
			int minIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (myArray[j] < min) {
					min = myArray[j];
					minIndex = j;
				}

			}
			swap(i, minIndex);

		}
	}

	public void swap(int i, int j) {
		int temp = myArray[i];
		myArray[i] = myArray[j];
		myArray[j] = temp;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(myArray[i] + ", ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyArrayList list = new MyArrayList(5);
		list.add(1);
		list.add(8);
		list.add(5);
		list.add(8);
		list.add(10);
		list.add(50);
		list.print();
		System.out.println();
		list.removeLast();
		list.sort();
		list.print();
		list.remove(1);
		System.out.println();
		list.print();
		list.add(9);
		list.add(20);
		System.out.println();
		list.print();
		list.insert(2, 99);
		System.out.println();
		list.print();
		
	}

}
