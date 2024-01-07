package com.prudhvi.leetcode.january;
import java.util.HashMap;
/*
Given an integer array nums, return the number of all the arithmetic subsequences of nums.
A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
	For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
	For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
	A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
The test cases are generated so that the answer fits in 32-bit integer.
Example 1:
	Input: nums = [2,4,6,8,10]
	Output: 7
	Explanation: All arithmetic subsequence slices are:
				[2,4,6]
				[4,6,8]
				[6,8,10]
				[2,4,6,8]
				[4,6,8,10]
				[2,4,6,8,10]
				[2,6,10]
 */
public class Jan_7_446_Arithmetic_Slices_II_Subsequence {

	public static void main(String[] args) {
		int[] nums = {2,4,6,8,10};
		System.out.println(numberOfArithmeticSlices(nums));

	}

	public static int numberOfArithmeticSlices(int[] nums) {
        int arithmeticSlices = 0;
        // Use an array of HashMaps to store the differences and their frequencies for each index
        HashMap<Integer, Integer>[] diffFreqArr = new HashMap[nums.length];
        // Initialize each HashMap
        for (int i = 0; i < nums.length; i++) 
            diffFreqArr[i] = new HashMap<>();
        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // Use long to prevent overflow
                long diff = (long) nums[i] - (long) nums[j];
                // Check for potential overflow
                if (diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE)
                    continue;
                // Retrieve frequencies from HashMaps
                int diffJFreq = diffFreqArr[j].getOrDefault((int) diff, 0);
                int diffIFreq = diffFreqArr[i].getOrDefault((int) diff, 0);
                // Update arithmeticSlices count and HashMaps
                arithmeticSlices += diffJFreq;
                diffFreqArr[i].put((int) diff, diffIFreq + diffJFreq + 1);
            }
        }

        return arithmeticSlices;

	}

}
