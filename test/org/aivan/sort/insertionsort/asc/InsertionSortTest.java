package org.aivan.sort.insertionsort.asc;

import org.aivan.sort.Sort;
import org.aivan.sort.SortAscendingArrayTest;
import org.aivan.sort.insertionsort.InsertionSort;
import org.junit.Test;

/**
 * Merge sort lines pre-sorted data :)
 * 
 * @author aivan
 *
 */
public class InsertionSortTest extends SortAscendingArrayTest {

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
