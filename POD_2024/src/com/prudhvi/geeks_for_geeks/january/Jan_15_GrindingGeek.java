package com.prudhvi.geeks_for_geeks.january;

public class Jan_15_GrindingGeek {

	public static void main(String[] args) {
		int n = 2;
		int total = 10;
		int[] cost = { 10, 9 };
		System.out.println(max_courses(n, total, cost));

	}
	/**
	 * Finds the maximum number of courses that can be taken with the given budget.
	 *
	 * @param n      The total number of courses.
	 * @param total  The total budget available.
	 * @param cost   An array representing the cost of each course.
	 * @return       The maximum number of courses that can be taken.
	 * @TimeComplexity : O(n * total), where n is the total number of courses and total is the total budget.
	 * @SpaceComplexity : O(n * total), as the function uses memoization to store intermediate results.
	 */
	public static int max_courses(int n, int total, int[] cost) {
	    // Memoization table to store computed results
	    Integer[][] dp = new Integer[n][total + 1];
	    // Call the recursive helper function
	    return maxCourses(0, total, cost, dp);
	}

	/**
	 * Recursive helper function to find the maximum number of courses that can be taken.
	 *
	 * @param index The current index of the course being considered.
	 * @param total The remaining budget.
	 * @param cost  An array representing the cost of each course.
	 * @param dp    Memoization table to store computed results.
	 * @return      The maximum number of courses that can be taken.
	 */
	public static int maxCourses(int index, int total, int[] cost, Integer[][] dp) {
	    // Base case: If all courses are considered, return 0
	    if (index >= cost.length)
	        return 0;

	    // If the result for the current state is already computed, return it
	    if (dp[index][total] != null) 
	        return dp[index][total];
	    

	    // Check if the cost of the current course is within the remaining budget
	    if (cost[index] <= total) {
	        // Calculate the cost after a 10% discount
	        int discountedCost = cost[index] - (9 * cost[index] / 10);
	        // Recursively pick the current course and move to the next index with reduced budget
	        int pick = maxCourses(index + 1, total - discountedCost, cost, dp);
	        // Recursively skip the current course and move to the next index with the original budget
	        int notPick = maxCourses(index + 1, total, cost, dp);
	        // Return the maximum of picking or skipping the current course
	        return dp[index][total] = Math.max(1 + pick, notPick);
	    }

	    // If the cost is greater than the remaining budget, skip the current course
	    return dp[index][total] = maxCourses(index + 1, total, cost, dp);
	}


}
