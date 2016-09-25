package org.aivan.sort.insertionsort;

import org.aivan.sort.Sort;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length);
	}

	public void sort(T[] array, int start, int length) {
		if (length <= 1) {
			// Done!
			return;
		}
		for (int i = start + 1; i < start + length; i++) {
			int j = i;
			T tmp = array[i];
			while (j > start && array[j - 1].compareTo(tmp) > 0) {
				array[j] = array[j - 1];
				j--;
			}
			if (j != i) {
				array[j] = tmp;
			}
		}

	}

}
