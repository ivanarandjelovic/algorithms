package org.aivan.sort;

import org.aivan.generators.DataGenerator;

public abstract class SortAscendingArrayTest extends SortTest {

	protected String[] generateStringArray(int arraySize) throws Exception {
		return DataGenerator.generateAscendingOrderedStringArray(arraySize, 10);
	}


	protected Long[] generateLongArray(int arraySize) {
		return DataGenerator.generateAscendingOrderedLongArray(arraySize);
	}

}
