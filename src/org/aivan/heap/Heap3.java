package org.aivan.heap;

/**
 * An attempt to speed up and optimize Heap2
 * 
 * @author aivan
 *
 */
public class Heap3<T extends Comparable<T>> extends Heap<T> {

	protected void bubbleDown(int i) {
		int doubleIndex = i * 2;

		if (doubleIndex >= this.size) {
			return;
		}

		int doubleIndexAndOne = doubleIndex + 1;

		boolean leftLarger = elements[i].compareTo(elements[doubleIndex]) <= 0;
		boolean doubleIndexAndOneNotExists = doubleIndexAndOne >= this.size;
		T tmp;

		if (leftLarger) {
			boolean rightLarger = doubleIndexAndOneNotExists || (elements[i].compareTo(elements[doubleIndexAndOne]) <= 0);
			if (rightLarger) {
				return;
			} else {
				tmp = elements[i];
				elements[i] = elements[doubleIndexAndOne];
				elements[doubleIndexAndOne] = tmp;
				bubbleDown(doubleIndexAndOne);
			}
		} else {
			if (doubleIndexAndOneNotExists || elements[doubleIndex].compareTo(elements[doubleIndexAndOne]) <= 0) {
				// left smaller than right (both smaller then parrent)
				tmp = elements[i];
				elements[i] = elements[doubleIndex];
				elements[doubleIndex] = tmp;
				bubbleDown(doubleIndex);
			} else {
				// Right one smaller than left (and surely exists)
				tmp = elements[i];
				elements[i] = elements[doubleIndexAndOne];
				elements[doubleIndexAndOne] = tmp;
				bubbleDown(doubleIndexAndOne);
			}
		}

	}

}
