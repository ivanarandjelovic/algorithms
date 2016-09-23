package org.aivan.sort.quicksort;

import org.aivan.generators.DataGenerator;

public abstract class QuickSortRandomArraysTest extends QuickSortTest {

	protected String[] generateStringArray(int arraySize) throws Exception {
		return DataGenerator.generateRandomOrderedStringArray(arraySize, 10);
	}


	protected Long[] generateLongArray(int arraySize) {
		return DataGenerator.generateRandomLongObjArray(arraySize);
	}

}
