package com.prudhvi.leetcode.february;

import java.util.Arrays;

public class Feb_14_2149_RearrangeArrayElementsBySign {

	public static void main(String[] args) {
		int[] nums = {3,1,-2,-5,2,-4};
		System.out.println(Arrays.toString(rearrangeArray(nums)));

	}
	/**
	 * Rearranges the elements in the input array such that positive integers
	 * occupy even indices, and negative integers occupy odd indices.
	 *
	 * @param nums The input array of integers.
	 * @return The rearranged array.
	 * 
	 * Time Complexity: O(N), where N is the length of the input array.
	 * Space Complexity: O(N), additional space is used for the rearranged array.
	 */
	public static int[] rearrangeArray(int[] nums) {
	    // Create an array to store the rearranged elements.
	    int[] rearrangedArray = new int[nums.length];
	    // Initialize indices for positive and negative elements.
	    int positiveIndex = 0;
	    int negativeIndex = 1;
	    // Iterate through the input array.
	    for (int i = 0; i < nums.length; i++) {
	        // If the current element is positive, place it at the even index.
	        if (nums[i] > 0) {
	            rearrangedArray[positiveIndex] = nums[i];
	            positiveIndex += 2;
	        } else {
	            // If the current element is negative, place it at the odd index.
	            rearrangedArray[negativeIndex] = nums[i];
	            negativeIndex += 2;
	        }
	    }

	    return rearrangedArray;
	}



}
