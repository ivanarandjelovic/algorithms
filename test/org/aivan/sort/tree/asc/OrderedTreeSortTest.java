package org.aivan.sort.tree.asc;

import org.aivan.sort.Sort;
import org.aivan.sort.SortAscendingArrayTest;
import org.aivan.sort.tree.OrderedTreeSort;
import org.junit.Test;

/**
 * This surely causes stack overflow!
 * 
 * @author aivan
 *
 */
public class OrderedTreeSortTest extends SortAscendingArrayTest{

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
