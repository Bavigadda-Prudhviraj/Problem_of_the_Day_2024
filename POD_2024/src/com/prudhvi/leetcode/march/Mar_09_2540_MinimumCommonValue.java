package com.prudhvi.leetcode.march;

public class Mar_09_2540_MinimumCommonValue {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,6}, nums2 = {2,3,4,5};
		System.out.println(getCommon(nums1, nums2));
		
	}
	/**
	 * Finds the common element between two sorted arrays.
	 *
	 * @param nums1 The first sorted array.
	 * @param nums2 The second sorted array.
	 * @return The common element if found, otherwise -1.
	 *
	 * @TimeComplexity: O(min(N, M)), where N and M are the lengths of the input arrays.
	 * @SpaceComplexity: O(1).
	 */
	public static int getCommon(int[] nums1, int[] nums2) {
	    // Pointers for iterating through the two arrays.
	    int p1 = 0;
	    int p2 = 0;

	    // Iterate until either array is fully processed.
	    while (p1 < nums1.length && p2 < nums2.length) {
	        // Check if the current elements are equal.
	        if (nums1[p1] == nums2[p2]) {
	            return nums1[p1]; // Common element found.
	        } else if (nums1[p1] < nums2[p2]) {
	            p1++; // Move pointer in the first array.
	        } else {
	            p2++; // Move pointer in the second array.
	        }
	    }

	    return -1; // No common element found.
	}


}
