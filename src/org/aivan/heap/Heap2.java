package org.aivan.heap;

/**
 * An attempt to speed up and optimize Heap1
 * 
 * @author aivan
 *
 */
public class Heap2<T extends Comparable<T>> extends Heap<T> {

	protected void bubbleDown(int i) {
		int doubleIndex = i * 2;
		int doubleIndexAndOne = doubleIndex + 1;
		if (doubleIndex >= this.size) {
			return;
		}
		if (elements[i].compareTo(elements[doubleIndex]) <= 0
		    && (doubleIndexAndOne >= this.size || elements[i].compareTo(elements[doubleIndexAndOne]) <= 0)) {
			return;
		} else if (elements[doubleIndex].compareTo(elements[i]) <= 0
		    && (doubleIndexAndOne >= this.size || elements[doubleIndex].compareTo(elements[doubleIndexAndOne]) <= 0)) {
			T tmp = elements[i];
			elements[i] = elements[doubleIndex];
			elements[doubleIndex] = tmp;
			bubbleDown(doubleIndex);
		} else {
			if (doubleIndexAndOne < this.size) {
				T tmp = elements[i];
				elements[i] = elements[doubleIndexAndOne];
				elements[doubleIndexAndOne] = tmp;
				bubbleDown(doubleIndexAndOne);
			}
		}
	}

}
