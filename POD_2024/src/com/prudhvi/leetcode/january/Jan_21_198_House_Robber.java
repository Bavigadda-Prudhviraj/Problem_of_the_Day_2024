package com.prudhvi.leetcode.january;

public class Jan_21_198_House_Robber {

	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));

	}

	/**
	 * Finds the maximum amount of money that can be robbed from a row of houses.
	 *
	 * @param nums An array representing the amount of money in each house.
	 * @return The maximum amount of money that can be robbed.
	 */
	public static int rob(int[] nums) {
	    // Get the number of houses
	    int n = nums.length;
	    // Handle the base case when there is only one house
	    if (n == 1) 
	        return nums[0];
	 
	    // Initialize an array to store the maximum amount of money at each house
	    int[] dp = new int[n];
	    // Set the initial values for the first two houses
	    dp[0] = nums[0];
	    dp[1] = Math.max(nums[0], nums[1]);

	    // Iterate through the remaining houses to calculate the maximum amount of money
	    for (int i = 2; i < n; i++) 
	        // Choose the maximum between robbing the current house and not robbing the previous house
	        dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

	    // Return the maximum amount of money that can be robbed from all the houses
	    return dp[n - 1];
	}


}
