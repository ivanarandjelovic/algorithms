package org.aivan.heap;

import java.util.Arrays;

import org.aivan.generators.DataGenerator;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Heap1Test {

	protected static long acumulatedDiff = 0;

	@Test
	public void z99_reportDiff() throws Exception {
		System.out.println("===================================");
		System.out.println("Accumulated diff = " + acumulatedDiff);
		System.out.println("===================================");
	}

	private static final int SMALL_ARRAY_SIZE = 20000;
	private static final int MEDIUM_ARRAY_SIZE = 200000;
	private static final int LARGE_ARRAY_SIZE = 2000000;
	private static final int HUGE_ARRAY_SIZE = 20000000;

	protected static final Logger log = LogManager.getLogger(Heap2Test.class);

	@Test
	public void a1_heapTestSmallString() throws Exception {
		heapStringSort(SMALL_ARRAY_SIZE);
	}

	@Test
	public void a2_heapTestMediumString() throws Exception {
		heapStringSort(MEDIUM_ARRAY_SIZE);
	}

	@Test
	public void a3_heapTestLargeString() throws Exception {
		heapStringSort(LARGE_ARRAY_SIZE);
	}

	// @Test
	// public void a4_heapTestHugeString() throws Exception {
	// heapStringSort(HUGE_ARRAY_SIZE);
	// }

	private void heapStringSort(int arraySize) throws Exception {
		System.out.println("--------------------------------");
		String[] arr = DataGenerator.generateRandomOrderedStringArray(arraySize, 10);

		String[] systemSorted = Arrays.copyOf(arr, arr.length);
		String[] heapSorted = new String[arr.length];

		StopWatch sw1 = new StopWatch();
		StopWatch sw2 = new StopWatch();

		sw1.start();
		Arrays.sort(systemSorted);
		sw1.stop();

		System.out.println("System sorted time for " + arraySize + " elements: " + sw1.getTime());

		sw2.start();
		Heap1<String> heap = new Heap1<String>();
		heap.buildHeap(arr);
		int index = 0;
		while (heap.size > 0) {
			heapSorted[index++] = heap.pop();
		}
		sw2.stop();

		System.out.println("Heap1 sorted time for " + arraySize + " elements: " + sw2.getTime());

		acumulatedDiff += (sw2.getTime() - sw1.getTime());

		Assert.assertTrue(Arrays.equals(systemSorted, heapSorted));
	}

	@Test
	public void b1_heapTestSmallArrayLong() throws Exception {
		heapLongSort(SMALL_ARRAY_SIZE);
	}

	@Test
	public void b2_heapTestMediumArrayLong() throws Exception {
		heapLongSort(MEDIUM_ARRAY_SIZE);
	}

	@Test
	public void b3_heapTestLargeLong() throws Exception {
		heapLongSort(LARGE_ARRAY_SIZE);
	}

	// @Test
	// public void b4_heapTestHugeArrayLong() throws Exception {
	// heapLongSort(HUGE_ARRAY_SIZE);
	// }

	private void heapLongSort(int arraySize) {
		System.out.println("--------------------------------");
		Long[] arr = DataGenerator.generateRandomLongObjArray(arraySize);

		Long[] systemSorted = Arrays.copyOf(arr, arr.length);
		Long[] heapSorted = new Long[arr.length];

		StopWatch sw1 = new StopWatch();
		StopWatch sw2 = new StopWatch();

		sw1.start();
		Arrays.sort(systemSorted);
		sw1.stop();

		System.out.println("System sorted time for " + arraySize + " elements: " + sw1.getTime());

		sw2.start();
		Heap1<Long> heap = new Heap1<Long>();
		heap.buildHeap(arr);
		int index = 0;
		while (heap.size > 0) {
			heapSorted[index++] = heap.pop();
		}
		sw2.stop();

		System.out.println("Heap1 sorted time for " + arraySize + " elements: " + sw2.getTime());

		acumulatedDiff += (sw2.getTime() - sw1.getTime());

		Assert.assertTrue(Arrays.equals(systemSorted, heapSorted));
	}

}
