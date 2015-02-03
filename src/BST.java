import java.util.ArrayList;


public class BST {
	
	
	protected int size = 0;
	protected BSTNode root;
	boolean found = false;
	
	public BST(int parentVal) {
		root = new BSTNode(parentVal);
		size++;
	}
	
	public void insert(int childVal, BSTNode root) {
		if(childVal == root.value) {
			throw new RuntimeException("Value already exists");
		}
		else if(childVal < root.value) {
			if(root.left == null) {
				root.left = new BSTNode(childVal);
				size++;
			}
			else {
				insert(childVal, root.left);
			}
		}
		else {
			if(root.right == null) {
				root.right = new BSTNode(childVal);
				size++;
			}
			else {
				insert(childVal, root.right);
			}
		}	
	}
	
	public void insert(BSTNode insertedNode, BSTNode root) {
		if(insertedNode.value == root.value) {
			throw new RuntimeException("Value already exists");
		}
		else if(insertedNode.value < root.value) {
			if(root.left == null) {
				root.left = insertedNode;
				size++;
			}
			else {
				insert(insertedNode, root.left);
			}
		}
		else {
			if(root.right == null) {
				root.right = insertedNode;
				size++;
			}
			else {
				insert(insertedNode, root.right);
			}
		}
	}
	
	public BSTNode search(int key, BSTNode root) {
		if(key == root.value) {
			return root;
		}
		else if(key < root.value && root != null) {
			return search(key, root.left);
		}
		else if(key > root.value && root != null){
			return search(key, root.right);
		}
		else {
			throw new RuntimeException("Node is not contained in tree");
			//throw new NullPointerException("Node is not contained in tree");
			//return null;
		}
	}
	public ArrayList<Integer> getInOrderArrayList(BST tree) {
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		inOrderTraversal(tree.root, inOrder);
		return inOrder;
	}
	
	private void inOrderTraversal(BSTNode node, ArrayList<Integer> inOrder) {
				
		if(node == null)
			return;
		
		inOrderTraversal(node.left, inOrder);
		inOrder.add(node.value);
		inOrderTraversal(node.right, inOrder);
	}
	
	public BSTNode findMax(BSTNode node) {
		if(node.right == null) {
			return node;
		}
		else {
			return findMax(node.right);
		}
	}
	
	public BSTNode findMin(BSTNode node) {
		if(node.left == null) {
			return node;
		}
		else {
			return findMin(node.left);
		}
	}
	
	public void delete(int value, BSTNode root) {
		
		BSTNode minOfRightSub;
		BSTNode deletedNode;
		
		//Algorithm for deleting a node with no children
		if(value == root.value) {
			if(getNumChildren(root) == 0) {
				root = null;
				found = true;
				return;
			}
			//Algorithm to delete all other nodes
			else {
				System.out.println("3root = " + root.value);
				deletedNode = root;
				minOfRightSub = findMin(deletedNode.right);
				System.out.println(minOfRightSub.value);
				//root.left = null;
				//root.right = null;
				root = minOfRightSub;
				System.out.println("f" + root.value);
				System.out.println("d" + deletedNode.left.value);
//				insert(minOfRightSub.value, this.root);
				//insert(deletedNode.left, root);
				if(deletedNode.right.value != minOfRightSub.value) {
					System.out.println("in if");
					//insert(deletedNode.right, root);
					delete(minOfRightSub.value, root);
				}
				found = true;
				return;
			}
			
		}
		else if(value < root.value && !found) {
			System.out.println("1root = " + root.value);
			delete(value, root.left);
		}
		else if(value > root.value && !found) {
			System.out.println("2root = " + root.value);
			delete(value, root.right);
		}
		else {
			return;
		}
	}
	
	public int getNumChildren(BSTNode node) {
		if(node.left == null && node.right == null) {
			return 0;
		}
		else if(node.left == null && node.right != null) {
			return 1;
		}
		else if(node.left != null && node.right == null) {
			return 1;
		}
		else {
			return 2;
		}
	}
	
	public BSTNode getLeft() {
		return root.left;
	}
	
	public BSTNode getRight() {
		return root.right;
	}
	
	public int getSize() {
		return size;
	}
	
	public int value() {
		return root.value;
	}
	
//	public void setLeft(int value) {
//		this.getLeft().root = value;
//	}
//	
//	public void setRight(int value) {
//		this.getRight().root = value;
//	}
	

}
