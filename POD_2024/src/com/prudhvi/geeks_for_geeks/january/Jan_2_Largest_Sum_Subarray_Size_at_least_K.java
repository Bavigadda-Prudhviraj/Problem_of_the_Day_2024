package com.prudhvi.geeks_for_geeks.january;

public class Jan_2_Largest_Sum_Subarray_Size_at_least_K {

	public static void main(String[] args) {
		int n = 4;
		long[] a = { 1, -2, 2, -3 };
		int k = 2;
		System.out.println(maxSumWithK(a, n, k));
		
		

	}

	public static long maxSumWithK(long a[], long n, long k) {
		long[] dp = new long[(int) n + 1];
		for (int i = (int) n - 1; i >= 0; i--) {
			dp[i] = a[i] + dp[i + 1];
			dp[i] = Math.max(dp[i], 0L); // Use 0L to explicitly indicate a long constant
		}

		long currentSum = 0;
		for (int i = 0; i < k; i++) {
			currentSum += a[i];
		}
		long maxSum = Long.MIN_VALUE;
		for (int i = (int) k; i < n; i++) {
			long sum = dp[i] + currentSum;
			maxSum = Math.max(sum, maxSum);
			currentSum += a[i];
			currentSum -= a[i - (int) k];
		}
		return Math.max(currentSum, maxSum);
	}

}
