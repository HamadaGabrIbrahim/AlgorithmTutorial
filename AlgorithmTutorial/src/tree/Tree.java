package tree;

public class Tree {
	private TreeNode root;

	public Tree(int data) {
		this.root = new TreeNode(data);
	}

	public void print() {
		print(this.root);

	}

	public void print(TreeNode root) {
		if (root == null)
			return;
		print(root.getLeft());
		System.out.println(root.getData());
		print(root.getRight());
	}

	public void insert(int data) {
		insert(this.getRoot(), data);
	}

	public void insert(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode(data);
		} else if (data <= root.getData()) {
			if (root.getLeft() == null) {
				root.setLeft(new TreeNode(data));
			} else {
				insert(root.getLeft(), data);
			}

		} else {
			if (root.getRight() == null) {
				root.setRight(new TreeNode(data));
			} else {
				insert(root.getRight(), data);
			}

		}
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

}
