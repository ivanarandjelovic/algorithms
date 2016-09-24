package org.aivan.sort.mergesort;

import org.aivan.TimedTest;
import org.aivan.generators.DataGenerator;
import org.aivan.sort.Sort;
import org.junit.Test;

public class SimpleTest extends TimedTest {

	@Test
	public void testSort() {
		
		//So, we learn that ordered data (asc or desc) causes qsort to go n^2 in recursion calls, and 
		// it throws StackOverflow!
		
		//Long[] x = DataGenerator.generateDescendingOrderedLongArray(3000);
		//Long[] x = DataGenerator.generateAscendingOrderedLongArray(SMALL_ARRAY_SIZE);
		Long[] x = DataGenerator.generateRandomLongObjArray(7);
		Sort<Long> sort = new MergeSort<Long>();
		sort.sort(x);
		for(Long l: x) {
			System.out.println(l);
		}
	}
}
