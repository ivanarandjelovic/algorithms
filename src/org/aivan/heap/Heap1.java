package org.aivan.heap;

/**
 * Implements standard heap (smalles element on top).
 * 
 * @author aivan
 *
 */
public class Heap1<T extends Comparable<T>> extends Heap<T> {

	protected void bubbleDown(int i) {
		if (i * 2 + 1 >= this.size) {
			// This is a leaf node, no work needed
			return;
		}
		int leftChild = i * 2 + 1;
		int rightChild = i * 2 + 2;
		if (elements[i].compareTo(elements[leftChild]) > 0
		    && (rightChild >= this.size || elements[i].compareTo(elements[rightChild]) > 0)) {
			// children are smaller (or left is smaller and right does not exists)
			return;
		} else if (elements[leftChild].compareTo(elements[i]) > 0
		    && ((rightChild) >= this.size || elements[leftChild].compareTo(elements[rightChild]) > 0)) {
			// left is bigger (then right, or right does not exists)
			T tmp = elements[i];
			elements[i] = elements[leftChild];
			elements[leftChild] = tmp;
			bubbleDown(leftChild);
		} else {
			// right must be bigger (if exists)
			if (rightChild < this.size && elements[rightChild].compareTo(elements[i]) > 0) {
				T tmp = elements[i];
				elements[i] = elements[rightChild];
				elements[rightChild] = tmp;
				bubbleDown(rightChild);
			}
		}
	}

}
