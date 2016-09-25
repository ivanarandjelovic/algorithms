package org.aivan.sort.quicksort.random;

import org.aivan.sort.Sort;
import org.aivan.sort.SortRandomArraysTest;
import org.aivan.sort.quicksort.QuickSortAdaptivePivotSmart;
import org.junit.Test;

public class QuickSortAdaptivePivotSmartTest extends SortRandomArraysTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	Sort<String> getSortString() {
		return new QuickSortAdaptivePivotSmart<String>();
	}

	@Override
	protected
	Sort<Long> getSortLong() {
		return new QuickSortAdaptivePivotSmart<Long>();
	}
	
	

}
