package org.aivan.tree;

import java.util.List;

import org.aivan.tree.base.Tree;
import org.aivan.tree.simple.SimpleTree;
import org.junit.Assert;
import org.junit.Test;

public class SimpleTreeTest {

	private static final int TEST_ITEMS_COUNT = 1000;

	@Test
	public void treeTestString() {
		SimpleTree<String> stree = new SimpleTree<String>();
		for(int i=0;i<TEST_ITEMS_COUNT;i++) {
			stree.add(Integer.toString(i));
		}
		// Now check the tree:
		List<String> items = stree.getAll();
		Assert.assertEquals(TEST_ITEMS_COUNT, items.size());
		for(int i=0;i<1000;i++) {
			Assert.assertTrue("List contains item: "+i, items.contains(Integer.toString(i)));
		}
		Assert.assertEquals(500, stree.getRoot().leftCount);
		Assert.assertEquals(499, stree.getRoot().rightCount);
	}
	
	@Test
	public void treeTestLong() {
		SimpleTree<Long> stree = new SimpleTree<Long>();
		for(int i=0;i<TEST_ITEMS_COUNT;i++) {
			stree.add(new Long(i));
		}
		// Now check the tree:
		List<Long> items = stree.getAll();
		Assert.assertEquals(TEST_ITEMS_COUNT, items.size());
		for(int i=0;i<1000;i++) {
			Assert.assertTrue("List contains item: "+i, items.contains(new Long(i)));
		}
		Assert.assertEquals(500, stree.getRoot().leftCount);
		Assert.assertEquals(499, stree.getRoot().rightCount);
	}
	
	@Test
	public void treeTestDeletion() {
		Tree<String> stree = new SimpleTree<String>();
	
		stree.add("1");
		stree.add("2");
		stree.add("2");
		stree.add("2");
		stree.add("3");
		
		// Now check the tree:
		List<String> items = stree.getAll();
		Assert.assertEquals(5, items.size());
		
		stree.delete("2");
		items = stree.getAll();
		Assert.assertEquals(4, items.size());

		stree.delete("2");
		stree.delete("2");
		items = stree.getAll();
		Assert.assertEquals(2, items.size());

		stree.delete("1");
		items = stree.getAll();
		Assert.assertEquals(1, items.size());

		stree.delete("3");
		items = stree.getAll();
		Assert.assertEquals(0, items.size());
	}
	
}
