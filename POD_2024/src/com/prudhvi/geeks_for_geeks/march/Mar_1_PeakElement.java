package com.prudhvi.geeks_for_geeks.march;

public class Mar_1_PeakElement {

	public static void main(String[] args) {
		int n = 3;
		int arr[] = { 1, 2, 3 };
		System.out.println(peakElement(arr, n));

	}

	/**
	 * Finds a peak element in the given array.
	 *
	 * @param arr The array of integers.
	 * @param n   The number of elements in the array.
	 * @return The index of a peak element.
	 *
	 * @TimeComplexity: O(log N), where N is the number of elements in the array.
	 * @SpaceComplexity: O(1).
	 */
	public static int peakElement(int[] arr, int n) {
	    int low = 0;
	    int high = arr.length - 1;

	    // Binary search to find a peak element.
	    while (low < high) {
	        int mid = low + (high - low) / 2;

	        // If the current element is less than the next element, search in the right half.
	        if (arr[mid] < arr[mid + 1]) {
	            low = mid + 1;
	        } else {
	            // If the current element is greater than or equal to the next element, search in the left half.
	            high = mid;
	        }
	    }

	    // At the end of the binary search, 'low' points to a peak element.
	    return low;
	}

}
