package com.prudhvi.geeks_for_geeks.february;

import java.util.Arrays;

public class Feb_27_PlayWithOR {

	public static void main(String[] args) {
		int arr[] = {10, 11, 1, 2, 3};
		System.out.println(Arrays.toString(game_with_number(arr, 5)));

	}
	/**
	 * Performs a bitwise OR operation between adjacent elements of the array.
	 *
	 * @param arr The input array.
	 * @param n   The size of the array.
	 * @return The modified array after performing the bitwise OR operation between adjacent elements.
	 *
	 * Time Complexity: O(n), where n is the size of the array.
	 * Space Complexity: O(1).
	 */
	public static int[] game_with_number(int arr[], int n) {
	    // Iterate through the array and perform bitwise OR operation between adjacent elements.
	    for (int i = 0; i < n - 1; i++) {
	        arr[i] = (arr[i] | arr[i + 1]);
	    }
	    return arr;
	}


}
