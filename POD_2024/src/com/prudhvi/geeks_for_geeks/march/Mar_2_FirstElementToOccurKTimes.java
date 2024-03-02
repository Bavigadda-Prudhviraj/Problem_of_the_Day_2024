package com.prudhvi.geeks_for_geeks.march;

import java.util.HashMap;

public class Mar_2_FirstElementToOccurKTimes {

	public static void main(String[] args) {
		int n = 7, k = 2;
		int	a[] = {1, 7, 4, 3, 4, 8, 7};
		System.out.println(firstElementKTime(n, k, a));

	}
	/**
	 * Finds the first element that occurs exactly k times in the given array.
	 *
	 * @param n The number of elements in the array.
	 * @param k The required frequency of the element.
	 * @param a The input array.
	 * @return The first element that occurs exactly k times, or -1 if no such element exists.
	 *
	 * @TimeComplexity: O(N), where N is the length of the input array.
	 * @SpaceComplexity: O(U), where U is the number of unique elements in the array.
	 */
	public static int firstElementKTime(int n, int k, int[] a) {
	    HashMap<Integer, Integer> frequencyMap = new HashMap<>();

	    // Traverse the array and update the frequency of each element in the map.
	    for (int ele : a) {
	        frequencyMap.put(ele, frequencyMap.getOrDefault(ele, 0) + 1);
	        // Check if the frequency of the element becomes k, return the element.
	        if (frequencyMap.get(ele) == k) {
	            return ele;
	        }
	    }
	    // If no element occurs exactly k times, return -1.
	    return -1;
	}


}
