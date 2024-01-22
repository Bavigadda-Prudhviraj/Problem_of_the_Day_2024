package com.prudhvi.leetcode.january;

public class Jan_22_645_setMistach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Finds the repeated and missing numbers in an array of integers.
	 *
	 * @param nums An array of integers where each integer is in the range [1, n].
	 * @return An array containing two integers: [repeated, missing].
	 * @TimeComplexity O(n), where n is the length of the array.
	 * @SpaceComplexity O(1), as the function uses a constant amount of extra space.
	 */
	public static int[] findErrorNums(int[] nums) {
	    int n = nums.length;          // Get the length of the input array
	    int i = 0;                     // Initialize index variable for iteration
	    int[] res = new int[2];        // Initialize an array to store the repeated and missing numbers

	    // Iterate through the array to swap elements to their correct positions
	    while (i < n) {
	        if (nums[i] != nums[nums[i] - 1]) {
	            // Swap elements to their correct positions
	            int temp = nums[i];
	            nums[i] = nums[nums[i] - 1];
	            nums[temp - 1] = temp;
	        } else {
	            i++;  // Move to the next index if the element is already in its correct position
	        }
	    }

	    // Find the repeated and missing numbers
	    for (i = 0; i < n; i++) {
	        if (nums[i] != (i + 1)) {
	            res[0] = nums[i];        // The repeated number
	            res[1] = i + 1;           // The missing number
	        }
	    }

	    // Return the result array
	    return res;
	}


}
