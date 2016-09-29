package org.aivan.tree;

import java.util.List;

import org.aivan.generators.DataGenerator;
import org.aivan.tree.balanced.BalancedOrderedTree;
import org.aivan.tree.simple.SimpleTree;
import org.junit.Assert;
import org.junit.Test;

public class BalancedTreeTest {

	private static final int TEST_ITEMS_COUNT = 100;

	
	@Test
	public void treeTestLongRandom() {
		SimpleTree<Long> stree = new BalancedOrderedTree<Long>();
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
	
	@Test
	public void treeTestStringRandom() throws Exception {
		SimpleTree<String> stree = new BalancedOrderedTree<String>();
		String[] data = DataGenerator.generateRandomOrderedStringArray(TEST_ITEMS_COUNT, 3);
		for(String l : data) {
			stree.add(l);
		}
		// Now check the tree:
		List<String> items = stree.getAll();
		Assert.assertEquals(TEST_ITEMS_COUNT, items.size());
		
//		for(int i=0;i<1000;i++) {
//			Assert.assertTrue("List contains item: "+i, items.contains(new Long(i)));
//		}
		// All elements are to the right
		System.out.println("Left count:"+stree.getRoot().leftCount);
		System.out.println("Right count:"+stree.getRoot().rightCount);
	}
	
}
