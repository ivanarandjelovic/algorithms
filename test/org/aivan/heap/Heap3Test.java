package org.aivan.heap;

import org.aivan.sort.Sort;
import org.aivan.sort.SortRandomArraysTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Heap3Test extends SortRandomArraysTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Override
	protected
	Sort<String> getSortString() {
		return new Heap3<String>();
	}

	@Override
	protected
	Sort<Long> getSortLong() {
		return new Heap3<Long>();
	}
}
