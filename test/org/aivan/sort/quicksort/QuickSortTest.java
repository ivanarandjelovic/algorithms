package org.aivan.sort.quicksort;

import java.util.Arrays;

import org.aivan.TimedTest;
import org.aivan.generators.DataGenerator;
import org.aivan.heap.HeapTest;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class QuickSortTest extends TimedTest {

	public static final Logger log = LogManager.getLogger(QuickSortTest.class);

	StopWatch sw1 = new StopWatch();
	StopWatch sw2 = new StopWatch();

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Before
	public void resetTimers() {
		sw1 = new StopWatch();
		sw2 = new StopWatch();
	}

	@Test
	public void a1_stringSort() throws Exception {
		String[] arr = DataGenerator.generateRandomOrderedStringArray(SMALL_ARRAY_SIZE, 10);

		String[] systemSorted = systemSort(arr);

		QuickSort<String> qsort = getQuickSort();
		qsort.sort(arr);


//		int index = 0;
//		for (String s : systemSorted) {
//			System.out.print(index++ + ": " + s + ", ");
//		}
//		System.out.println();

//		index = 0;
//		for (String s : arr) {
//			System.out.print(index++ + ": " + s + ", ");
//		}
//		System.out.println();

		Assert.assertTrue(Arrays.equals(systemSorted, arr));

	}

	private String[] systemSort(String[] arr) {
		String[] systemSorted = Arrays.copyOf(arr, arr.length);

		sw1.start();
		Arrays.sort(systemSorted);
		sw1.stop();

		acumulatedSystem += sw1.getTime();
		log.debug("System sorted time for " + arr.length + " elements: " + sw1.getTime());

		return systemSorted;
	}

	abstract QuickSort<String> getQuickSort();

	// @Test
	// public void a2_longSort() throws Exception {
	// Long[] arr = DataGenerator.generateRandomLongObjArray(SMALL_ARRAY_SIZE);
	// heapSort(arr, Long.class, new Heap1<Long>());
	// arr = DataGenerator.generateRandomLongObjArray(MEDIUM_ARRAY_SIZE);
	// heapSort(arr, Long.class, new Heap1<Long>());
	// arr = DataGenerator.generateRandomLongObjArray(LARGE_ARRAY_SIZE);
	// heapSort(arr, Long.class, new Heap1<Long>());
	// }

}
