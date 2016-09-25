package org.aivan.heap;

/**
 * An attempt to speed up and optimize Heap2
 * 
 * @author aivan
 *
 */
public class Heap4<T extends Comparable<T>> extends Heap<T> {

	protected void bubbleDown(int i) {
		int doubleIndex = i * 2 + 1;

		if (doubleIndex >= this.size) {
			return;
		}

		int doubleIndexAndOne = doubleIndex + 1;

		boolean leftSmaller = elements[i].compareTo(elements[doubleIndex]) > 0;
		boolean doubleIndexAndOneNotExists = doubleIndexAndOne >= this.size;
		T tmp;

		if (leftSmaller) {
			if (doubleIndexAndOneNotExists) {
				// no right child, left smaller, job done
				return;
			} else if (elements[doubleIndexAndOne].compareTo(elements[i]) > 0) {
				// right is larger
				tmp = elements[i];
				elements[i] = elements[doubleIndexAndOne];
				elements[doubleIndexAndOne] = tmp;
				bubbleDown(doubleIndexAndOne);
			}
		} else {
			if (doubleIndexAndOneNotExists) {
				// No right child, take left
				tmp = elements[i];
				elements[i] = elements[doubleIndex];
				elements[doubleIndex] = tmp;
				bubbleDown(doubleIndex);
			} else {
				// there is right child, which one is bigger?
				if (elements[doubleIndex].compareTo(elements[doubleIndexAndOne]) > 0) {
					// left again
					tmp = elements[i];
					elements[i] = elements[doubleIndex];
					elements[doubleIndex] = tmp;
					bubbleDown(doubleIndex);
				} else {
					tmp = elements[i];
					elements[i] = elements[doubleIndexAndOne];
					elements[doubleIndexAndOne] = tmp;
					bubbleDown(doubleIndexAndOne);
				}
			}
		}

	}

}
