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
	
	

}
