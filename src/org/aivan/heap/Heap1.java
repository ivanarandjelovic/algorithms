package org.aivan.heap;

/**
 * Implements standard heap (smalles element on top).
 * 
 * @author aivan
 *
 */
public class Heap1<T extends Comparable<T>> extends Heap<T> {

	protected void bubbleDown(int i) {
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

}
