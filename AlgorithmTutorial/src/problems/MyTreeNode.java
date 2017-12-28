package problems;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyTreeNode {

	int data;
	MyTreeNode left;
	MyTreeNode right;

	public MyTreeNode(int data) {
		this.data = data;
	}

	void insert(int data) {
		if (data <= this.data) {
			if (this.left == null) {
				this.left = new MyTreeNode(data);
			} else {
				this.left.insert(data);
			}
		} else {
			if (this.right == null) {
				this.right = new MyTreeNode(data);
			} else {
				this.right.insert(data);
			}
		}
	}

	void print() {
		if (this.left != null)
			this.left.print();
		System.out.println(this.data);
		if (this.right != null)
			this.right.print();
	}

	boolean search(int value) {
		if (this.data == value)
			return true;
		if (value < this.data) {
			if (this.left == null)
				return false;
			else
				return this.left.search(value);
		}

		else {
			if (this.right == null)
				return false;
			else
				return this.right.search(value);
		}

	}

	int getHeight(MyTreeNode root) {
		if (root == null)
			return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	boolean isBalanced(MyTreeNode root) {
		if (root == null)
			return true;

		int difference = Math.abs(getHeight(root.left) - getHeight(root.right));
		if (difference > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	int checkHeight(MyTreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1)
			return -1;

		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1)
			return -1;

		int diff = Math.abs(leftHeight - rightHeight);
		if (diff > 1)
			return -1;
		return Math.max(checkHeight(root.left), checkHeight(root.right)) + 1;
	}

	boolean isBalancedImproved(MyTreeNode root) {
		int height = checkHeight(root);
		if (height == -1)
			return false;
		return true;
	}

	public static MyTreeNode CreateTreeFromSortedArray(int[] arr) {
		return CreateTreeFromSortedArray(arr, 0, arr.length - 1);
	}

	public static MyTreeNode CreateTreeFromSortedArray(int[] arr, int start, int end) {
		if (end < start)
			return null;
		int mid = (start + end) / 2;
		MyTreeNode tree = new MyTreeNode(arr[mid]);
		tree.left = CreateTreeFromSortedArray(arr, start, mid - 1);
		tree.right = CreateTreeFromSortedArray(arr, mid + 1, end);
		return tree;
	}

	ArrayList<LinkedList<MyTreeNode>> createLevelLinkedList(MyTreeNode tree) {

		ArrayList<LinkedList<MyTreeNode>> lists = new ArrayList<LinkedList<MyTreeNode>>();

		createLevelLinkedList(tree, lists, 0);

		return lists;

	}

	boolean isBST(MyTreeNode tree) {
		if (tree == null)
			return true;
		if (tree.left.data > tree.data || tree.right.data < tree.data)
			return false;
		return isBST(tree.left) && isBST(tree.right);

	}

	void createLevelLinkedList(MyTreeNode tree, ArrayList<LinkedList<MyTreeNode>> lists, int level) {

		if (tree == null)
			return;
		LinkedList<MyTreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<MyTreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(tree);
		createLevelLinkedList(tree.left, lists, level + 1);
		createLevelLinkedList(tree.right, lists, level);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTreeNode tree = new MyTreeNode(5);
		// tree.print();
		tree.insert(10);
		tree.insert(20);
		tree.insert(20);
		tree.insert(9);
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		tree.insert(50);
		// tree.insert(70);
		// tree.insert(90);
		// System.out.println(tree.search(0));
		// System.err.println(tree.getHeight(tree.left) - tree.getHeight(tree.right));
		System.out.println(tree.isBalanced(tree));
		System.out.println(tree.isBalancedImproved(tree));
		int[] arr = { 1, 2, 4, 7, 9, 10, 11, 12 };
		MyTreeNode anotherTree = CreateTreeFromSortedArray(arr);
		anotherTree.print();
		System.out.println();
		System.err.println("Height: " + tree.getHeight(anotherTree));
		System.out.println("is BST : "+tree.isBST(anotherTree));
	}

}
