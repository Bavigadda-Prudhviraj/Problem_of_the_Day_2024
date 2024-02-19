package com.prudhvi.leetcode.february;

public class Feb_20_231_PowerOfTwo {

	public static void main(String[] args) {
		int n = 16;
		System.out.println(isPowerOfTwo(n));
	}

	/**
	 * Checks if the given integer is a power of two.
	 *
	 * @param n The input integer.
	 * @return True if the input is a power of two, otherwise false.
	 *
	 * Time Complexity: O(log N), where N is the input integer.
	 * Space Complexity: O(1).
	 */
	public static boolean isPowerOfTwo(int n) {
	    // Check if the input is negative.
	    if (n < 0)
	        return false;
	    // If the input is 1, it is a power of two.
	    if (n == 1)
	        return true;
	    // Iterate through each bit of the integer.
	    for (int i = 31; i >= 0; i--) {
	        // Create a bitmask for the current bit.
	        int bitMask = (1 << i);
	        // If the XOR of the bitmask and the input is zero, the current bit is set.
	        if ((bitMask ^ n) == 0) 
	            return true;
	    }
	    // If no set bit is found, return false.
	    return false;
	}



}
