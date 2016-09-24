package org.aivan.sort.mergesort.asc;

import org.aivan.sort.Sort;
import org.aivan.sort.SortAscendingArrayTest;
import org.aivan.sort.mergesort.MergeSort;
import org.junit.Test;

/**
 * Merge sort lines pre-sorted data :)
 * 
 * @author aivan
 *
 */
public class MergeSortTest extends SortAscendingArrayTest {

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
