package org.aivan.heap;

import org.aivan.sort.Sort;

public abstract class Heap<T extends Comparable<T>> implements Sort<T> {

	protected T[] elements;
	protected int size = 0;
	protected int levels = 0;

	public T pop() {
		if (this.size > 0) {
			// Maximum element is on the top
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

	protected abstract void bubbleDown(int i);

	@Override
	public String toString() {
		String result = "";
	
		for (int i = 0; i < this.size; i++) {
			result += "[" + i + "]:" + elements[i] + ",";
		}
		return result;
	}

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
		for (int i = size / 2 - 1; i >= 0; i--) {
			bubbleDown(i);
		}
		// System.out.println("Final=" + this.toString());
	
	}
	
	@Override
	public void sort(T[] array) {
		this.buildHeap(array);
		for (int i = array.length - 1; i > 0; i--) {
			// Root is biggest element in the remaining heap, take it out and put it
			// at the end
			T tmp = pop();
			array[i] = tmp;
		}
		// DONE :) !
	}

}
