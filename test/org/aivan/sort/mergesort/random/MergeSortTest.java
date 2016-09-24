package org.aivan.sort.mergesort.random;

import org.aivan.sort.Sort;
import org.aivan.sort.SortRandomArraysTest;
import org.aivan.sort.mergesort.MergeSort;
import org.junit.Test;

public class MergeSortTest extends SortRandomArraysTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	Sort<String> getSortString() {
		return new MergeSort<String>();
	}

	@Override
	protected
	Sort<Long> getSortLong() {
		return new MergeSort<Long>();
	}

	
}
