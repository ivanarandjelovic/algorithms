package org.aivan.sort.quicksort;

import java.util.Random;

public class QuickSortPivotRandom<T extends Comparable<T>> extends QuickSort<T> {

	static Random r = new Random();

	@Override
	protected T pickPivot(T[] array, int start, int end) {
		// Take random element:
		return array[start + r.nextInt(end - start + 1)];
	}

}
