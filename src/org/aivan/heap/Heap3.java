package org.aivan.heap;

/**
 * An attempt to speed up and optimize Heap2
 * 
 * @author aivan
 *
 */
public class Heap3<T extends Comparable<T>> extends Heap<T> {

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
			boolean rightSmaller = doubleIndexAndOneNotExists || (elements[i].compareTo(elements[doubleIndexAndOne]) > 0);
			if (rightSmaller) {
				return;
			} else if(!doubleIndexAndOneNotExists) {
				tmp = elements[i];
				elements[i] = elements[doubleIndexAndOne];
				elements[doubleIndexAndOne] = tmp;
				bubbleDown(doubleIndexAndOne);
			}
		} else {
			if (doubleIndexAndOneNotExists || elements[doubleIndex].compareTo(elements[doubleIndexAndOne]) > 0) {
				// left larger than right (both larger then parent)
				tmp = elements[i];
				elements[i] = elements[doubleIndex];
				elements[doubleIndex] = tmp;
				bubbleDown(doubleIndex);
			} else if (!doubleIndexAndOneNotExists){
				// Right one smaller than left 
				tmp = elements[i];
				elements[i] = elements[doubleIndexAndOne];
				elements[doubleIndexAndOne] = tmp;
				bubbleDown(doubleIndexAndOne);
			}
		}

	}

}
