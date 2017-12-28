package problems;

public class MyStack {
	int size;
	int[] elements;
	int topIndex;

	public MyStack(int mySize) {
		this.size = 0;
		this.elements = new int[mySize];
		this.topIndex = -1;
	}

	public void push(int value) {
		if (topIndex + 1 >= elements.length) {
			throw new IndexOutOfBoundsException("No extra space in the stack");
		}
		elements[++topIndex] = value;
	}

	public int pop() throws Exception {
		if (topIndex == -1)
			throw new Exception("Empty stack");
		int top = elements[topIndex];
		elements[topIndex--] = -1;

		return top;

	}

	public int peek() {
		return elements[topIndex];
	}
	

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i] + ", ");
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MyStack stack = new MyStack(5);
		stack.print();
		stack.push(5);
		stack.print();
		System.out.println(stack.pop());
		stack.print();
		System.out.println();
		stack.push(10);
		stack.print();
		//System.out.println("size " + stack.size);
		System.out.println(stack.peek());
		System.out.println("top is : "+stack.topIndex);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		stack.print();

	}

}
