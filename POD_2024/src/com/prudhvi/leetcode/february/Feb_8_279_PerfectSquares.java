package com.prudhvi.leetcode.february;

import java.util.Arrays;

public class Feb_8_279_PerfectSquares {

	public static void main(String[] args) {
		int n = 12;
		System.out.println(numSquares(n));

	}

	/**
	 * Returns the least number of perfect square numbers that sum to n.
	 * 
	 * Time Complexity: O(n * sqrt(n)), where n is the given input.
	 *                  Nested loops iterate over all numbers up to n and their squares.
	 * 
	 * Space Complexity: O(n), where n is the given input.
	 *                   The space used by the dp array.
	 * 
	 * @param n The input integer.
	 * @return The least number of perfect square numbers that sum to n.
	 */
	public static int numSquares(int n) {
	    // Create an array to store the minimum number of perfect square numbers needed for each value up to n.
	    int[] dp = new int[n + 1];
	    
	    // Initialize the array with the maximum possible value.
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    
	    // The base case: it takes 0 perfect square numbers to sum up to 0.
	    dp[0] = 0;
	    
	    // Iterate over all numbers up to n.
	    for (int i = 1; i <= n; i++) {
	        // Iterate over all perfect squares less than or equal to i.
	        for (int sqr = 1; sqr * sqr <= i; sqr++) {
	            // Update the minimum number of perfect square numbers needed for the current value.
	            dp[i] = Math.min(dp[i], dp[i - (sqr * sqr)] + 1);
	        }
	    }
	    
	    // The final result is stored in dp[n].
	    return dp[n];
	}

}
