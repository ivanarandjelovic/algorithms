package org.aivan.sort.tree.random;

import org.aivan.sort.Sort;
import org.aivan.sort.SortRandomArraysTest;
import org.aivan.sort.tree.BalancedTreeSort;
import org.aivan.sort.tree.OrderedTreeSort;
import org.junit.Test;

public class BalancedTreeSortTest extends SortRandomArraysTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	Sort<String> getSortString() {
		return new BalancedTreeSort<String>();
	}

	@Override
	protected
	Sort<Long> getSortLong() {
		return new BalancedTreeSort<Long>();
	}
	
	

}
