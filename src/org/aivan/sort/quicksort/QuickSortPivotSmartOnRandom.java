package org.aivan.sort.quicksort;

public class QuickSortPivotSmartOnRandom<T extends Comparable<T>> extends QuickSortWithRandomization<T> {

	@Override
	protected T pickPivot(T[] array, int start, int end) {
		// Take first three elements and pick middle one (they are already
		// randomized):
		if (end - start < 2) {
			// Only one or two elements, no way to improve this
			return array[start];
		} else {
			T val1 = array[start];
			T val2 = array[start + 1];
			T val3 = array[start + 2];

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
