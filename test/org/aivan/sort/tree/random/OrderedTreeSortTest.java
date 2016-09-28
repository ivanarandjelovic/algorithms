package org.aivan.sort.tree.random;

import org.aivan.sort.Sort;
import org.aivan.sort.SortRandomArraysTest;
import org.aivan.sort.tree.OrderedTreeSort;
import org.junit.Test;

public class OrderedTreeSortTest extends SortRandomArraysTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	Sort<String> getSortString() {
		return new OrderedTreeSort<String>();
	}

	@Override
	protected
	Sort<Long> getSortLong() {
		return new OrderedTreeSort<Long>();
	}
	
	

}
