package com.prudhvi.leetcode.march;

import java.util.HashMap;

public class Mar_14_930_BinarySubarraysWithSum {

	public static void main(String[] args) {
		int[] nums = {1,0,1,0,1};
		int goal = 2;
		System.out.println(numSubarraysWithSum(nums, goal));

	}

	/**
	 * This method counts the number of subarrays in the given array 'nums' that sum up to the specified 'goal'.
	 * It uses a HashMap to keep track of prefix sums and their frequencies, allowing for efficient counting of subarrays.
	 *
	 * Time Complexity: O(n)
	 *   - n is the length of the input array 'nums'.
	 *   - The method iterates through the array once.
	 *   - Each iteration involves constant-time operations such as HashMap lookups and insertions.
	 *
	 * Space Complexity: O(n)
	 *   - The method uses a HashMap ('map') to store prefix sums and their frequencies.
	 *   - In the worst case, the HashMap may store all unique prefix sums, leading to a space complexity of O(n).
	 *   - Additionally, the method uses constant extra space for variables such as 'prefixSum', 'subArraysCount', and 'num'.
	 *
	 * @param nums The input array of integers.
	 * @param goal The target sum to be achieved by the subarrays.
	 * @return The number of subarrays with the specified sum 'goal'.
	 */
	public static int numSubarraysWithSum(int[] nums, int goal) {
	    // HashMap to store prefix sums and their frequencies.
	    HashMap<Integer, Integer> map = new HashMap<>();
	    
	    // Initialize the HashMap with an entry for prefix sum 0, to account for subarrays starting from index 0.
	    map.put(0, 1);
	    
	    // Initialize prefix sum and the count of subarrays.
	    int prefixSum = 0;
	    int subArraysCount = 0;
	    
	    // Iterate through the array 'nums'.
	    for (int num : nums) {
	        // Update the prefix sum.
	        prefixSum += num;
	        
	        // Check if there exists a prefix sum (prefixSum - goal) such that prefixSum - (prefixSum - goal) = goal.
	        // If such a prefix sum exists, it indicates the presence of subarrays with the specified sum 'goal'.
	        subArraysCount += map.getOrDefault(prefixSum - goal, 0);
	        
	        // Update the frequency of the current prefix sum in the HashMap.
	        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
	    }
	    
	    // Return the total count of subarrays with the specified sum 'goal'.
	    return subArraysCount;
	}


}
