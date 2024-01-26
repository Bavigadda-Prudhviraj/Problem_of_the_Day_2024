package com.prudhvi.leetcode.january;

public class Jan_26_OutOfBoundaryPaths {

	public static void main(String[] args) {
		int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
		System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
		

	}
	/**
	 * Finds the number of paths starting from a specific cell within a grid, considering maximum moves.
	 *
	 * @param m            The number of rows in the grid.
	 * @param n            The number of columns in the grid.
	 * @param maxMove      The maximum number of moves allowed.
	 * @param startRow     The starting row index.
	 * @param startColumn  The starting column index.
	 * @return The number of paths within the given constraints.
	 * @TimeComplexity : O(m * n * maxMove), where m and n are the dimensions of the grid,
	 *                  and maxMove is the maximum number of moves.
	 * @SpaceComplexity : O(m * n * maxMove), as the function uses memoization to store computed results.
	 */
	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
	    // Modulo value for calculations
	    int mod = (int) 1e9 + 7;
	    // Memoization table to store computed results
	    Integer[][][] dp = new Integer[m][n][maxMove + 1];
	    // Call the helper function to calculate the number of paths
	    return helper(startRow, startColumn, maxMove, dp, mod);
	}

	/**
	 * Helper function to recursively calculate the number of paths.
	 *
	 * @param startRow     The current row index.
	 * @param startColumn  The current column index.
	 * @param maxMove      The remaining maximum moves.
	 * @param dp           Memoization table to store computed results.
	 * @param mod          Modulo value for calculations.
	 * @return The number of paths from the current position with the given constraints.
	 */
	public static int helper(int startRow, int startColumn, int maxMove, Integer[][][] dp, int mod) {
	    // Base case: Check if the current position is outside the grid
	    if (startRow == dp.length || startColumn == dp[0].length || startRow < 0 || startColumn < 0)
	        return 1;

	    // Base case: Check if the maximum moves are exhausted
	    if (maxMove == 0)
	        return 0;

	    // Check if the result for the current state is already computed, return it
	    if (dp[startRow][startColumn][maxMove] != null)
	        return dp[startRow][startColumn][maxMove];

	    // Recursive calls to calculate paths in four possible directions
	    int up    = helper(startRow - 1, startColumn, maxMove - 1, dp, mod);
	    int down  = helper(startRow + 1, startColumn, maxMove - 1, dp, mod);
	    int left  = helper(startRow, startColumn - 1, maxMove - 1, dp, mod);
	    int right = helper(startRow, startColumn + 1, maxMove - 1, dp, mod);

	    // Calculate the total number of paths and update the memoization table
	    dp[startRow][startColumn][maxMove] = ((up + down) % mod + (left + right) % mod) % mod;

	    return dp[startRow][startColumn][maxMove];
	}


}
