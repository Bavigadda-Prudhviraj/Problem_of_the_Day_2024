package com.prudhvi.geeks_for_geeks.february;

public class Feb_29_SumOfBitDifferences {

	public static void main(String[] args) {
		int[] arr = { 1, 2 };
		int n = 2;
		System.out.println(sumBitDifferences(arr, n));

	}

	/**
	 * Calculates the sum of bit differences among all pairs of integers in the
	 * given array.
	 *
	 * @param arr The array of integers.
	 * @param n   The number of elements in the array.
	 * @return The sum of bit differences among all pairs of integers.
	 *
	 * @TimeComplexity: O(N), where N is the number of elements in the array.
	 * @SpaceComplexity: O(1).
	 */
	public static long sumBitDifferences(int[] arr, int n) {
		long sumOfBitDifferences = 0;
		// Iterate through each bit position (32 bits for integers).
		for (int i = 0; i < 32; i++) {
			long setBitCount = 0;
			long unSetBitCount = 0;

			// Count the number of set and unset bits at the current position.
			for (int num : arr) {
				if ((num & (1 << i)) > 0) {
					setBitCount++;
				} else {
					unSetBitCount++;
				}
			}

			// Update the sum of bit differences with the count at the current bit position.
			sumOfBitDifferences += (setBitCount * unSetBitCount * 2);
		}
		return sumOfBitDifferences;
	}

}
