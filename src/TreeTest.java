import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TreeTest {

	@Test
	public void InitializeAndInsertTest() {
		BSTNode tree = new BSTNode(4);
		tree.insert(2);
		tree.insert(5);
		assertTrue(tree.value() == 4);
		assertTrue(tree.getLeft().value() == 2);
		assertTrue(tree.getRight().value() == 5);
	}
	
	@Test (expected = RuntimeException.class)
	public void SameValueTest() {
		BSTNode tree = new BSTNode(4);
		tree.insert(2);
		tree.insert(5);
		
		tree.insert(4);
		tree.insert(2);
		tree.insert(5);
	}
	
	@Test
	public void treeSizeTest() {
		BSTNode tree = new BSTNode(8);
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x);
		}
		
		assertEquals(vals.length + 1, tree.getSize());
	}
	
	@Test
	public void SearchTest() {
		BSTNode tree = new BSTNode(8);
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x);
		}
		
		assertEquals(20, tree.search(20).value());
	}
	
	@Test
	public void searchFailedTest() {
		BSTNode tree = new BSTNode(8);
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x);
		}
		//System.out.println(tree.search(100) + " sdf sdfsdfsd");
		assertTrue(tree.search(0) == null);
	}
	
	@Test
	public void InOrderTraversalTestNotNullArray() {
		BSTNode tree = new BSTNode(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x);
		}
		
		ArrayList<Integer> testList = tree.getInOrderArrayList(tree);
		assertTrue(testList != null);
	}
	
	@Test
	public void InOrderTraversalOrderedArray() {
		BSTNode tree = new BSTNode(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		int[] ordered = {1, 2, 3, 5, 6, 8, 9, 10, 15, 19, 20};
		
		for(int x : vals) {
			tree.insert(x);
		}
		
		ArrayList<Integer> testList = tree.getInOrderArrayList(tree);
		
		for(int x = 0; x < tree.getSize(); x++) {
			assertTrue(testList.get(x) == ordered[x]);
		}
	}
	
	@Test
	public void findMaxTest() {
		BSTNode tree = new BSTNode(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x);
		}
		
		assertEquals(20, tree.findMax().value());
	}
	@Test
	public void findMinTest() {
		BSTNode tree = new BSTNode(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x);
		}
		
		assertEquals(1, tree.findMin().value());
	}
	
	@Test
	public void numChildrenTest() {
		BSTNode tree = new BSTNode(8);
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x);
		}
		
		assertTrue(tree.getNumChildren() == 2);
		assertTrue(tree.search(20).getNumChildren() == 1);
		assertTrue(tree.search(1).getNumChildren() == 0);
		
	}
	
	@Test
	public void deleteTestNoChildren() {
		BSTNode tree = new BSTNode(8);
		//BSTNode delete;
		
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x);
		}
		
		tree.delete(1, tree);
		tree.delete(3, tree);
		
		assertTrue(tree.search(1) == null);
		assertTrue(tree.search(5) == null);
		
	}

}
