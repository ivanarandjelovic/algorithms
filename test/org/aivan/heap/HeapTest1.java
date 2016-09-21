package org.aivan.heap;

import org.aivan.generators.DataGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class HeapTest1 {

	protected static final Logger log = LogManager.getLogger(HeapTest1.class);

	@Test
	public void heapTestString() throws Exception {
		log.debug("starting");
		String[] arr = DataGenerator.generateRandomOrderedStringArray(15, 10);
		Heap1<String> heap1 = new Heap1<String>();
		heap1.buildHeap(arr);
	}

	@Test
	public void heapTestLong() throws Exception {
		log.debug("starting");
		Long[] arr = DataGenerator.generateRandomLongObjArray(17);
		Heap1<Long> heap1 = new Heap1<Long>();
		heap1.buildHeap(arr);
	}
}
