package org.aivan.heap;

/**
 * Implements standard heap (smalles element on top).
 * 
 * @author aivan
 *
 */
public class Heap1<T extends Comparable<T>> {

	T[] elements;
	int size = 0;
	int levels = 0;

	public void buildHeap(T[] array) {
		this.elements = array;

		this.size = elements.length;

		// System.out.println("start: " + this.toString());

		int tmp = 1;
		while (tmp <= this.size) {
			levels++;
			tmp *= 2;
		}
		// System.out.println("size=" + size + ", levels=" + levels);
		for (int i = size / 2; i >= 0; i--) {
			bubbleDown(i);
		}
		// System.out.println("Final=" + this.toString());

	}

	private void bubbleDown(int i) {
		// System.out.println(this.toString());
		// System.out.println("enering bubble down with i:" + i);
		if (i * 2 >= this.size) {
			// System.out.println("i is over the size: " + i);
			return;
		}
		if (elements[i].compareTo(elements[i * 2]) <= 0
		    && ((2 * i + 1) >= this.size || elements[i].compareTo(elements[2 * i + 1]) <= 0)) {
			// System.out.println("element at i is smaller, i: " + i);
			// All is OK, element is smaller than it's children
			return;
		} else if (elements[i * 2].compareTo(elements[i]) <= 0
		    && ((2 * i + 1) >= this.size || elements[i * 2].compareTo(elements[2 * i + 1]) <= 0)) {
			// Left element is smallest
			// System.out.println("element at i*2 is smaller, i: " + i);
			T tmp = elements[i];
			elements[i] = elements[i * 2];
			elements[i * 2] = tmp;
			bubbleDown(i * 2);
		} else {
			if ((2 * i + 1) < this.size) {
				// must be right element smallest (if it exists)
				// System.out.println("element at i*2+1 is smaller, i: " + i);
				T tmp = elements[i];
				elements[i] = elements[i * 2 + 1];
				elements[i * 2 + 1] = tmp;
				bubbleDown(i * 2 + 1);
			}
		}
	}

	public T pop() {
		if (this.size > 0) {
			// Minimum element is on the top
			T min = elements[0];

			elements[0] = elements[this.size - 1];
			elements[this.size - 1] = null;
			this.size--;
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
