package tree;

public class TreeOperations {
	// Count BST nodes that lie in a given range
	// Given a Binary Search Tree (BST) and a range, count number of nodes that lie
	// in the given range.
	public static int getCount(Tree tree, int min, int max) {
		if (tree.getRoot() == null)
			return 0;
		else
			return getCount(tree.getRoot(), min, max);
	}

	public static int getCount(TreeNode root, int min, int max) {
		if (root == null)
			return 0;
		if (root.getData() < min)
			return getCount(root.getLeft(), min, max);
		if (root.getData() > max)
			return getCount(root.getRight(), min, max);
		if (root.getData() == min)
			return getCount(root.getRight(), min, max) + 1;
		if (root.getData() == max)
			return getCount(root.getLeft(), min, max) + 1;
		return getCount(root.getLeft(), min, max) + getCount(root.getRight(), min, max) + 1;
	}
}
