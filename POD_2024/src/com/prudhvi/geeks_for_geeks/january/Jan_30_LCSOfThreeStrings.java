package com.prudhvi.geeks_for_geeks.january;

public class Jan_30_LCSOfThreeStrings {

	public static void main(String[] args) {
		String A = "geeks";
		String B = "geeksfor"; 
		String	C = "geeksforgeeks";
		System.out.println(LCSof3(A, B, C, 5, 8, 13));
		System.out.println(LCSof3Tab(A, B, C, 5, 8, 13));
	}
	
	/**
	 * Finds the length of the Longest Common Subsequence (LCS) of three strings.
	 *
	 * @param A First input string.
	 * @param B Second input string.
	 * @param C Third input string.
	 * @param n1 Length of the first string.
	 * @param n2 Length of the second string.
	 * @param n3 Length of the third string.
	 * @return The length of the LCS of three strings.
	 *
	 * Time Complexity: O(n1 * n2 * n3)
	 *   - The method explores all possible combinations of characters in the three strings.
	 *
	 * Space Complexity: O(n1 * n2 * n3)
	 *   - The space used by the memorization table to store intermediate results.
	 */
	public static int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
	    // Memorization table to store intermediate results.
	    Integer[][][] dp = new Integer[n1][n2][n3];
	    
	    // Call to the helper method to find the LCS length.
	    return helper(0, 0, 0, A, B, C, n1, n2, n3, dp);
	}

	private static int helper(int i, int j, int k, String a, String b, String c, int n1, int n2, int n3, Integer[][][] dp) {
	    // Base case: if any string is exhausted, return 0.
	    if (i == n1 || j == n2 || k == n3) 
	        return 0;

	    // If the result for the current indices is already memorized, return it.
	    if (dp[i][j][k] != null)
	        return dp[i][j][k];

	    // If characters at the current indices match, extend the LCS length.
	    if (a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k))
	        return dp[i][j][k] = 1 + helper(i + 1, j + 1, k + 1, a, b, c, n1, n2, n3, dp);

	    // If characters do not match, explore other possibilities.
	    int aCharNotMatch = helper(i + 1, j, k, a, b, c, n1, n2, n3, dp);
	    int bCharNotMatch = helper(i, j + 1, k, a, b, c, n1, n2, n3, dp);
	    int cCharNotMatch = helper(i, j, k + 1, a, b, c, n1, n2, n3, dp);

	    // Return the maximum length among the possibilities.
	    return dp[i][j][k] = Math.max(aCharNotMatch, Math.max(bCharNotMatch, cCharNotMatch));
	}

	/**
	 * Finds the length of the Longest Common Subsequence (LCS) of three strings using tabulation (bottom-up approach).
	 *
	 * @param A First input string.
	 * @param B Second input string.
	 * @param C Third input string.
	 * @param n1 Length of the first string.
	 * @param n2 Length of the second string.
	 * @param n3 Length of the third string.
	 * @return The length of the LCS of three strings.
	 *
	 * @TimeComplexity: O(n1 * n2 * n3)
	 *   - The method iterates through all possible combinations of characters in the three strings.
	 *
	 * @SpaceComplexity: O(n1 * n2 * n3)
	 *   - The space used by the tabulation table to store intermediate results.
	 */
	public static int LCSof3Tab(String A, String B, String C, int n1, int n2, int n3) {
	    // Tabulation table to store intermediate results.
	    int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

	    // Iterate through all possible combinations of lengths.
	    for (int i = 0; i <= n1; i++) {
	        for (int j = 0; j <= n2; j++) {
	            for (int k = 0; k <= n3; k++) {
	                // Base case: if any string is empty, LCS length is 0.
	                if (i == 0 || j == 0 || k == 0)
	                    dp[i][j][k] = 0;
	                // If characters at the current indices match, extend the LCS length.
	                else if (A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1))
	                    dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
	                // If characters do not match, consider the maximum length from the previous states.
	                else
	                    dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
	            }
	        }
	    }

	    // The result is stored in the last cell of the tabulation table.
	    return dp[n1][n2][n3];
	}


}
