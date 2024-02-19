package com.prudhvi.geeks_for_geeks.february;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Feb_19_GameWithString {

	public static void main(String[] args) {
		String s = "abccc";
		int k = 1;
		System.out.println(minValue(s, k));

	}
	/**
	 * Computes the minimum value after performing k operations on the given string.
	 *
	 * @param s The input string.
	 * @param k The number of operations to be performed.
	 * @return The minimum value after k operations.
	 *
	 * @TimeComplexity: O(N + K * log(N)), where N is the length of the input string.
	 * @SpaceComplexity: O(N), where N is the length of the input string.
	 */
	public static int minValue(String s, int k) {
	    // Create a frequency map to store the occurrences of each character in the string.
	    HashMap<Character, Integer> map = new HashMap<>();
	    for (int i = 0; i < s.length(); i++)
	        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

	    // Create a max heap (PriorityQueue) to store the frequencies of characters in descending order.
	    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
	    for (int frequency : map.values())
	        queue.add(frequency);

	    // Perform k operations by decrementing the highest frequency character in the heap.
	    while (k > 0) {
	        int frequency = queue.poll();
	        queue.add(frequency - 1);
	        k--;
	    }

	    // Calculate the square count of remaining frequencies in the heap.
	    int squareCount = 0;
	    while (!queue.isEmpty()) {
	        int frequency = queue.poll();
	        squareCount += (frequency * frequency);
	    }

	    // Return the computed minimum value after k operations.
	    return squareCount;
	}


}
