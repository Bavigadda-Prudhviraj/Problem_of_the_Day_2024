package com.prudhvi.leetcode.march;

import java.util.HashMap;
import java.util.Map;

public class Mar_08_3005_CountElementsWithMaximumFrequency {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 1, 4 };
		System.out.println(maxFrequencyElements(nums));

	}

	/**
	 * Finds the count of elements with the maximum frequency in the given array.
	 *
	 * @param nums The input array of integers.
	 * @return The count of elements with the maximum frequency.
	 *
	 * Time Complexity: O(N), where N is the length of the input array.
	 * Space Complexity: O(N), as the map stores the frequency of each unique element in the array.
	 */
	public static int maxFrequencyElements(int[] nums) {
	    // Map to store the frequency of each unique element in the array.
	    Map<Integer, Integer> map = new HashMap<>();
	    // Variable to track the maximum frequency encountered.
	    int maxFrequency = -1;

	    // Iterate through the array to count the frequency of each element.
	    for (int num : nums) {
	        map.put(num, map.getOrDefault(num, 0) + 1);
	        // Update the maximum frequency if the current frequency is greater.
	        maxFrequency = Math.max(map.get(num), maxFrequency);
	    }

	    // Variable to store the count of elements with the maximum frequency.
	    int maxFrequencyCount = 0;

	    // Iterate through the map to count elements with the maximum frequency.
	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        if (entry.getValue() == maxFrequency) {
	            maxFrequencyCount += entry.getValue();
	        }
	    }

	    // Return the count of elements with the maximum frequency.
	    return maxFrequencyCount;
	}

}
