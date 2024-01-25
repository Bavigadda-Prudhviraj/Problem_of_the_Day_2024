package com.prudhvi.leetcode.january;

public class Jan_25_1143_LongestCommonSubsequence {

	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace";
		System.out.println(longestCommonSubsequence(text1, text2));

	}
	/**
	 * Finds the length of the longest common subsequence between two given strings.
	 *
	 * @param text1 The first input string.
	 * @param text2 The second input string.
	 * @return The length of the longest common subsequence.
	 * @TimeComplexity O(n * m), where n is the length of text1 and m is the length of text2.
	 * @SpaceComplexity O(n * m), as the function uses a 2D array to store intermediate results.
	 */
	public static int longestCommonSubsequence(String text1, String text2) {
	    // Get the lengths of the input strings
	    int n = text1.length();
	    int m = text2.length();
	    
	    // Create a 2D array to store the length of the longest common subsequence
	    int[][] dp = new int[n][m];

	    // Iterate through each character of the first string
	    for(int i = 0; i < n; i++){
	        // Iterate through each character of the second string
	        for(int j = 0; j < m; j++){
	            // If both strings are empty, set the value in the dp array to 1 if the characters match, else 0
	            if(i==0 && j ==0)
	                dp[i][j] = (text1.charAt(i) == text2.charAt(j)) ? 1 : 0;
	            // If the first string has only one character, set the value based on the match or the value to the left
	            else if(i == 0 && j > 0 )
	                dp[i][j] = (text1.charAt(i) == text2.charAt(j)) ? 1 : dp[i][j-1];
	            // If the second string has only one character, set the value based on the match or the value above
	            else if(i > 0 && j == 0 )
	                dp[i][j] = (text1.charAt(i) == text2.charAt(j)) ? 1 : dp[i-1][j];
	            // For other cases, if the characters match, set the value diagonally above-left + 1
	            // Otherwise, set the value to the maximum of the value above or the value to the left
	            else{
	                if(text1.charAt(i) == text2.charAt(j))
	                    dp[i][j] = dp[i-1][j-1] + 1; 
	                else
	                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        }
	    }

	    // Return the value stored at the bottom-right corner of the dp array, which represents the length of the LCS
	    return dp[n-1][m-1]; 
	}


}
