package org.aivan.sort.quicksort;

import java.util.Random;

import org.aivan.sort.insertionsort.InsertionSort;

public class QuickSortAdaptivePivotSmart<T extends Comparable<T>> extends QuickSort<T> {

	/**
	 * When array size is below this limit we will simply use insertion sort (good for already ordered data
	 * so as a side effect we are good with partially sorted arrays).
	 */
	private static final int SWITCH_TO_INSERTION_LIMIT = 64;

	static Random r = new Random();

	InsertionSort<T> isort = new InsertionSort<T>();
	
	@Override
	protected T pickPivot(T[] array, int start, int end) {
		// Take three random elements and pick middle one:
		if (end - start < 2) {
			// Only one or two elements, no way to improve this
			return array[start];
		} else {
			T val1 = array[start + r.nextInt(end - start + 1)];
			T val2 = array[start + r.nextInt(end - start + 1)];
			T val3 = array[start + r.nextInt(end - start + 1)];

			if (val1.compareTo(val2) > 0) {
				if (val1.compareTo(val2) < 0) {
					return val1;
				} else {
					if (val2.compareTo(val3) > 0) {
						return val2;
					} else {
						return val3;
					}
				}
			} else {
				if (val1.compareTo(val3) > 0) {
					return val1;
				} else {
					if (val2.compareTo(val3) < 0) {
						return val2;
					} else {
						return val3;
					}
				}
			}
		}
	}

	@Override
	protected void qsort(T[] array, int start, int end, int depth) {
		if (end - start > SWITCH_TO_INSERTION_LIMIT) {
			super.qsort(array, start, end, depth);
		} else {
			isort.sort(array, start, end - start + 1);
		}
	}

}
