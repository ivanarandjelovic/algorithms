package org.aivan.heap;

/**
 * An attempt to speed up and optimize Heap1
 * 
 * @author aivan
 *
 */
public class Heap2<T extends Comparable<T>> {

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
		int doubleIndexAndOne = doubleIndex +1;
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

	public T pop() {
		if (this.size > 0) {
			T min = elements[0];
			this.size--;
			// Trick: size is already decremented, so following two lines use last element
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
