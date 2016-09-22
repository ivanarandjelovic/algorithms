package org.aivan.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.aivan.TimedTest;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class HeapTest extends TimedTest {

	public static final Logger log = LogManager.getLogger(HeapTest.class);
	
	protected static <T extends Comparable<T>> void heapSort(T[] arr, Class<T> clazz, Heap<T> heap) throws Exception {
		log.debug("--------------------------------");
		
		int arraySize = arr.length;

		T[] systemSorted = Arrays.copyOf(arr, arraySize);
		@SuppressWarnings("unchecked")
		T[] heapSorted = (T[]) Array.newInstance(clazz, arraySize);

		StopWatch sw1 = new StopWatch();
		StopWatch sw2 = new StopWatch();

		sw1.start();
		Arrays.sort(systemSorted);
		sw1.stop();

		acumulatedSystem += sw1.getTime();
		log.debug("System sorted time for " + arraySize + " elements: " + sw1.getTime());

		sw2.start();
		heap.buildHeap(arr);
		int index = 0;
		while (heap.size > 0) {
			heapSorted[index++] = heap.pop();
		}
		sw2.stop();

		log.debug("Heap sorted time for " + arraySize + " elements: " + sw2.getTime());

		acumulatedDiff += (sw2.getTime() - sw1.getTime());

		Assert.assertTrue(Arrays.equals(systemSorted, heapSorted));
	}
	
}
