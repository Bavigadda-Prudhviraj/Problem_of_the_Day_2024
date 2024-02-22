package com.prudhvi.geeks_for_geeks.february;

public class Feb_22_DistinctOccurrences {

	public static void main(String[] args) {
		String s = "banana" ;
		String t = "ban";
		System.out.println(subsequenceCount(s, t));

	}
	/**
	 * Calculates the count of subsequences of string 's' that match the string 't'.
	 *
	 * @param s The input string.
	 * @param t The target string to match.
	 * @return The count of subsequences of 's' that match 't'.
	 *
	 * Time Complexity: O(n * m), where n is the length of string 's' and m is the length of string 't'.
	 * Space Complexity: O(n * m), where n is the length of string 's' and m is the length of string 't'.
	 */
	static int mod = (int) 1e9 + 7;

	public static int subsequenceCount(String s, String t) {
	    int n = s.length();
	    int m = t.length();
	    Integer[][] dp = new Integer[n][m];
	    return subsequenceCount(s, t, 0, 0, dp);
	}

	private static int subsequenceCount(String s, String t, int i, int j, Integer[][] dp) {
	    // If the entire target string is matched, return 1.
	    if (j == t.length()) return 1;

	    // If we reach the end of the input string, return 0.
	    if (i == s.length()) return 0;

	    // If the result is already calculated, return it.
	    if (dp[i][j] != null) return dp[i][j];

	    // If the characters match, we can either take or not take the current character.
	    if (s.charAt(i) == t.charAt(j)) {
	        int take = subsequenceCount(s, t, i + 1, j + 1, dp);
	        int notTake = subsequenceCount(s, t, i + 1, j, dp);
	        return dp[i][j] = (take + notTake) % mod;
	    } else {
	        // If characters don't match, continue with the next character in 's'.
	        return dp[i][j] = subsequenceCount(s, t, i + 1, j, dp);
	    }
	}

}
