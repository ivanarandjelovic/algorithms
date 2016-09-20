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
	
	public static long[] generateDescendingOrderedLongArray(int length) {
		long[] result = new long[length];
		for (int i = 0; i < length; i++) {
			result[i] = length-i-1;
		}
		return result;
	}
	
	public static long[] generateRandomLongArray(int length) {
		long[] result = new long[length];
		for (int i = 0; i < length; i++) {
			result[i] = (long) (Math.random()+length);
		}
		return result;
	}
	
}
