package org.aivan.sort.insertionsort.random;

import org.aivan.sort.Sort;
import org.aivan.sort.SortRandomArraysTest;
import org.aivan.sort.insertionsort.InsertionSort;
import org.junit.Test;

public class InsertionSortTest extends SortRandomArraysTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	Sort<String> getSortString() {
		return new InsertionSort<String>();
	}

	@Override
	protected
	Sort<Long> getSortLong() {
		return new InsertionSort<Long>();
	}

	
}
