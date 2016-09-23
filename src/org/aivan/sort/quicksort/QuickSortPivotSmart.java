package org.aivan.sort.quicksort;

import java.util.Random;

public class QuickSortPivotSmart<T extends Comparable<T>> extends QuickSort<T> {

	static Random r = new Random();

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
}
