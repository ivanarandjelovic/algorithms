package org.aivan.heap;

import org.aivan.generators.DataGenerator;
import org.junit.Test;

public class HeapTest1 {

	@Test
	public void heapTestString() throws Exception {
		String[] arr = DataGenerator.generateRandomOrderedStringArray(15, 10);
		Heap1<String> heap1 = new Heap1<String>();
		heap1.buildHeap(arr);
	}
	
	@Test
	public void heapTestLong() throws Exception {
		Long[] arr = DataGenerator.generateRandomLongObjArray(17);
		Heap1<Long> heap1 = new Heap1<Long>();
		heap1.buildHeap(arr);
	}
}
