package org.aivan.sort.quicksort;

import java.util.Random;

public abstract class QuickSortWithRandomization<T extends Comparable<T>> extends QuickSort<T> {

	@Override
	public void sort(T[] array) {
		randomize(array);
		super.qsort(array, 0, array.length - 1, 0);
	}

	private void randomize(T[] array) {
		Random r = new Random();
		int len = array.length;
		for(int i=0;i<len/2;i+=2) {
			int newIndex = r.nextInt(len);
			T tmp = array[i];
			array[i] = array[newIndex];
			array[newIndex]  =tmp;
		}
		
	}

	
}
