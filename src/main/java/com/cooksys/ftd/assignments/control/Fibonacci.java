package com.cooksys.ftd.assignments.control;

import java.util.Arrays;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two
 * elements are `1`, and every other element is equal to the sum of its two
 * preceding elements. For example:
 * <p>
 * [1, 1] => [1, 1, 1 + 1] => [1, 1, 2] => [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] => ...etc
 */
public class Fibonacci {

	/**
	 * Calculates the value in the Fibonacci sequence at a given index. For example,
	 * `atIndex(0)` and `atIndex(1)` should return `1`, because the first two
	 * elements of the sequence are both `1`.
	 *
	 * @param i the index of the element to calculate
	 * @return the calculated element
	 * @throws IllegalArgumentException if the given index is less than zero
	 */
	public static int atIndex(int i) throws IllegalArgumentException {
//    	fib array to arrive at index
		if (i < 0) {
			throw new IllegalArgumentException("index is less than zero");	
		}
		
		int temp[] = new int[i+2];
		temp[0] = 1;
		temp[1] = 1;
		
		for(int j = 2; j <= i; j++) {
			temp[j] = temp[j-1] + temp[j-2];
		}
		
		return temp[i];


	}

	/**
	 * Calculates a slice of the fibonacci sequence, starting from a given start
	 * index (inclusive) and ending at a given end index (exclusive).
	 *
	 * @param start the starting index of the slice (inclusive)
	 * @param end   the ending index of the slice(exclusive)
	 * @return the calculated slice as an array of int elements
	 * @throws IllegalArgumentException if either the given start or end is
	 *                                  negative, or if the given end is less than
	 *                                  the given start
	 */
	public static int[] slice(int start, int end) throws IllegalArgumentException {
		if (end < start || end < 0 || start < 0) {
			throw new IllegalArgumentException(
					"either the given start or end is negative, or if the given end is less than the given start");
		}
		
		
		int tempSlice[] = new int[end - start];
		int arraySlice[]= fibonacci(end);
		
		for(int j = 0; j <= tempSlice.length; j++) {
			tempSlice[j] = arraySlice[start+j];
		}
		
		

		return tempSlice;
	}

	/**
	 * Calculates the beginning of the fibonacci sequence, up to a given count.
	 *
	 * @param count the number of elements to calculate
	 * @return the beginning of the fibonacci sequence, up to the given count, as an
	 *         array of int elements
	 * @throws IllegalArgumentException if the given count is negative
	 */
	public static int[] fibonacci(int count) throws IllegalArgumentException {
		if (count < 0) {
			throw new IllegalArgumentException();
		}

		
		if (count <= 1) {
			int temp[] = new int[count + 1];
			temp[0] = 0;
			temp[1] = 1;
			return temp;
		} else {
			int temp[] = new int[count+1];
			temp[0] = 0;
			temp[1] = 1;
			for(int i =2; i<= count; i++) {
				temp[i]= temp[i-1]+ temp[i-2];
			}
			return temp;
		}
		
		
	}
	public static void main(String[] args) {
		System.out.println(atIndex(39));
		System.out.println(Arrays.toString(fibonacci(31)));
		System.out.println(Arrays.toString(slice(2, 13)));
	}
}
