package org.aivan.tree;

import java.util.Arrays;

import org.aivan.tree.balanced.BalancedOrderedTree;
import org.aivan.tree.base.Node;
import org.junit.Assert;
import org.junit.Test;

public class BalancedTreeUnitTest {

	@Test
	public void testEmptyTree() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		Node<String> root = btree.getRoot();

		Assert.assertNull(root);
		Assert.assertEquals(0, btree.getAll().size());
	}

	@Test
	public void testAddToEmptyTree() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("AAA");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "AAA", 1, 0, 0, null, 0, null);

		Assert.assertEquals(1, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA" }, btree.getAll().toArray(new String[] {})));
	}
	
	@Test
	public void testAddToEmptyMoreValuesTree() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("AAA");
		btree.add("AAA");
		btree.add("AAA");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "AAA", 3, 0, 0, null, 0, null);

		Assert.assertEquals(3, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA","AAA","AAA" }, btree.getAll().toArray(new String[] {})));
	}
	
	@Test
	public void testAddToEmptyMoreValuesInChildTree() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("AAA");
		btree.add("AAA");
		btree.add("BBB");
		btree.add("BBB");
		btree.add("BBB");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "AAA", 2, 0, 0, null, 1, null);

		// Check child node
		Node<String> child = root.right;
		validateNode(root, child, "BBB", 3, 1, 0, null, 0, null);

		Assert.assertEquals(5, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA","AAA","BBB","BBB","BBB" }, btree.getAll().toArray(new String[] {})));
	}

	@Test
	public void testAddToOneRightTree() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("AAA");
		btree.add("BBB");

		// Check root node
		Node<String> root = btree.getRoot();
		validateNode(null, root, "AAA", 1, 0, 0, null, 1, null);

		// Check child node
		Node<String> child = root.right;
		validateNode(root, child, "BBB", 1, 1, 0, null, 0, null);

		Assert.assertEquals(2, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB" }, btree.getAll().toArray(new String[] {})));
	}

	@Test
	public void testAddToOneLeftTree() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("BBB");
		btree.add("AAA");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "BBB", 1, 0, 1, null, 0, null);

		// Check child node
		Node<String> child = root.left;
		validateNode(root, child, "AAA", 1, 1, 0, null, 0, null);

		Assert.assertEquals(2, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB" }, btree.getAll().toArray(new String[] {})));
	}

	@Test
	public void testBalanceFromLeft() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("CCC");
		btree.add("BBB");
		btree.add("AAA");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "BBB", 1, 0, 1, null, 1, null);

		// Check left child node
		Node<String> child = root.left;
		validateNode(root, child, "AAA", 1, 1, 0, null, 0, null);

		// Check right child node
		child = root.right;
		validateNode(root, child, "CCC", 1, 1, 0, null, 0, null);

		Assert.assertEquals(3, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC" }, btree.getAll().toArray(new String[] {})));
	}
	
	@Test
	public void testBalanceFromRight() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("AAA");
		btree.add("BBB");
		btree.add("CCC");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "BBB", 1, 0, 1, null, 1, null);

		// Check left child node
		Node<String> child = root.left;
		validateNode(root, child, "AAA", 1, 1, 0, null, 0, null);

		// Check right child node
		child = root.right;
		validateNode(root, child, "CCC", 1, 1, 0, null, 0, null);

		Assert.assertEquals(3, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC" }, btree.getAll().toArray(new String[] {})));
	}
	
	@Test
	public void testBalanceFromLeft2() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("CCC");
		btree.add("AAA");
		btree.add("BBB");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "BBB", 1, 0, 1, null, 1, null);

		// Check left child node
		Node<String> child = root.left;
		validateNode(root, child, "AAA", 1, 1, 0, null, 0, null);

		// Check right child node
		child = root.right;
		validateNode(root, child, "CCC", 1, 1, 0, null, 0, null);

		Assert.assertEquals(3, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC" }, btree.getAll().toArray(new String[] {})));
	}
	
	@Test
	public void testBalanceFromRight2() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("AAA");
		btree.add("CCC");
		btree.add("BBB");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "BBB", 1, 0, 1, null, 1, null);

		// Check left child node
		Node<String> child = root.left;
		validateNode(root, child, "AAA", 1, 1, 0, null, 0, null);

		// Check right child node
		child = root.right;
		validateNode(root, child, "CCC", 1, 1, 0, null, 0, null);

		Assert.assertEquals(3, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC" }, btree.getAll().toArray(new String[] {})));
	}
	
	@Test
	public void testBalanceFromLeft3() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("DDD");
		btree.add("AAA");
		btree.add("EEE");
		btree.add("BBB");
		btree.add("CCC");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "CCC", 1, 0, 2, null, 2, null);

		// Check left child node
		Node<String> Achild = root.left;
		validateNode(root, Achild, "AAA", 1, 1, 0, null, 1, null);

		Node<String> Bchild = Achild.right;
		validateNode(Achild, Bchild, "BBB", 1, 2, 0, null, 0, null);

		// Check right child node
		Node<String> Echild = root.right;
		validateNode(root, Echild, "EEE", 1, 1, 1, null, 0, null);

		Node<String> Dchild = Echild.left;
		validateNode(Echild, Dchild, "DDD", 1, 2, 0, null, 0, null);

		Assert.assertEquals(5, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC", "DDD", "EEE" }, btree.getAll().toArray(new String[] {})));
	}
	
	@Test
	public void testBalanceFromRight3() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("BBB");
		btree.add("AAA");
		btree.add("EEE");
		btree.add("DDD");
		btree.add("CCC");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "CCC", 1, 0, 2, null, 2, null);

		// Check left child node
		Node<String> Achild = root.left;
		validateNode(root, Achild, "AAA", 1, 1, 0, null, 1, null);

		Node<String> Bchild = Achild.right;
		validateNode(Achild, Bchild, "BBB", 1, 2, 0, null, 0, null);

		// Check right child node
		Node<String> Echild = root.right;
		validateNode(root, Echild, "EEE", 1, 1, 1, null, 0, null);

		Node<String> Dchild = Echild.left;
		validateNode(Echild, Dchild, "DDD", 1, 2, 0, null, 0, null);

		Assert.assertEquals(5, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC", "DDD", "EEE" }, btree.getAll().toArray(new String[] {})));
	}
	
	@Test
	public void testBalanceFromLeft4() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("DDD");
		btree.add("AAA");
		btree.add("EEE");
		btree.add("CCC");
		btree.add("BBB");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "CCC", 1, 0, 2, null, 2, null);

		// Check left child node
		Node<String> Achild = root.left;
		validateNode(root, Achild, "AAA", 1, 1, 0, null, 1, null);

		Node<String> Bchild = Achild.right;
		validateNode(Achild, Bchild, "BBB", 1, 2, 0, null, 0, null);

		// Check right child node
		Node<String> Echild = root.right;
		validateNode(root, Echild, "EEE", 1, 1, 1, null, 0, null);

		Node<String> Dchild = Echild.left;
		validateNode(Echild, Dchild, "DDD", 1, 2, 0, null, 0, null);

		Assert.assertEquals(5, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC", "DDD", "EEE" }, btree.getAll().toArray(new String[] {})));
	}
	
	@Test
	public void testBalanceFromRight4() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("BBB");
		btree.add("AAA");
		btree.add("EEE");
		btree.add("CCC");
		btree.add("DDD");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "CCC", 1, 0, 2, null, 2, null);

		// Check left child node
		Node<String> Achild = root.left;
		validateNode(root, Achild, "AAA", 1, 1, 0, null, 1, null);

		Node<String> Bchild = Achild.right;
		validateNode(Achild, Bchild, "BBB", 1, 2, 0, null, 0, null);

		// Check right child node
		Node<String> Echild = root.right;
		validateNode(root, Echild, "EEE", 1, 1, 1, null, 0, null);

		Node<String> Dchild = Echild.left;
		validateNode(Echild, Dchild, "DDD", 1, 2, 0, null, 0, null);

		Assert.assertEquals(5, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC", "DDD", "EEE" }, btree.getAll().toArray(new String[] {})));
	}

	@Test
	public void testBalanceFromRight5() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("CCC");
		btree.add("BBB");
		btree.add("EEE");
		btree.add("AAA");
		btree.add("DDD");
		btree.add("FFF");
		btree.add("GGG");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "DDD", 1, 0, 3, null, 3, null);

		// Check left child node
		Node<String> L1child = root.left;
		validateNode(root, L1child, "BBB", 1, 1, 1, null, 1, null);

		Node<String> L2child = L1child.left;
		validateNode(L1child, L2child, "AAA", 1, 2, 0, null, 0, null);

		Node<String> R2child = L1child.right;
		validateNode(L1child, R2child, "CCC", 1, 2, 0, null, 0, null);

		// Check right child node
		Node<String> Rchild = root.right;
		validateNode(root, Rchild, "FFF", 1, 1, 1, null, 1, null);

		L2child = Rchild.left;
		validateNode(Rchild, L2child, "EEE", 1, 2, 0, null, 0, null);

		R2child = Rchild.right;
		validateNode(Rchild, R2child, "GGG", 1, 2, 0, null, 0, null);


		Assert.assertEquals(7, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG" }, btree.getAll().toArray(new String[] {})));
	}

	@Test
	public void testAscElements1() {
		BalancedOrderedTree<String> btree = new BalancedOrderedTree<String>();

		btree.add("AAA");
		btree.add("BBB");
		btree.add("CCC");
		btree.add("DDD");
		btree.add("EEE");
		btree.add("FFF");
		btree.add("GGG");

		Node<String> root = btree.getRoot();
		validateNode(null, root, "DDD", 1, 0, 3, null, 3, null);

		// Check left child node
		Node<String> L1child = root.left;
		validateNode(root, L1child, "BBB", 1, 1, 1, null, 1, null);

		Node<String> L2child = L1child.left;
		validateNode(L1child, L2child, "AAA", 1, 2, 0, null, 0, null);

		Node<String> R2child = L1child.right;
		validateNode(L1child, R2child, "CCC", 1, 2, 0, null, 0, null);

		// Check right child node
		Node<String> Rchild = root.right;
		validateNode(root, Rchild, "FFF", 1, 1, 1, null, 1, null);

		L2child = Rchild.left;
		validateNode(Rchild, L2child, "EEE", 1, 2, 0, null, 0, null);

		R2child = Rchild.right;
		validateNode(Rchild, R2child, "GGG", 1, 2, 0, null, 0, null);


		Assert.assertEquals(7, btree.getAll().size());
		Assert.assertTrue(Arrays.equals(new String[] { "AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG" }, btree.getAll().toArray(new String[] {})));
	}


	/**
	 * Helper method for validating nodes
	 * 
	 * @param parent What should parent point to (can be null for root node)
	 * @param child What is the node that we check
	 * @param value What value should be in the node
	 * @param count What count is expected in the node
	 * @param level What level should be in the node
	 * @param leftCount What is expected left count. If "0" then node.left is checked to be null, otherwise checked to be not null
	 * @param leftChild If not null then node.left is checked against this value
	 * @param rightCount Same as for leftCount
	 * @param rightChild same as for leftChild
	 */
	private void validateNode(Node<String> parent, Node<String> child, String value, int count, int level, int leftCount,
			Node<String> leftChild, int rightCount, Node<String> rightChild) {
		Assert.assertEquals(value, child.value);
		Assert.assertEquals(count, child.count);
		Assert.assertEquals(level, child.level);
		Assert.assertEquals(parent, child.parent);
		Assert.assertEquals(leftCount, child.leftCount);
		if (leftCount == 0) {
			Assert.assertNull(child.left);
		} else {
			Assert.assertNotNull(child.left);
		}
		if (leftChild != null) {
			Assert.assertEquals(leftChild, child.left);
		}
		Assert.assertEquals(rightCount, child.rightCount);
		if (rightCount == 0) {
			Assert.assertNull(child.right);
		} else {
			Assert.assertNotNull(child.right);
		}
		if (rightChild != null) {
			Assert.assertEquals(rightChild, child.right);
		}
	}
}
