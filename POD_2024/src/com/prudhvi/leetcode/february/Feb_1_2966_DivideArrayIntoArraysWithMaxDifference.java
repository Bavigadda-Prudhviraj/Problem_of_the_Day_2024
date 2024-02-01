package com.prudhvi.leetcode.february;

import java.util.Arrays;
/*
You are given an integer array nums of size n and a positive integer k.
Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

 

Example 1:
	Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
		Output: [[1,1,3],[3,4,5],[7,8,9]]
		Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
		The difference between any two elements in each array is less than or equal to 2.
		Note that the order of elements is not important.
 */
public class Feb_1_2966_DivideArrayIntoArraysWithMaxDifference {

	public static void main(String[] args) {
		int[] nums = {1,3,4,8,7,9,3,5,1};
		int k = 2;
		System.out.println(Arrays.deepToString(divideArray(nums, k)));
		

	}
	/**
	 * Divides an array into subarrays of size 3, ensuring that the difference between the maximum
	 * and minimum elements in each subarray is less than or equal to a given threshold (k).
	 *
	 * @param nums The input array to be divided.
	 * @param k The threshold for the difference between the maximum and minimum elements.
	 * @return 2D array containing subarrays, or an empty array if the conditions cannot be met.
	 *
	 * @TimeComplexity: O(n log n), where n is the length of the input array.
	 * - Sorting the array takes O(n log n) time.
	 *
	 * @SpaceComplexity: O(n/3) = O(n), where n is the length of the input array.
	 * - The dividedArrays 2D array has a size proportional to the length of the input array.
	 */
	public static int[][] divideArray(int[] nums, int k) {
	    // Sort the input array in ascending order.
	    Arrays.sort(nums);
	    // Calculate the number of subarrays based on the input array length.
	    int numSubarrays = nums.length / 3;
	    // Initialize a 2D array to store the divided subarrays.
	    int[][] dividedArrays = new int[numSubarrays][3];
	    // Index to keep track of the position in the dividedArrays array.
	    int index = 0;

	    // Iterate through the sorted array in steps of 3.
	    for (int i = 2; i < nums.length; i = i + 3) {
	        // Check if the difference between the maximum and minimum elements in the subarray is greater than k.
	        if (nums[i] - nums[i - 2] > k) 
	            // If the condition is not met, return an empty array.
	            return new int[][] {};
	        // Create a subarray of size 3 and store it in the dividedArrays array.
	        int[] subArray = {nums[i - 2], nums[i - 1], nums[i]};
	        dividedArrays[index++] = subArray;
	    }
	    // Return the 2D array containing the divided subarrays.
	    return dividedArrays;
	}


}
