package com.prudhvi.leetcode.january;

public class Jan_19_931_MinimumFallingPathSum {

	public static void main(String[] args) {
		int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
		System.out.println(minFallingPathSum(matrix));

	}
	/**
	 * Finds the minimum falling path sum in a given matrix.
	 *
	 * @param matrix The input matrix.
	 * @return The minimum falling path sum.
	 * @TimeComplexity The time complexity is O(n * m), where n is the number of rows and m is the number of columns in the matrix.
	 * @SpaceComplexity The space complexity is O(n * m), as the function uses a dynamic programming table to store intermediate results.
	 */
	public static int minFallingPathSum(int[][] matrix) {
	    int n = matrix.length;
	    int m = matrix[0].length;
	    // Dynamic programming table to store the minimum falling path sum
	    int[][] dp = new int[n][m];
	    // Initialize the first row of the dp table with the values from the matrix
	    for (int i = 0; i < m; i++) 
	        dp[0][i] = matrix[0][i];
	    
	    // Fill the dp table for the remaining rows
	    for (int i = 1; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            // Calculate the falling path sum from the cell above
	            int up = matrix[i][j] + dp[i - 1][j];
	            // Calculate the falling path sum from the left diagonal cell
	            int leftDiagonal = (j > 0) ? matrix[i][j] + dp[i - 1][j - 1] : Integer.MAX_VALUE;
	            // Calculate the falling path sum from the right diagonal cell
	            int rightDiagonal = (j < m - 1) ? matrix[i][j] + dp[i - 1][j + 1] : Integer.MAX_VALUE;
	            // Update the dp table with the minimum falling path sum
	            dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
	        }
	    }

	    // Find the minimum falling path sum in the last row of the dp table
	    int min = Integer.MAX_VALUE;
	    for (int i = 0; i < m; i++) {
	        min = Math.min(min, dp[n - 1][i]);
	    }

	    return min;
	}

    
    //Memorization
	/**
	 * Finds the minimum falling path sum in a given matrix using memoization.
	 *
	 * @param matrix The input matrix.
	 * @return The minimum falling path sum.
	 * @TimeComplexity The time complexity is O(n * m), where n is the number of rows and m is the number of columns in the matrix.
	 * @SpaceComplexity The space complexity is O(n * m), as the function uses a memoization table to store intermediate results.
	 */
	public int minFallingPathSumMemo(int[][] matrix) {
	    int n = matrix.length;
	    int m = matrix[0].length;
	    // Memoization table to store the minimum falling path sum
	    int[][] dp = new int[n][m];
	    // Initialize the first row of the dp table with the values from the matrix
	    for (int i = 0; i < m; i++) 
	        dp[0][i] = matrix[0][i];

	    // Find the minimum falling path sum in the last row using memoization
	    int min = Integer.MAX_VALUE;
	    for (int i = 0; i < m; i++) 
	        min = Math.min(min, memoizedMinFallingPathSum(matrix, n - 1, i, dp));
	    
	    return min;
	}

	/**
	 * Recursive helper function with memoization to find the minimum falling path sum.
	 *
	 * @param matrix The input matrix.
	 * @param row    The current row.
	 * @param col    The current column.
	 * @param dp     Memoization table to store computed results.
	 * @return       The minimum falling path sum.
	 */
	private int memoizedMinFallingPathSum(int[][] matrix, int row, int col, int[][] dp) {
	    // Base case: If we reach the first row, return the value from the matrix
	    if (row == 0) 
	        return matrix[0][col];
	    
	    // If the result for the current state is already computed, return it
	    if (dp[row][col] != 0) 
	        return dp[row][col];

	    // Calculate the falling path sum from the cell above
	    int up = matrix[row][col] + memoizedMinFallingPathSum(matrix, row - 1, col, dp);
	    // Calculate the falling path sum from the left diagonal cell
	    int leftDiagonal = (col > 0) ? matrix[row][col] + memoizedMinFallingPathSum(matrix, row - 1, col - 1, dp) : Integer.MAX_VALUE;
	    // Calculate the falling path sum from the right diagonal cell
	    int rightDiagonal = (col < matrix[0].length - 1) ? matrix[row][col] + memoizedMinFallingPathSum(matrix, row - 1, col + 1, dp) : Integer.MAX_VALUE;

	    // Update the dp table with the minimum falling path sum
	    dp[row][col] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));

	    return dp[row][col];
	}



}
