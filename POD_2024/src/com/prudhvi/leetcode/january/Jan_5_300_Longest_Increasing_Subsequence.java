package com.prudhvi.leetcode.january;

public class Jan_5_300_Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		int[] nunms = { 10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lengthOfLIS(nunms));//[2,3,7,101]
	}
	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = 1;
		int maxLISLength = 1;

		for (int i = 1; i < n; i++) {
			int lengthEndingAtCurrentIndex = 0;
			// Find the maximum length of LIS ending at the current index
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) 
					lengthEndingAtCurrentIndex = Math.max(dp[j], lengthEndingAtCurrentIndex);
			}
			// Length of LIS ending at the current index is one more than the maximum found
			dp[i] = lengthEndingAtCurrentIndex + 1;
			// Update the overall maximum LIS length
			maxLISLength = Math.max(dp[i], maxLISLength);
		}

		return maxLISLength;
	}


}
