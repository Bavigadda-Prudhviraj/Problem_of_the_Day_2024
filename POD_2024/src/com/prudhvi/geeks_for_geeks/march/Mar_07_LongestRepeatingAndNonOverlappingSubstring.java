package com.prudhvi.geeks_for_geeks.march;

public class Mar_07_LongestRepeatingAndNonOverlappingSubstring {

	public static void main(String[] args) {
		int n = 9;
		String s = "acdcdacdc";
		System.out.println(longestSubstring(s, n));

	}

	/**
	 * Finds the longest substring with the same characters at the ends.
	 *
	 * @param s The input string.
	 * @param n The length of the string.
	 * @return The longest substring with the same characters at the ends.
	 *
	 * @TimeComplexity: O(N^2), where N is the length of the string.
	 * @SpaceComplexity: O(N^2).
	 */
	public static String longestSubstring(String s, int n) {
	    // Create a 2D array 'dp' to store the length of common suffixes.
	    int[][] dp = new int[n + 1][n + 1];
	    // Initialize variables to store the maximum length and the starting index of the substring.
	    int maxLength = -1;
	    int index = -1;

	    // Iterate over the string to fill the 'dp' array.
	    for (int i = 1; i <= n; i++) {
	        for (int j = i + 1; j <= n; j++) {
	            // Check if characters at positions (i-1) and (j-1) are equal, and the previous length is less than (j-i).
	            if (s.charAt(i - 1) == s.charAt(j - 1) && dp[i - 1][j - 1] < j - i) {
	                // Update the length of common suffix.
	                dp[i][j] = 1 + dp[i - 1][j - 1];
	            }

	            // Update the maximum length and starting index if a longer substring is found.
	            if (dp[i][j] > maxLength) {
	                maxLength = dp[i][j];
	                index = i;
	            }
	        }
	    }

	    // If no valid substring is found, return "-1".
	    if (index == -1) {
	        return "-1";
	    }

	    // Return the longest substring with the same characters at the ends.
	    return s.substring(index - maxLength, index);
	}


}
