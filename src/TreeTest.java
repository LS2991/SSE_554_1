import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TreeTest {

	@Test
	public void InitializeAndInsertTest() {
		BST tree = new BST(4);
		tree.insert(2, tree.root);
		tree.insert(5, tree.root);

		assertTrue(tree.root.value == 4);
		assertTrue(tree.root.left.value == 2);
		assertTrue(tree.root.right.value == 5);
	}
	
	@Test (expected = RuntimeException.class)
	public void SameValueTest() {
		BST tree = new BST(4);
		tree.insert(2, tree.root);
		tree.insert(5, tree.root);
		
		tree.insert(4, tree.root);
		tree.insert(2, tree.root);
		tree.insert(5, tree.root);
	}
	
	@Test
	public void insertNodeTest() {
		BST tree = new BST(4);
		BSTNode n1 = new BSTNode(2);
		BSTNode n2 = new BSTNode(5);
		
		tree.insert(n1, tree.root);
		tree.insert(n2, tree.root);

		assertTrue(tree.root.value == 4);
		assertTrue(tree.root.left.value == 2);
		assertTrue(tree.root.right.value == 5);
	}
	
	@Test
	public void treeSizeTest() {
		BST tree = new BST(8);
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}

		assertEquals(vals.length + 1, tree.getSize());
	}
	
	@Test
	public void SearchTest() {
		BST tree = new BST(8);
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		assertEquals(5, tree.search(5, tree.root).value);
		assertEquals(20, tree.search(20, tree.root).value);
		assertEquals(1, tree.search(1, tree.root).value);
	}
	
	@Test (expected = NullPointerException.class)
	public void searchFailedTest() {
		BST tree = new BST(8);
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		tree.search(0, tree.root);
		tree.search(200, tree.root);
		tree.search(-1, tree.root);
	}
	
	@Test
	public void InOrderTraversalTestNotNullArray() {
		BST tree = new BST(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		ArrayList<Integer> testList = tree.getInOrderArrayList(tree);
		assertTrue(testList != null);
	}
	
	@Test
	public void InOrderTraversalOrderedArray() {
		BST tree = new BST(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		int[] ordered = {1, 2, 3, 5, 6, 8, 9, 10, 15, 19, 20};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		ArrayList<Integer> testList = tree.getInOrderArrayList(tree);
		
		for(int x = 0; x < tree.getSize(); x++) {
			assertTrue(testList.get(x) == ordered[x]);
		}
	}
	
	@Test
	public void findMaxTest() {
		BST tree = new BST(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		assertEquals(20, tree.findMax(tree.root).value);
	}
	@Test
	public void findMinTest() {
		BST tree = new BST(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		assertEquals(1, tree.findMin(tree.root).value);
	}
	
	@Test
	public void numChildrenTest() {
		BST tree = new BST(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		assertTrue(tree.getNumChildren(tree.search(8, tree.root)) == 2);
		assertTrue(tree.getNumChildren(tree.search(20, tree.root)) == 1);
		assertTrue(tree.getNumChildren(tree.search(1, tree.root)) == 0);
		
	}
	
	@Test (expected = RuntimeException.class)
	public void deleteTestNoChildren() {
		BST tree = new BST(8);
		//BSTNode delete;
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		tree.delete(1, tree.root);
		tree.delete(5, tree.root);
		tree.delete(9, tree.root);
		tree.delete(19, tree.root);
		
		
		tree.search(1, tree.root);
		tree.search(5, tree.root);
		tree.search(9, tree.root);
		tree.search(19, tree.root);
		
	}
	
	@Test (expected = RuntimeException.class)
	public void deletTestWithChildren() {
		BST tree = new BST(8);
		//BSTNode delete;
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x, tree.root);
		}
		
		tree.delete(2, tree.root);
		tree.delete(15, tree.root);
		
		tree.search(2, tree.root);
		tree.search(15, tree.root);
		
		assertTrue(tree.search(3, tree.root).left.value == 1);
		assertTrue(tree.search(3, tree.root).right.value == 5);
		
		assertTrue(tree.search(10, tree.root).left.value == 9);
		assertTrue(tree.search(10, tree.root).right.value == 19);
		
		assertTrue(tree.search(19, tree.root).left == null);
		assertTrue(tree.search(19, tree.root).right.value == 20);
	}

}
