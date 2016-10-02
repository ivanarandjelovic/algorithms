package org.aivan.tree;

import java.util.Arrays;
import java.util.List;

import org.aivan.generators.DataGenerator;
import org.aivan.tree.balanced.LeveledTree;
import org.aivan.tree.simple.SimpleTree;
import org.junit.Assert;
import org.junit.Test;

public class LeveledTreeTest {

	private static final int TEST_ITEMS_COUNT = 50000;

	@Test
	public void treeTestLongRandom() {
		SimpleTree<Long> stree = new LeveledTree<Long>();
		Long[] data = DataGenerator.generateRandomLongObjArray(TEST_ITEMS_COUNT);
		int i = 0;
		for (Long l : data) {
			stree.add(l);
//			i++;
//			List<Long> items = stree.getAll();
//			if (i != items.size()) {
//				Assert.assertEquals(i, items.size());
//			}
		}
		// Now check the tree:
		List<Long> items = stree.getAll();
		Assert.assertEquals(TEST_ITEMS_COUNT, items.size());

		// for(int i=0;i<1000;i++) {
		// Assert.assertTrue("List contains item: "+i, items.contains(new Long(i)));
		// }
		// All elements are to the right
		System.out.println("======");
		System.out.println("Left count:" + stree.getRoot().leftCount);
		System.out.println("Right count:" + stree.getRoot().rightCount);
		System.out.println("Height:" + stree.getRoot().height);
		System.out.println("Left height:" + stree.getRoot().left.height);
		System.out.println("Right height:" + stree.getRoot().right.height);
	}

	@Test
	public void treeTestStringRandom() throws Exception {
		SimpleTree<String> stree = new LeveledTree<String>();
		String[] data = DataGenerator.generateRandomOrderedStringArray(TEST_ITEMS_COUNT, 5);
		int i = 0;
		for (String l : data) {
			stree.add(l);
//			i++;
//			List<String> items = stree.getAll();
//			if (i != items.size()) {
//				Assert.assertEquals(i, items.size());
//			}
		}
		// Now check the tree:
		List<String> items = stree.getAll();
		Assert.assertEquals(TEST_ITEMS_COUNT, items.size());

		// for(int i=0;i<1000;i++) {
		// Assert.assertTrue("List contains item: "+i, items.contains(new Long(i)));
		// }
		// All elements are to the right
		System.out.println("======");
		System.out.println("Left count:" + stree.getRoot().leftCount);
		System.out.println("Right count:" + stree.getRoot().rightCount);
		System.out.println("Height:" + stree.getRoot().height);
		System.out.println("Left height:" + stree.getRoot().left.height);
		System.out.println("Right height:" + stree.getRoot().right.height);
		
		String[] systemSorted = systemSort(data);
		
		if(!Arrays.equals(items.toArray(data), systemSorted)) {
			System.out.println("failure");
		}
		
	}

	private String[] systemSort(String[] arr) {
		String[] systemSorted = Arrays.copyOf(arr, arr.length);

		Arrays.sort(systemSorted);

		return systemSorted;
	}
}
