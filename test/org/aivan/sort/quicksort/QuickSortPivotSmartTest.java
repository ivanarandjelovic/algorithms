package org.aivan.sort.quicksort;

import org.junit.Test;

public class QuickSortPivotSmartTest extends QuickSortRandomArraysTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	QuickSort<String> getQuickSort() {
		return new QuickSortPivotSmart<String>();
	}

	@Override
	protected
	QuickSort<Long> getQuickSortLong() {
		return new QuickSortPivotSmart<Long>();
	}
	
	

}
