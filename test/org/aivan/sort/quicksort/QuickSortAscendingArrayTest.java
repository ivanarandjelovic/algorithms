package org.aivan.sort.quicksort;

import org.aivan.generators.DataGenerator;

public abstract class QuickSortAscendingArrayTest extends QuickSortTest {

	protected String[] generateStringArray(int arraySize) throws Exception {
		return DataGenerator.generateAscendingOrderedStringArray(arraySize, 10);
	}


	protected Long[] generateLongArray(int arraySize) {
		return DataGenerator.generateAscendingOrderedLongArray(arraySize);
	}

}
