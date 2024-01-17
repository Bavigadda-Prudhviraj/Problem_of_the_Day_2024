package com.prudhvi.leetcode.january;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

Example 1:
	Input: arr = [1,2,2,1,1,3]
	Output: true
	Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 */
public class Jan_17_1207_UniqueNumberOfOccurrences {

	public static void main(String[] args) {
		int[] arr = {1,2,2,1,1,3};
		System.out.println(uniqueOccurrences(arr));

	}
	/**
	 * Determines whether the occurrences of each unique element in the array are unique.
	 *
	 * @param arr The input array of integers.
	 * @return True if the occurrences of each unique element are unique; false otherwise.
	 * @TimeComplexity The time complexity is O(N), where N is the length of the input array.
	 * @SpaceComplexity The space complexity is O(N) due to the usage of HashMap and HashSet.
	 */
	public static boolean uniqueOccurrences(int[] arr) {
	    // HashMap to store the count of occurrences for each element
	    HashMap<Integer, Integer> map = new HashMap<>();

	    // Count occurrences of each element
	    for (int ele : arr) 
	        map.put(ele, map.getOrDefault(ele, 0) + 1);

	    // HashSet to store unique counts
	    Set<Integer> set = new HashSet<>();

	    // Check if the counts are unique
	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        if (set.contains(entry.getValue())) 
	            // If a count is repeated, return false
	            return false;
	        
	        set.add(entry.getValue());
	    }

	    // If all counts are unique, return true
	    return true;
	}


}
