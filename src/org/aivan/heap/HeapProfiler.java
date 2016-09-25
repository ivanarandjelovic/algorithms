package org.aivan.heap;

/**
 * Implementation suitable for profiling (with cheap tools :) )
 * 
 * @author aivan
 *
 */
public class HeapProfiler<T extends Comparable<T>> extends Heap<T> {

	protected void bubbleDown(int i) {
		int doubleIndex = getDoubleIndex(i);

		if (doesRightChildNotExists(doubleIndex)) {
			return;
		}

		int doubleIndexAndOne = doubleIndex + 1;
		int bubbleIndex = -1;
		
		boolean leftSmaller = isLargerElement(i, doubleIndex);
		boolean doubleIndexAndOneNotExists = doesRightChildNotExists(doubleIndexAndOne);

		if (leftSmaller) {
			bubbleIndex = leftIsSmaller(i, doubleIndexAndOne, doubleIndexAndOneNotExists);
		} else {
			bubbleIndex = rightIsSmaller(i, doubleIndex, doubleIndexAndOne, doubleIndexAndOneNotExists);
		}
		
		if(bubbleIndex>=0) {
			bubbleDown(bubbleIndex);
		}

	}

	private int rightIsSmaller(int i, int doubleIndex, int doubleIndexAndOne, boolean doubleIndexAndOneNotExists) {
		if (doubleIndexAndOneNotExists) {
			// No right child, take left
			swap(i, doubleIndex);
			return doubleIndex;
		} else {
			// there is right child, which one is bigger?
			if (isLargerElement(doubleIndex, doubleIndexAndOne)) {
				swap(i, doubleIndex);
				return doubleIndex;
			} else {
				swap(i, doubleIndexAndOne);
				return doubleIndexAndOne;
			}
		}
	}

	private void swap(int i, int doubleIndex) {
		T tmp;
		tmp = elements[i];
		elements[i] = elements[doubleIndex];
		elements[doubleIndex] = tmp;
	}

	private int leftIsSmaller(int i, int doubleIndexAndOne, boolean doubleIndexAndOneNotExists) {
		if (doubleIndexAndOneNotExists) {
			// no right child, left smaller, job done
			return -1;
		} else if (isLargerElement(doubleIndexAndOne, i)) {
			swap(i, doubleIndexAndOne);
			return doubleIndexAndOne;
		}
		return -1;
	}

	private boolean doesRightChildNotExists(int doubleIndexAndOne) {
		return doubleIndexAndOne >= this.size;
	}

	private int getDoubleIndex(int i) {
		return i * 2 + 1;
	}

	private boolean isLargerElement(int i, int doubleIndex) {
		return elements[i].compareTo(elements[doubleIndex]) > 0;
	}

}
