import static org.junit.Assert.*;

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
	public void SearchTest() {
		BSTNode tree = new BSTNode(8);
		int[] vals = {10, 15, 6, 9, 2, 1, 20, 19, 3, 5};
		
		for(int x : vals) {
			tree.insert(x);
		}
		
		assertEquals(20, tree.search(20).value());
	}

}
