package org.aivan.sort.quicksort.asc;

import org.aivan.sort.quicksort.QuickSort;
import org.aivan.sort.quicksort.QuickSortPivotRandom;
import org.junit.Test;

public class QuickSortPivotRandomTest extends QuickSortAscendingArrayTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	QuickSort<String> getQuickSort() {
		return new QuickSortPivotRandom<String>();
	}

	@Override
	protected
	QuickSort<Long> getQuickSortLong() {
		return new QuickSortPivotRandom<Long>();
	}

	
}
