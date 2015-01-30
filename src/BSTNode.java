import java.util.ArrayList;


public class BSTNode {
	
	int root, size = 0;
	BSTNode left, right;
	
	public BSTNode(int parentVal) {
		root = parentVal;
		size++;
	}
	public void insert(int childVal) {
		if(childVal == root) {
			throw new RuntimeException("Value alread exists");
		}
		if(childVal < root) {
			if(left == null) {
				left = new BSTNode(childVal);
			}
			else {
				left.insert(childVal);
			}
		}
		else {
			if(right == null) {
				right = new BSTNode(childVal);
			}
			else {
				right.insert(childVal);
			}
		}
		
		size++;
	}
	
	public BSTNode search(int key) {
		if(key == root) {
			return this;
		}
		else if(key < root) {
			left.search(key);
			return left.search(key);
		}
		else {
			right.search(key);
			return right.search(key);
		}
	}
	public ArrayList<Integer> getInOrderArrayList(BSTNode tree) {
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		inOrderTraversal(tree, inOrder);
		return inOrder;
	}
	
	private void inOrderTraversal(BSTNode node, ArrayList<Integer> inOrder) {
				
		if(node == null)
			return;
		
		inOrderTraversal(node.getLeft(), inOrder);
		inOrder.add(node.value());
		inOrderTraversal(node.getRight(), inOrder);
	}
	
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public int getSize() {
		return size;
	}
	
	public int value() {
		return root;
	}
	

}
