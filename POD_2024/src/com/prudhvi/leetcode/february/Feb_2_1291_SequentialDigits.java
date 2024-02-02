package com.prudhvi.leetcode.february;

import java.util.ArrayList;
import java.util.List;

public class Feb_2_1291_SequentialDigits {

	public static void main(String[] args) {
		int low = 1000, high = 13000;
		System.out.println(sequentialDigits(low, high));

	}
	/**
	 * Generates a list of sequential digits that fall within a specified range [low, high].
	 *
	 * @param low The lower bound of the range.
	 * @param high The upper bound of the range.
	 * @return List of sequential digits within the specified range.
	 *
	 * @TimeComplexity: O(1) - The function generates a pre-defined list of sequential digits,
	 *                   so the time complexity is constant.
	 *
	 * @SpaceComplexity: O(1) - The list is predefined and does not depend on the input size.
	 */
	public static List<Integer> sequentialDigits(int low, int high) {
	    // Pre-defined array containing all possible sequential digits.
	    int[] all = {
	        12, 23, 34, 45, 56, 67, 78, 89,
	        123, 234, 345, 456, 567, 678, 789,
	        1234, 2345, 3456, 4567, 5678, 6789,
	        12345, 23456, 34567, 45678, 56789,
	        123456, 234567, 345678, 456789,
	        1234567, 2345678, 3456789,
	        12345678, 23456789,
	        123456789
	    };

	    // Initialize a list to store sequential digits within the specified range.
	    List<Integer> list = new ArrayList<>();

	    // Iterate through the pre-defined array.
	    for (int i = 0; i < all.length; i++) {
	        // Skip elements that are less than the lower bound.
	        if (all[i] < low) continue;

	        // Break the loop if the current element exceeds the upper bound.
	        if (all[i] > high) break;

	        // Add the current element to the list.
	        list.add(all[i]);
	    }

	    // Return the list of sequential digits within the specified range.
	    return list;
	}


}
