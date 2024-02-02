package com.prudhvi.geeks_for_geeks.february;

public class Feb_2_ImplementAtoi {

	public static void main(String[] args) {
		String s = "-123";
		System.out.println(atoi(s));
	}
	/**
	 * Converts a string representation of an integer to its corresponding integer value.
	 *
	 * @param s The input string to be converted.
	 * @return The integer value represented by the input string.
	 *         Returns -1 if the input string is invalid or contains non-numeric characters.
	 *
	 * @TimeComplexity: O(n) - The function iterates through each character in the input string.
	 * @SpaceComplexity: O(1) - The function uses a constant amount of space for variables.
	 */
	public static int atoi(String s) {
	    int ans = 0;            // Variable to store the result.
	    int pow = 0;            // Power of 10 multiplier.
	    boolean isNegative = false;  // Flag to indicate if the number is negative.

	    // Iterate through the characters of the string in reverse order.
	    for (int i = s.length() - 1; i >= 0; i--) {
	        // Check if it is the first character and represents a negative sign.
	        if (i == 0 && s.charAt(i) == '-')
	            isNegative = true;
	        // Check if the character is a numeric digit.
	        else if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
	            ans += ((s.charAt(i) - '0') * (int) Math.pow(10, pow++));
	        // Return -1 for invalid characters (non-numeric).
	        else
	            return -1;
	    }

	    // Return the final result with the appropriate sign.
	    return isNegative ? -ans : ans;
	}


}
