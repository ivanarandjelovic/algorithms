package org.aivan.sort.quicksort;

import org.junit.Test;

public class QuickSortPivotFirstTest extends QuickSortTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	QuickSort<String> getQuickSort() {
		return new QuickSortPivotIsFirstElement<String>();
	}

}
