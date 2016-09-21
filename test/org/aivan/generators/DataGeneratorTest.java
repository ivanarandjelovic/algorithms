package org.aivan.generators;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class DataGeneratorTest {
	private static final int INT_ARRAY_LENGTH = 10;
	private static final int STRING_ARRAY_LENGTH = 10;
	private static final int STRING_ARRAY_LENGTH_LONG = 10000;

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
		Assert.assertEquals("Last element is length-1", INT_ARRAY_LENGTH - 1, longs[INT_ARRAY_LENGTH - 1]);
		Assert.assertEquals("There should be exactly length elements", INT_ARRAY_LENGTH, longs.length);

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
		Assert.assertEquals("There should be exactly length elements", INT_ARRAY_LENGTH, longs.length);

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
		Assert.assertEquals("There should be exactly length elements", INT_ARRAY_LENGTH, longs.length);
	}

	@Test
	public void shuffledArrayTest() {
		long[] longs = DataGenerator.generateRandomSequentialLongArray(INT_ARRAY_LENGTH);
		Assert.assertNotNull("Generated array must not be null", longs);
		Assert.assertEquals("There should be exactly length elements", INT_ARRAY_LENGTH, longs.length);

		long[] original = Arrays.copyOf(longs, longs.length);

		Arrays.sort(longs);
		for (int i = 0; i < INT_ARRAY_LENGTH; i++) {
			Assert.assertEquals("Ascending array of ints must contain elements equal to index after sorting", i,
					longs[i]);
		}

		Assert.assertFalse(
				"Array must not be equal to it self after soring (if this happens, then it's very, very unlikely, so re-run the test",
				Arrays.equals(original, longs));
		;
	}

	@Test
	public void orderedStringArrayTest() throws Exception {
		String[] strings = DataGenerator.generateAscendingOrderedStringArray(STRING_ARRAY_LENGTH, 3);
		Assert.assertNotNull(strings);
		Assert.assertEquals(STRING_ARRAY_LENGTH, strings.length);
		Assert.assertEquals("AAA", strings[0]);
		Assert.assertEquals("AAB", strings[1]);
		Assert.assertEquals("AAC", strings[2]);
		Assert.assertEquals("AAD", strings[3]);
		Assert.assertEquals("AAJ", strings[9]);
	}

	@Test
	public void orderedStringArrayTestLong() throws Exception {
		try {
			@SuppressWarnings("unused")
			String[] strings = DataGenerator.generateAscendingOrderedStringArray(STRING_ARRAY_LENGTH_LONG, 2);
		} catch (Exception e) {
			Assert.assertNotNull(e);
			return;
		}
		Assert.assertFalse("This test should throw an exception!", true);
	}

	@Test
	public void orderedStringArrayTestLongOk() throws Exception {
		String[] strings = DataGenerator.generateAscendingOrderedStringArray(STRING_ARRAY_LENGTH_LONG, 5);
		Assert.assertEquals("AAAAA", strings[0]);
		Assert.assertEquals("AAABA", strings[26]);
		Assert.assertEquals("AAABB", strings[27]);
	}
}
