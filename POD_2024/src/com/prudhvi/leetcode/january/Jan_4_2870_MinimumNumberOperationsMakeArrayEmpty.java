package com.prudhvi.leetcode.january;

import java.util.HashMap;
import java.util.Map;


public class Jan_4_2870_MinimumNumberOperationsMakeArrayEmpty {

	public static void main(String[] args) {
		int[] nums = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
		System.out.println(minOperations(nums));

	}
	/*
	Time Complexity:
			1. The first loop iterates through the elements in the `nums` array to count the frequency of each element and store it in the `frequency` HashMap. This loop has a time complexity of (O(N)), where (N) is the size of the array.
			2. The second loop iterates through the entries in the `frequency` HashMap. In the worst case, the number of unique elements in the array is (N), so this loop also has a time complexity of (O(N)).
		Therefore, the overall time complexity is O(N).
	
	Space Complexity:
			The space complexity is determined by the `frequency` HashMap.
			1. The `frequency` HashMap stores the count of each unique element in the `nums` array. In the worst case, all elements are unique, and the HashMap will have (N) entries.
			2. Additional space is used for integer variables, which is constant.
		Therefore, the space complexity is (O(N)), where (N) is the size of the array.
	
	In summary, the time complexity is (O(N)), and the space complexity is also \(O(N)\).
	 */
	public static int minOperations(int[] nums) {
		// Create a HashMap to store the frequency of each element
		HashMap<Integer, Integer> frequency = new HashMap<>();
		// Count the frequency of each element in the array
		for (int ele : nums) {
			frequency.put(ele, frequency.getOrDefault(ele, 0) + 1);
		}
		int minOperations = 0;
		// Iterate through the frequency map
		for (Map.Entry<Integer, Integer> ele : frequency.entrySet()) {
			// If any element appears only once, it's not possible to group elements into sets of three
			if (ele.getValue() == 1)
				return -1;
			// Calculate the minimum number of operations needed to group elements into sets of three
			// https://www.youtube.com/watch?v=lkPNh2M1lUs
			minOperations += Math.ceil(((double) ele.getValue() / 3));
		}
		// Return the total minimum number of operations
		return minOperations;
	}

}
