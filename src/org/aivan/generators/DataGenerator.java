package org.aivan.generators;

/**
 * Utility class for generating all sorts of data (ordered, random, string,
 * numeric, etc.)
 * 
 * @author aivan
 *
 */
public class DataGenerator {

	/**
	 * Generate an array of long-s starting from 0 up to length-1, in an
	 * ascending ordered array
	 * 
	 * @param length
	 * @return
	 */
	public static long[] generateAscendingOrderedLongArray(int length) {
		long[] result = new long[length];
		for (int i = 0; i < length; i++) {
			result[i] = i;
		}
		return result;
	}

	/**
	 * Generate an array of long-s starting from length-1 to 0, in an descending
	 * ordered array
	 * 
	 * @param length
	 * @return
	 */
	public static long[] generateDescendingOrderedLongArray(int length) {
		long[] result = new long[length];
		for (int i = 0; i < length; i++) {
			result[i] = length - i - 1;
		}
		return result;
	}

	/**
	 * Generate an array of long-s with random values and in random order
	 * 
	 * @param length
	 * @return
	 */
	public static long[] generateRandomLongArray(int length) {
		long[] result = new long[length];
		for (int i = 0; i < length; i++) {
			result[i] = (long) (Math.random() + length);
		}
		return result;
	}

	/**
	 * Generate an array of long-s from 0 to length-1 in random order
	 * 
	 * @param length
	 * @return
	 */
	public static long[] generateRandomSequentialLongArray(int length) {
		long[] result = generateAscendingOrderedLongArray(length);
		shuffleArray(result);
		return result;
	}

	private static long[] shuffleArray(long[] result) {
		for (int i = 0; i < result.length; i++) {
			int swapIndex = (int) (Math.random() * result.length);
			long tmp = result[i];
			result[i] = result[swapIndex];
			result[swapIndex] = tmp;
		}
		return result;
	}

}
