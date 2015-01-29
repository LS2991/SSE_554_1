
public class BSTNode {
	
	int value;
	BSTNode left, right;
	
	public BSTNode(int parentVal) {
		value = parentVal;
	}
	public void insert(int childVal) {
		if(childVal == value) {
			throw new RuntimeException("Value alread exists");
		}
		if(childVal < value) {
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
	
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public int value() {
		return value;
	}

}
