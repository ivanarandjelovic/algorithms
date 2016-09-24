package org.aivan.sort;

import org.aivan.generators.DataGenerator;

public abstract class SortRandomArraysTest extends SortTest {

	protected String[] generateStringArray(int arraySize) throws Exception {
		return DataGenerator.generateRandomOrderedStringArray(arraySize, 10);
	}


	protected Long[] generateLongArray(int arraySize) {
		return DataGenerator.generateRandomLongObjArray(arraySize);
	}

}
