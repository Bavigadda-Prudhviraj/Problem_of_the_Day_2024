package com.prudhvi.leetcode.february;

public class Feb_5_387_FirstUniqueCharacterInString {

	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));

	}

	/**
	 * Finds the index of the first non-repeating character in the given string.
	 *
	 * @param s The input string.
	 * @return The index of the first non-repeating character, or -1 if not found.
	 *
	 * Time Complexity: O(n) - Iterates through the string once.
	 * Space Complexity: O(1) - Uses a constant-size array to store character frequencies.
	 */
	public static int firstUniqChar(String s) {
	    // Array to store the frequency of each character in the alphabet.
	    int[] charFrequency = new int[26];

	    // Count the frequency of each character in the string.
	    for (int i = 0; i < s.length(); i++) {
	        charFrequency[s.charAt(i) - 'a']++;
	    }

	    // Iterate through the string to find the first non-repeating character.
	    for (int i = 0; i < s.length(); i++) {
	        if (charFrequency[s.charAt(i) - 'a'] == 1) {
	            // Return the index of the first non-repeating character.
	            return i;
	        }
	    }

	    // Return -1 if no non-repeating character is found.
	    return -1;
	}


}
