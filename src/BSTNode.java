import java.util.ArrayList;


public class BSTNode {
	
	protected int root, size = 0;
	protected BSTNode left, right;
	
	public BSTNode(int parentVal) {
		root = parentVal;
		size++;
	}
	public void insert(int childVal) {
		if(childVal == root) {
			throw new RuntimeException("Value already exists");
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
		else if(key < root && left != null) {
			return left.search(key);
		}
		else if(key > root && right != null){
			return right.search(key);
		}
		else {
			return null;
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
	
	public BSTNode findMax() {
		if(right == null) {
			return this;
		}
		else {
			return right.findMax();
		}
	}
	
	public BSTNode findMin() {
		if(left == null) {
			return this;
		}
		else {
			return left.findMin();
		}
	}
	
	public void delete(int value, BSTNode parent) {
		//BSTNode toDelete = parent.search(value);
		//BSTNode toReplace;
		
		//Algorithm for deleting a node with no children
		if(value != parent.value()) {
			if(value < parent.value()) {
				if(value < parent.getLeft().value()) { //checks left child for equivalence and compares
					delete(value, parent.getLeft().getLeft()); //since left child is checked delete() is called for the second left child
				}
				else if(value > parent.getLeft().value()) {
					delete(value, parent.getLeft().getRight());
				}
				else {
					parent.left = null;
				}
			}
			else if(value > parent.value()) {
				if(value < parent.getRight().value()) {
					delete(value, parent.getRight().getLeft());
				}
				else if(value > parent.getRight().value()) {
					delete(value, parent.getRight().getRight());
				}
				else {
					parent.right = null;
				}
			}
		}
		else if(value == parent.value()) {
			parent = null;
		}
		
	}
	
	public int getNumChildren() {
		if(left == null && right == null) {
			return 0;
		}
		else if(left == null && right != null) {
			return 1;
		}
		else if(left != null && right == null) {
			return 1;
		}
		else {
			return 2;
		}
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
	
//	public void setLeft(int value) {
//		this.getLeft().root = value;
//	}
//	
//	public void setRight(int value) {
//		this.getRight().root = value;
//	}
	

}
