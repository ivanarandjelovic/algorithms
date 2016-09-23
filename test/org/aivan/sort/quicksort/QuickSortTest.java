package org.aivan.sort.quicksort;

import java.util.Arrays;

import org.aivan.TimedTest;
import org.aivan.generators.DataGenerator;
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


	public void resetTimers() {
		sw1 = new StopWatch();
		sw2 = new StopWatch();
	}

	@Test
	public void a1_stringSort() throws Exception {
		sortOneArray(SMALL_ARRAY_SIZE);
		sortOneArray(MEDIUM_ARRAY_SIZE);
		sortOneArray(LARGE_ARRAY_SIZE);

	}

	private void sortOneArray(int arraySize) throws Exception {
		resetTimers();
		String[] arr = DataGenerator.generateRandomOrderedStringArray(arraySize, 10);

		String[] systemSorted = systemSort(arr);

		QuickSort<String> qsort = getQuickSort();
		sw2.start();
		qsort.sort(arr);
		sw2.stop();
		log.debug("Custom sorted time for " + arraySize + " elements: " + sw2.getTime());

		acumulatedDiff += (sw2.getTime() - sw1.getTime());
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
