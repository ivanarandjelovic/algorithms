package org.aivan.heap;

/**
 * An attempt to speed up and optimize Heap2
 * 
 * @author aivan
 *
 */
public class Heap3<T extends Comparable<T>> {

	T[] elements;
	int size = 0;

	public void buildHeap(T[] array) {
		this.elements = array;
		this.size = elements.length;
		for (int i = size / 2; i >= 0; i--) {
			bubbleDown(i);
		}
	}

	private void bubbleDown(int i) {
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

	public T pop() {
		if (this.size > 0) {
			T min = elements[0];
			this.size--;
			// Trick: size is already decremented, so following two lines use last
			// element
			elements[0] = elements[this.size];
			elements[this.size] = null;
			bubbleDown(0);
			return min;
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.size; i++) {
			result += "[" + i + "]:" + elements[i] + ",";
		}
		return result;
	}

}
