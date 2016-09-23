package org.aivan.sort.quicksort;

public class QuickSortPivotIsFirstElement<T extends Comparable<T>> extends QuickSort<T> {

	@Override
	protected T pickPivot(T[] array, int start, int end) {
		// Simply use first element
		return array[start];
	}


}
