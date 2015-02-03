import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		BST tree = new BST(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		ArrayList<Integer> inorderArray = tree.getInOrderArrayList(tree);
		
		System.out.println("Shows that insertion and the inorder traversal is working order");
		for(int x = 0; x < inorderArray.size(); x++) {
			System.out.print(inorderArray.get(x) + ", ");
		}
		
		System.out.println("\n\nMax = " + tree.findMax(tree.root).value);
		System.out.println("Min = " + tree.findMin(tree.root).value);
		
		System.out.println("\nTotal Number of nodes = " + tree.getSize());
		
		System.out.println("\nShows the search method and the getNumChildren method working correctly");
		System.out.println("Number of childrn node 8 has = " + tree.getNumChildren(tree.search(8, tree.root)));
		System.out.println("Number of children node 20 has = " + tree.getNumChildren(tree.search(20, tree.root)));
		System.out.println("Number of children node 1 has = " + tree.getNumChildren(tree.search(1, tree.root)));
		
		System.out.println("\nShows delete method working");
		System.out.println("Deleting nodes 2 and 15");
		tree.delete(2, tree.root);
		tree.delete(15, tree.root);
		
		System.out.println("Searching for nodes 2 and 15");
		tree.search(2, tree.root);
		tree.search(15, tree.root);
		
	}

}
