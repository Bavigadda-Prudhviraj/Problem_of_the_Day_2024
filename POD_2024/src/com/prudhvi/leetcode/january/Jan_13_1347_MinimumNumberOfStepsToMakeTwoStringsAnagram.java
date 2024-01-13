package com.prudhvi.leetcode.january;

public class Jan_13_1347_MinimumNumberOfStepsToMakeTwoStringsAnagram {

	public static void main(String[] args) {
		String s = "bab", t = "aba";
		System.out.println(minSteps(s, t));

	}
	/**
	 * Calculates the minimum number of steps to make two strings anagrams.
	 *
	 * <p>This function counts the frequency of characters in both strings and calculates
	 * the absolute difference in frequencies. The result represents the minimum number of
	 * steps needed to make the two strings anagrams.
	 *
	 * @param s The first string.
	 * @param t The second string.
	 * @return Minimum number of steps to make the strings anagrams.
	 *
	 * @timecomplexity The time complexity : O(max(n, m)), where n is the
	 *                  length of string s and m is the length of string t. The function iterates
	 *                  over both strings to calculate character frequencies.
	 * @spacecomplexity The space complexity : O(1) since the character array has a fixed size (26),
	 *                   independent of the input size.
	 */
	public static int minSteps(String s, String t) {
	    // Array to store the frequency of characters in both strings
	    int[] charFrequency = new int[26];

	    // Count the frequency of characters in string s
	    for (int i = 0; i < s.length(); i++)
	        charFrequency[s.charAt(i) - 'a']++;

	    // Subtract the frequency of characters in string t
	    for (int i = 0; i < t.length(); i++)
	        charFrequency[t.charAt(i) - 'a']--;

	    // Count the total number of steps needed (absolute differences in frequencies)
	    int minSteps = 0;
	    for (int i = 0; i < 26; i++) {
	        if (charFrequency[i] > 0)
	            minSteps += charFrequency[i];
	    }

	    // Return the minimum number of steps
	    return minSteps;
	}


}
