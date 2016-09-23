package org.aivan.sort.quicksort;

import org.aivan.sort.Sort;

public abstract class QuickSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] array) {
		qsort(array, 0, array.length - 1);
	}

	private void qsort(T[] array, int start, int end) {
		if (start >= end) {
			// End of recursion, one or zero elements remained
			return;
		}
		// Pick pivot element
		T pivot = pickPivot(array, start, end);

//		System.out.println("before (start, end = " + start + "," + end + "):");
//		for (int index = start; index <= end; index++) {
//			System.out.print(index + ": " + array[index] + ", ");
//		}
//		System.out.println();

		int left = start;
		int right = end;
		while (left <= right) {
			if (array[left].compareTo(pivot) < 0) {
				// Left smaller than pivot, advance left
				left++;
			} else if (array[right].compareTo(pivot) > 0) {
				// Right larger than pivor, advance right (to the left :) )
				right--;
			} else {
				// Left is larger, right is smaller, time to replace them:
				T tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
				left++;
				right--;
			}
		}
		
//		System.out.println("left,right = "+left+","+right);
//
//		System.out.println("after (left, right = " + left + "," + right + "):");
//		for (int index = start; index <= end; index++) {
//			System.out.print(index + ": " + array[index] + ", ");
//		}
//		System.out.println();

		// now recursively sort other parts:
		qsort(array, start, right);
		qsort(array, left , end);

//		if (array[left].compareTo(pivot) < 0) {
//			qsort(array, start, right);
//			qsort(array, left + 1, end);
//		} else {
//			qsort(array, start, right);
//			qsort(array, left , end);
//		}
	}

	protected abstract T pickPivot(T[] array, int start, int end);
}
