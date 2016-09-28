package org.aivan.tree;

import java.util.List;

import org.aivan.generators.DataGenerator;
import org.aivan.tree.simple.OrderedTree;
import org.aivan.tree.simple.SimpleTree;
import org.junit.Assert;
import org.junit.Test;

public class OrderedTreeTest {

	private static final int TEST_ITEMS_COUNT = 1000;

	@Test
	public void treeTestString() {
		SimpleTree<String> stree = new OrderedTree<String>();
		for(int i=0;i<TEST_ITEMS_COUNT;i++) {
			stree.add(Integer.toString(i));
		}
		// Now check the tree:
		List<String> items = stree.getAll();
		Assert.assertEquals(TEST_ITEMS_COUNT, items.size());
		for(int i=0;i<1000;i++) {
			Assert.assertTrue("List contains item: "+i, items.contains(Integer.toString(i)));
		}
		// All elements are to the right
		Assert.assertEquals(0, stree.getRoot().leftCount);
		Assert.assertEquals(999, stree.getRoot().rightCount);
	}
	
	@Test
	public void treeTestLong() {
		SimpleTree<Long> stree = new OrderedTree<Long>();
		for(int i=0;i<TEST_ITEMS_COUNT;i++) {
			stree.add(new Long(i));
		}
		// Now check the tree:
		List<Long> items = stree.getAll();
		Assert.assertEquals(TEST_ITEMS_COUNT, items.size());
		for(int i=0;i<1000;i++) {
			Assert.assertTrue("List contains item: "+i, items.contains(new Long(i)));
		}
		// All elements are to the right
		Assert.assertEquals(0, stree.getRoot().leftCount);
		Assert.assertEquals(999, stree.getRoot().rightCount);
	}
	
	@Test
	public void treeTestLongRandom() {
		SimpleTree<Long> stree = new OrderedTree<Long>();
		Long[] data = DataGenerator.generateRandomLongObjArray(TEST_ITEMS_COUNT);
		for(Long l : data) {
			stree.add(l);
		}
		// Now check the tree:
		List<Long> items = stree.getAll();
		Assert.assertEquals(TEST_ITEMS_COUNT, items.size());
		
//		for(int i=0;i<1000;i++) {
//			Assert.assertTrue("List contains item: "+i, items.contains(new Long(i)));
//		}
		// All elements are to the right
		System.out.println("Left count:"+stree.getRoot().leftCount);
		System.out.println("Right count:"+stree.getRoot().rightCount);
	}
	
}
