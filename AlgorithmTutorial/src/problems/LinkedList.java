package problems;

public class LinkedList {
	Node head = null;
	Node foot = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findKthToLast(Node head, int k) {
		if (head == null) {
			return 0;
		}
		int i = findKthToLast(head.getNext(), k) + 1;
		if (i == k) {
			System.out.println(i);
		}
		return i;
	}

}
