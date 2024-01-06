package com.prudhvi.leetcode.january;

import java.util.Arrays;
import java.util.Comparator;

public class Jan_6_1235_MaximumProfitInJobScheduling {

	public static void main(String[] args) {
		int[] startTime = { 1,  2,  3,  3 };
		int[] endTime   = { 3,  4,  5,  6 };
		int[] profit    = { 50, 10, 40, 70 };
		System.out.println(jobScheduling(startTime, endTime, profit));
		;

	}

	private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		// Create an array of Job objects to store job details
		Job[] jobs = new Job[n];
		// Initialize the array with job details
		for (int i = 0; i < n; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}
		// Sort the jobs based on their start times
		Arrays.sort(jobs, Comparator.comparingInt(o -> o.startTime));
		// Create an array to store the computed results of subproblems
		Integer[] dp = new Integer[n];
		// Call the recursive function to find the maximum profit
		return jobSchedule(0, jobs, dp);

	}

	private static int jobSchedule(int index, Job[] jobs, Integer[] dp) {
		// Base case: If all jobs are processed, return 0
		if (index >= jobs.length)
			return 0;
		// If the result for the current index is already computed, return it
		if (dp[index] != null) 
			return dp[index];
		// Find the index of the next job that does not overlap with the current job
		int nextIndex = findNextIndex(index + 1, jobs, jobs[index].endTime);
		// Calculate the profit if the current job is taken
		int take = jobs[index].profit + jobSchedule(nextIndex, jobs, dp);
		// Calculate the profit if the current job is not taken
		int notTake = jobSchedule(index + 1, jobs, dp);
		// Return the maximum profit between taking and not taking the current job
		return dp[index] = Math.max(take, notTake);
	}
	// Perform binary search to find the next job that does not overlap
	private static int findNextIndex(int i, Job[] jobs, int endTime) {
		int low = i;
		int high = jobs.length - 1;
		int index = jobs.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (jobs[mid].startTime >= endTime) {
				index = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return index;
	}

}
//Definition of the Job class to store job details
class Job {
	int startTime;
	int endTime;
	int profit;

	public Job(int startTime, int endTime, int profit) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.profit = profit;
	}
}
