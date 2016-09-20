package org.aivan.generators;

import org.junit.Assert;
import org.junit.Test;

public class DataGeneratorTest {
	private static final int INT_ARRAY_LENGTH = 10;

	@Test
	public void orderedLongLengthZeroTest() {
		long[] longs = DataGenerator.generateAscendingOrderedLongArray(0);
		Assert.assertNotNull("Generated array must not be null", longs);
		Assert.assertEquals(longs.length, 0);
	}

	@Test
	public void orderedLongTest() {
		long[] longs = DataGenerator.generateAscendingOrderedLongArray(INT_ARRAY_LENGTH);
		Assert.assertNotNull("Generated array must not be null", longs);
		for (int i = 0; i < INT_ARRAY_LENGTH; i++) {
			Assert.assertEquals("Ascending array of ints must contain elements equal to index", i, longs[i]);
		}
		Assert.assertEquals("First element is 0", longs[0], 0);
		Assert.assertEquals("Last element is length-1", longs[INT_ARRAY_LENGTH - 1], INT_ARRAY_LENGTH - 1);
		Assert.assertEquals("There should be exactly length elements", longs.length, INT_ARRAY_LENGTH);

	}

	@Test
	public void orderedLongDescendingLengthZeroTest() {
		long[] longs = DataGenerator.generateDescendingOrderedLongArray(0);
		Assert.assertNotNull("Generated array must not be null", longs);
		Assert.assertEquals(longs.length, 0);
	}

	@Test
	public void orderedLongDescendingTest() {
		long[] longs = DataGenerator.generateDescendingOrderedLongArray(INT_ARRAY_LENGTH);
		Assert.assertNotNull("Generated array must not be null", longs);
		for (int i = 0; i < INT_ARRAY_LENGTH; i++) {
			Assert.assertEquals("Ascending array of ints must contain elements equal to index",
					INT_ARRAY_LENGTH - i - 1, longs[i]);
		}
		Assert.assertEquals("First element is length-1", longs[0], INT_ARRAY_LENGTH - 1);
		Assert.assertEquals("Last element is 0", longs[INT_ARRAY_LENGTH - 1], 0);
		Assert.assertEquals("There should be exactly length elements", longs.length, INT_ARRAY_LENGTH);

	}

	@Test
	public void randomLongLengthZeroTest() {
		long[] longs = DataGenerator.generateRandomLongArray(0);
		Assert.assertNotNull("Generated array must not be null", longs);
		Assert.assertEquals(longs.length, 0);
	}

	@Test
	public void randomLongTest() {
		long[] longs = DataGenerator.generateRandomLongArray(INT_ARRAY_LENGTH);
		Assert.assertNotNull("Generated array must not be null", longs);
		Assert.assertEquals("There should be exactly length elements", longs.length, INT_ARRAY_LENGTH);
	}
}
