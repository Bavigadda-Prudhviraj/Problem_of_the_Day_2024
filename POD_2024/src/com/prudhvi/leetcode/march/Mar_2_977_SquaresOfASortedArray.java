package com.prudhvi.leetcode.march;

import java.util.Arrays;

public class Mar_2_977_SquaresOfASortedArray {

	public static void main(String[] args) {
		int[] nums = {-4,-1,0,3,10};
		System.out.println(Arrays.toString(sortedSquares(nums)));
		int[] nums1 = {-4,-1,0,3,10};
		System.out.println(Arrays.toString(sortedSquaresOptimised(nums1)));

	}
	public static int[] sortedSquaresOptimised(int[] nums) {
		int n = nums.length;
		int[] sortedSqr = new int[n];
		int index = n - 1;
		int left = 0;
		int right = n - 1;
		while(left <= right) {
			if((nums[left] * nums[left]) >= (nums[right] * nums[right])) {
				sortedSqr[index] = nums[left] * nums[left];
				left++;
				index--;
			}else {
				sortedSqr[index] = nums[right] * nums[right];
				right--;
				index--;
			}
		}
		return sortedSqr;
		
		
	}
	/**
	 * Squares each element in the given array and returns a new array with the squared values sorted in ascending order.
	 *
	 * @param nums The input array.
	 * @return A new array containing the squared values of the input array, sorted in ascending order.
	 *
	 * @TimeComplexity: O(N log N), where N is the length of the input array.
	 * @SpaceComplexity: O(1) (ignoring the space required for input and output).
	 */
	public static int[] sortedSquares(int[] nums) {
	    // Square each element in the array.
	    for (int i = 0; i < nums.length; i++) {
	        nums[i] = nums[i] * nums[i];
	    }
	    // Sort the array in ascending order.
	    Arrays.sort(nums);
	    // Return the sorted array.
	    return nums;
	}


}
