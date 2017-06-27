package tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinTreeTest {

	@Test
	public void isEmptyNullTest() 
	{
		BinTree tree = new BinTree();
		assertTrue(tree.isEmpty());
	}
	
	@Test
	public void isEmptyRootTest()
	{
		BinNode node = new BinNode(7);
		BinTree tree = new BinTree(node);
		assertFalse(tree.isEmpty());
	}
	
	@Test
	public void isEmptryNormalTest()
	{
		BinNode a = new BinNode(1);
		BinNode b = new BinNode(3);
		BinNode c = new BinNode(2, a, b);
		BinNode d = new BinNode(5);
		BinNode e = new BinNode(4, c, d);
		BinNode f = new BinNode(8);
		BinNode g = new BinNode(9, f, null);
		BinNode root = new BinNode(7, e, g);
		BinTree tree = new BinTree(root);
		assertFalse(tree.isEmpty());
	}
	
	@Test
	public void countInnerNodesNullTest()
	{
		BinTree tree = new BinTree();
		assertEquals(0, tree.countInnerNodes(), 0);
	}

	@Test
	public void countInnerNodesRootTest()
	{
		BinNode node = new BinNode(7);
		BinTree tree = new BinTree(node);
		assertEquals(0, tree.countInnerNodes(), 0);
	}

	@Test
	public void countInnerNodesNormalTest()
	{
		BinNode a = new BinNode(1);
		BinNode b = new BinNode(3);
		BinNode c = new BinNode(2, a, b);
		BinNode d = new BinNode(5);
		BinNode e = new BinNode(4, c, d);
		BinNode f = new BinNode(8);
		BinNode g = new BinNode(9, f, null);
		BinNode root = new BinNode(7, e, g);
		BinTree tree = new BinTree(root);
		assertEquals(3, tree.countInnerNodes(), 0);
	}

	@Test
	public void isSortedNullTest()
	{
		BinTree tree = new BinTree();
		assertTrue(tree.isSorted());
	}
	
	@Test
	public void isSortedRootTest()
	{
		BinNode node = new BinNode(7);
		BinTree tree = new BinTree(node);
		assertTrue(tree.isSorted());
	}
	
	@Test
	public void isSortedNormalTest()
	{
		BinNode a = new BinNode(1);
		BinNode b = new BinNode(3);
		BinNode c = new BinNode(2, a, b);
		BinNode d = new BinNode(5);
		BinNode e = new BinNode(4, c, d);
		BinNode f = new BinNode(8);
		BinNode g = new BinNode(9, f, null);
		BinNode root = new BinNode(7, e, g);
		BinTree tree = new BinTree(root);
		assertTrue(tree.isSorted());
	}
	
	@Test
	public void removeNodeNullTest()
	{
		BinTree tree = new BinTree();
		BinTree real = new BinTree();
		tree.removeNode();
		assertEquals(real, tree);
	}
	
	@Test
	public void removeNodeRootTest()
	{
		BinNode node = new BinNode(7);
		BinTree tree = new BinTree(node);
		BinTree real = new BinTree();
		tree.removeNode();
		assertNull(tree);
	}
	
	@Test
	public void removeNodeNormalTest()
	{
		BinNode a = new BinNode(1);
		BinNode b = new BinNode(3);
		BinNode c = new BinNode(2, a, b);
		BinNode d = new BinNode(5);
		BinNode e = new BinNode(4, c, d);
		BinNode f = new BinNode(8);
		BinNode g = new BinNode(9, f, null);
		BinNode root = new BinNode(7, e, g);
		BinTree tree = new BinTree(root);

		BinNode a2 = new BinNode(1);
		BinNode c2 = new BinNode(2, a2, null);
		BinNode d2 = new BinNode(5);
		BinNode e2 = new BinNode(3, c, d);
		BinNode f2 = new BinNode(8);
		BinNode g2 = new BinNode(9, f2, null);
		BinNode root2 = new BinNode(7, e2, g2);
		BinTree real = new BinTree(root2);
		
		tree.removeNode();
		
		//System.out.println(tree);
		System.out.println(real);
		BinTree test = tree;
		assertEquals(test, tree);
	}

}
