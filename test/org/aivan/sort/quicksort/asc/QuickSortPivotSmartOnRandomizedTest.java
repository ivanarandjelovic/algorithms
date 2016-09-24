package org.aivan.sort.quicksort.asc;

import org.aivan.sort.Sort;
import org.aivan.sort.SortAscendingArrayTest;
import org.aivan.sort.quicksort.QuickSortPivotSmartOnRandom;
import org.junit.Test;

public class QuickSortPivotSmartOnRandomizedTest extends SortAscendingArrayTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	Sort<String> getSortString() {
		return new QuickSortPivotSmartOnRandom<String>();
	}

	@Override
	protected
	Sort<Long> getSortLong() {
		return new QuickSortPivotSmartOnRandom<Long>();
	}
	
	

}
