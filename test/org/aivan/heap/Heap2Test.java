package org.aivan.heap;

import java.util.Arrays;

import org.aivan.TimedTest;
import org.aivan.generators.DataGenerator;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Heap2Test extends HeapTest {

	@Test
	public void ___1_reset() {
		acumulatedDiff = 0;
		acumulatedSystem = 0;
	}

	@Test
	public void a1_stringSort() throws Exception {
		String[] arr = DataGenerator.generateRandomOrderedStringArray(SMALL_ARRAY_SIZE, 10);
		heapSort(arr, String.class, new Heap2<String>());
		arr = DataGenerator.generateRandomOrderedStringArray(MEDIUM_ARRAY_SIZE, 10);
		heapSort(arr, String.class, new Heap2<String>());
		arr = DataGenerator.generateRandomOrderedStringArray(LARGE_ARRAY_SIZE, 10);
		heapSort(arr, String.class, new Heap2<String>());
	}

	@Test
	public void a2_longSort() throws Exception {
		Long[] arr = DataGenerator.generateRandomLongObjArray(SMALL_ARRAY_SIZE);
		heapSort(arr, Long.class, new Heap2<Long>());
		arr = DataGenerator.generateRandomLongObjArray(MEDIUM_ARRAY_SIZE);
		heapSort(arr, Long.class, new Heap2<Long>());
		arr = DataGenerator.generateRandomLongObjArray(LARGE_ARRAY_SIZE);
		heapSort(arr, Long.class, new Heap2<Long>());
	}
}
