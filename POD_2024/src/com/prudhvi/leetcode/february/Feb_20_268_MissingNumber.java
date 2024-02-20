package com.prudhvi.leetcode.february;

public class Feb_20_268_MissingNumber {

	public static void main(String[] args) {
		int[] nums = {3,0,1};
		System.out.println(missingNumber(nums));

	}

	/**
	 * Finds the missing number in an array of integers containing distinct elements
	 * from 0 to n (inclusive), where n is the length of the array.
	 *
	 * @param nums The input array of integers.
	 * @return The missing number.
	 *
	 * Time Complexity: O(N), where N is the length of the array.
	 * Space Complexity: O(1).
	 */
	public static int missingNumber(int[] nums) {
	    // Initialize XOR to include all elements from 0 to n.
	    int xor = 0;
	    for (int i = 1; i <= nums.length; i++)
	        xor ^= i;

	    // XOR the result with the array elements.
	    for (int i = 0; i < nums.length; i++)
	        xor ^= nums[i];

	    // The remaining value in XOR is the missing number.
	    return xor;
	}



}
