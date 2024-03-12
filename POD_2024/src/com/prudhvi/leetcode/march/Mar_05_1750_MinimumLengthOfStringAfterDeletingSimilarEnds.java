package com.prudhvi.leetcode.march;

public class Mar_05_1750_MinimumLengthOfStringAfterDeletingSimilarEnds {

	public static void main(String[] args) {
		String s = "aabccabba";
		System.out.println(minimumLength(s));

	}

	/**
	 * Finds the minimum length of a non-empty string after removing some
	 * characters.
	 *
	 * @param s The input string.
	 * @return The minimum length after removal.
	 *
	 *         Time Complexity: O(N), where N is the length of the input string.
	 *         Space Complexity: O(1).
	 */
	public static int minimumLength(String s) {
		// Get the length of the input string.
		int n = s.length();
		// Initialize two pointers, 'l' and 'r', pointing to the start and end of the
		// string.
		int l = 0;
		int r = n - 1;

		// Iterate while 'l' is less than 'r' and characters at 'l' and 'r' are equal.
		while (l < r && s.charAt(l) == s.charAt(r)) {
			// Save the character at 'l'.
			char ch = s.charAt(l);

			// Move 'l' to the right until a different character is encountered.
			while (l <= r && s.charAt(l) == ch) {
				l++;
			}

			// Move 'r' to the left until a different character is encountered.
			while (l <= r && s.charAt(r) == ch) {
				r--;
			}
		}

		// Return the minimum length after removal.
		return (r - l + 1);
	}

}
