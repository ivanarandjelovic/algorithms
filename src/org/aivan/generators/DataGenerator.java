package org.aivan.generators;

import java.util.Random;

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

	private static String[] shuffleArray(String[] result) {
		for (int i = 0; i < result.length; i++) {
			int swapIndex = (int) (Math.random() * result.length);
			String tmp = result[i];
			result[i] = result[swapIndex];
			result[swapIndex] = tmp;
		}
		return result;
	}

	/**
	 * 
	 * @param arrayLength
	 *            how long the array should be
	 * @param stringLength
	 *            how long the strings should be
	 * @return
	 * @throws Exception
	 */
	public static String[] generateAscendingOrderedStringArray(int arrayLength, int stringLength) throws Exception {

		String[] result = new String[arrayLength];

		StringBuffer currentStringBuffer = initStringBuffer(stringLength);

		for (int i = 0; i < arrayLength; i++) {
			result[i] = currentStringBuffer.toString();
			incrementString(currentStringBuffer);
		}
		return result;
	}

	/**
	 * Initialize StringBuffer with "A"'s
	 * 
	 * @param stringLength
	 * @return
	 */
	private static StringBuffer initStringBuffer(int stringLength) {
		StringBuffer currentStringBuffer = new StringBuffer(stringLength);
		for (int i = 0; i < stringLength; i++) {
			currentStringBuffer.append('A');
		}
		return currentStringBuffer;
	}

	/**
	 * Increment string by increasing last possible character
	 * 
	 * @param startString
	 * @throws Exception
	 */
	private static void incrementString(StringBuffer startString) throws Exception {
		incrementStringFromPosition(startString, 0);
	}

	private static void incrementStringFromPosition(StringBuffer stringBuffer, int pos) throws Exception {
		if (pos == stringBuffer.length()) {
			throw new Exception("Could not increment string: " + stringBuffer.toString());
		}
		int index = stringBuffer.length() - 1 - pos;
		char c = stringBuffer.charAt(index);
		if (index == 0 && c == 'Z')
			throw new Exception("Could not increment string: " + stringBuffer.toString());
		if (c != 'Z') {
			stringBuffer.setCharAt(index, (char) (c + 1));
		} else {
			stringBuffer.setCharAt(index, 'A');
			incrementStringFromPosition(stringBuffer, pos + 1);
		}
	}

	/**
	 * Generated descending ordered string array
	 * 
	 * @param arrayLength
	 * @param stringLength
	 * @return
	 * @throws Exception
	 */
	public static String[] generateDescendingOrderedStringArray(int arrayLength, int stringLength) throws Exception {
		String[] result = generateAscendingOrderedStringArray(arrayLength, stringLength);
		for (int i = 0; i < result.length / 2; i++) {
			String tmp = result[i];
			result[i] = result[result.length - 1 - i];
			result[result.length - 1 - i] = tmp;
		}
		return result;
	}

	public static String[] generateRandomOrderedStringArray(int arrayLength, int stringLength) throws Exception {
		String[] result = generateAscendingOrderedStringArray(arrayLength, stringLength);
		shuffleArray(result);
		return result;
	}

	public static String[] generateRandomOrderedRandomLengthStringArray(int arrayLength, int maximumLength)
			throws Exception {
		String[] result = new String[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			result[i] = generateRandStringMaxLen(maximumLength);
		}
		return result;
	}

	static Random random = new Random();

	private static String generateRandStringMaxLen(int maximumLength) {
		int len = random.nextInt(maximumLength + 1);
		StringBuffer sb = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			sb.append((char) ('A' + random.nextInt(26)));
		}
		return sb.toString();
	}

}
