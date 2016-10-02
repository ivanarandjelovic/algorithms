package org.aivan.sort.tree.asc;

import org.aivan.sort.Sort;
import org.aivan.sort.SortAscendingArrayTest;
import org.aivan.sort.tree.LeveledTreeSort;
import org.junit.Test;

public class LeveledTreeSortTest extends SortAscendingArrayTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	Sort<String> getSortString() {
		return new LeveledTreeSort<String>();
	}

	@Override
	protected
	Sort<Long> getSortLong() {
		return new LeveledTreeSort<Long>();
	}
	
	

}
