
public class BSTNode {
	
	int root;
	BSTNode left, right;
	
	public BSTNode(int parentVal) {
		root = parentVal;
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
	
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public int value() {
		return root;
	}

}
