package org.aivan.sort.quicksort;

public class QuickSortPivotFirstTest extends QuickSortTest {

	@Override
	QuickSort<String> getQuickSort() {
		return new QuickSortPivotIsFirstElement<String>();
	}

}
