package com.prudhvi.leetcode.january;

public class Jan_18_70_ClimbingStairs {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(climbStairs(n));

	}
	/**
	 * Finds the number of distinct ways to climb to the top of a staircase with 'n' steps.
	 *
	 * @param n The total number of steps in the staircase.
	 * @return The number of distinct ways to climb to the top.
	 * @TimeComplexity The time complexity is O(n), where n is the total number of steps.
	 * @SpaceComplexity The space complexity is O(n), as an array of size n+1 is used for dynamic programming.
	 */
	public static int climbStairs(int n) {
	    // Dynamic programming array to store the number of ways to reach each step
	    int[] dp = new int[n + 1];

	    // Base cases: There is 1 way to reach the 0th and 1st steps
	    dp[0] = dp[1] = 1;

	    // Fill the dynamic programming array iteratively
	    for (int i = 2; i <= n; i++) 
	        // The number of ways to reach the current step is the sum of ways to reach the previous two steps
	        dp[i] = dp[i - 1] + dp[i - 2];
	    // Return the number of ways to reach the top (nth step)
	    return dp[n];
	}


}
