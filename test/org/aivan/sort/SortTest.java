package org.aivan.sort;

import java.util.Arrays;

import org.aivan.TimedTest;
import org.aivan.sort.Sort;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class SortTest extends TimedTest {

	public static final Logger log = LogManager.getLogger(SortTest.class);

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
	
	@Test
	public void a2_longSort() throws Exception {
		sortOneLongArray(SMALL_ARRAY_SIZE);
		sortOneLongArray(MEDIUM_ARRAY_SIZE);
		sortOneLongArray(LARGE_ARRAY_SIZE);

	}

	private void sortOneArray(int arraySize) throws Exception {
		resetTimers();
		String[] arr = generateStringArray(arraySize);

		String[] systemSorted = systemSort(arr);

		Sort<String> qsort = getSortString();
		sw2.start();
		qsort.sort(arr);
		sw2.stop();
		log.debug("Custom sorted time for " + arraySize + " elements: " + sw2.getTime());

		acumulatedDiff += (sw2.getTime() - sw1.getTime());
		Assert.assertTrue(Arrays.equals(systemSorted, arr));
	}

	protected abstract String[] generateStringArray(int arraySize) throws Exception;


	protected abstract Long[] generateLongArray(int arraySize);
	
	
	private void sortOneLongArray(int arraySize) throws Exception {
		resetTimers();
		Long[] arr = generateLongArray(arraySize);

		Long[] systemSorted = systemSort(arr);

	  Sort<Long> qsort = getSortLong();
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
	
	private Long[] systemSort(Long[] arr) {
		Long[] systemSorted = Arrays.copyOf(arr, arr.length);

		sw1.start();
		Arrays.sort(systemSorted);
		sw1.stop();

		acumulatedSystem += sw1.getTime();
		log.debug("System sorted time for " + arr.length + " elements: " + sw1.getTime());

		return systemSorted;
	}

	protected abstract Sort<String> getSortString();
	protected abstract Sort<Long> getSortLong();



}
