package com.prudhvi.leetcode.march;

import java.util.ArrayList;
import java.util.Arrays;

public class Mar_10_349_IntersectionOfTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
		System.out.println(Arrays.toString(intersection(nums1, nums2)));
		

	}
	/**
	 * Finds the intersection of two arrays.
	 *
	 * @param nums1 The first array.
	 * @param nums2 The second array.
	 * @return An array containing the common elements of nums1 and nums2.
	 *
	 * @TimeComplexity: O(N + M), where N and M are the lengths of the input arrays.
	 * @SpaceComplexity: O(1) as the frequency array has a fixed size (10001).
	 */
	public static int[] intersection(int[] nums1, int[] nums2) {
	    // Array to store the frequency of elements in nums1.
	    int[] frequency = new int[10001];

	    // Count the frequency of each element in nums1.
	    for (int num : nums1) {
	        frequency[num]++;
	    }

	    // List to store the intersection elements.
	    ArrayList<Integer> intersectionList = new ArrayList<>();

	    // Check the frequency in nums2 and add to the intersection list if common.
	    for (int num : nums2) {
	        if (frequency[num] > 0) {
	            intersectionList.add(num);
	            frequency[num] = 0; // Mark as visited.
	        }
	    }

	    // Convert the ArrayList to an array.
	    int[] intersectionArray = new int[intersectionList.size()];
	    for (int i = 0; i < intersectionList.size(); i++) {
	        intersectionArray[i] = intersectionList.get(i);
	    }

	    return intersectionArray;
	}

}
