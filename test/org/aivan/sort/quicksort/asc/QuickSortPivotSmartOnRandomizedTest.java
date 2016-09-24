package org.aivan.sort.quicksort.asc;

import org.aivan.sort.quicksort.QuickSort;
import org.aivan.sort.quicksort.QuickSortAscendingArrayTest;
import org.aivan.sort.quicksort.QuickSortPivotSmartOnRandom;
import org.junit.Test;

public class QuickSortPivotSmartOnRandomizedTest extends QuickSortAscendingArrayTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	QuickSort<String> getQuickSort() {
		return new QuickSortPivotSmartOnRandom<String>();
	}

	@Override
	protected
	QuickSort<Long> getQuickSortLong() {
		return new QuickSortPivotSmartOnRandom<Long>();
	}
	
	

}
