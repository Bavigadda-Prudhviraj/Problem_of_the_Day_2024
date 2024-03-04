package com.prudhvi.geeks_for_geeks.march;

import java.util.Arrays;

public class Mar_04_SwapTheArrayElements {

	public static void main(String[] args) {
		int n = 5;
		int arr[] = { 1, 2, 3, 4, 5 };
		swapElements(arr, n);
		System.out.println(Arrays.toString(arr));

	}

	/**
	 * Swaps every pair of elements in the array starting from index 0.
	 *
	 * @param arr The input array of integers.
	 * @param n   The size of the array.
	 *
	 * @TimeComplexity: O(N), where N is the size of the array.
	 * @SpaceComplexity: O(1).
	 */
	public static void swapElements(int[] arr, int n) {
	    for (int i = 0; i < n - 2; i++) {
	        // Swap every pair of elements in the array.
	        int temp = arr[i];
	        arr[i] = arr[i + 2];
	        arr[i + 2] = temp;
	    }
	}

}
