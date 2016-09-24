package org.aivan.sort.mergesort;

import org.aivan.sort.Sort;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

	Object[] mergeArea;

	@Override
	public void sort(T[] array) {
		mergeArea = new Object[array.length];
		msort(array, 0, array.length - 1);
		mergeArea = null;
	}

	@SuppressWarnings("unchecked")
	protected void msort(T[] array, int start, int end) {

		if (start >= end) {
			// we are done here
			return;
		} else if (start == end - 1) {
			// Special case for two elements
			if (array[start].compareTo(array[end]) > 0) {
				// Swap them:
				T tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
			}
			return;
		}

		int middle = (start + end) / 2;

		msort(array, start, middle);
		msort(array, middle + 1, end);

//		System.out.println("start,end: " + start + ", " + end + " / middle = " + middle);
//
//		System.out.print("Before merge: ");
//		for (int i = start; i <= end; i++) {
//			System.out.print(array[i] + ", ");
//		}
//		System.out.println();

		// Now merge two halves;
		int left = start;
		int right = middle + 1;
		int mergePointerIndex = start;
		while (left <= middle || !(right > end)) {
			if (left <= middle && (right > end || array[left].compareTo(array[right]) < 0)) {
				mergeArea[mergePointerIndex++] = array[left];
				left++;
			} else {
				mergeArea[mergePointerIndex++] = array[right];
				right++;
			}
		}

		// copy merge area to main array:
		for (int i = start; i <= end; i++) {
			array[i] = (T) mergeArea[i];
		}

//		System.out.print("After merge: ");
//		for (int i = start; i <= end; i++) {
//			System.out.print(array[i] + ", ");
//		}
//		System.out.println();

	}

}
