package tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree(7);
		tree.insert(9);
		tree.insert(5);

		tree.insert(3);
		tree.insert(6);
		tree.insert(8);
		tree.print();
		System.out.println("Count: " + TreeOperations.getCount(tree, 5, 9));

	}

}
