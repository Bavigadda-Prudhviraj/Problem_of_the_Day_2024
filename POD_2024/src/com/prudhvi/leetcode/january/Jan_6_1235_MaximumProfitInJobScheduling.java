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
	/*
Time Complexity:
1. The code sorts the array of jobs based on their start times, which takes O(N log N) time, where N is the number of jobs.
2. The `jobSchedule` function is a recursive function, and each call either takes the current job or skips it. For each job, it calls itself recursively, and there is also a binary search (`findNextIndex`). 
   In the worst case, the depth of the recursion can go up to N.
3. Inside the `jobSchedule` function, the binary search (`findNextIndex`) takes O(log N) time.
Therefore, the overall time complexity is O(N log N + O(2^N log N) due to the recursive calls.

Space Complexity:
1. The code uses an array `dp` to store the results of subproblems. The size of this array is N.
2. The recursion stack can go up to the depth of the recursion, which is at most N.
3. Additional space is used for the `Job` objects and the sorting.
Therefore, the overall space complexity is O(N).

In summary, the time complexity is O(N log N) + O(2^N \log N), and the space complexity is O(N). 
The code solves the job scheduling problem using dynamic programming with memoization to avoid redundant calculations. The time complexity is dominated by the sorting step and the recursive calls.
	 */
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
	
	//<-----------------------------------------Tabulation---------------------------------------------------------------->
	private static int jobSchedulingTabulated(int[] startTime, int[] endTime, int[] profit) {
	    int n = startTime.length;
	    Job[] jobs = new Job[n];

	    for (int i = 0; i < n; i++) {
	        jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
	    }

	    Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

	    int[] dp = new int[n];
	    dp[0] = jobs[0].profit;

	    for (int i = 1; i < n; i++) {
	        int take = jobs[i].profit;
	        int l = findLastNonOverlappingJob(jobs, i);
	        if (l != -1) {
	            take += dp[l];
	        }
	        dp[i] = Math.max(take, dp[i - 1]);
	    }

	    return dp[n - 1];
	}

	private static int findLastNonOverlappingJob(Job[] jobs, int i) {
	    for (int j = i - 1; j >= 0; j--) {
	        if (jobs[j].endTime <= jobs[i].startTime) {
	            return j;
	        }
	    }
	    return -1;
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
