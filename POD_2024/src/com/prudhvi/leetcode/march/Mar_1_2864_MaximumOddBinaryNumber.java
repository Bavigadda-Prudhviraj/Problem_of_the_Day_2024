package com.prudhvi.leetcode.march;

public class Mar_1_2864_MaximumOddBinaryNumber {

	public static void main(String[] args) {
		String s = "0101";
		System.out.println(maximumOddBinaryNumber(s));

	}

	/**
	 * Finds the maximum odd binary number that can be formed by changing at most one bit.
	 *
	 * @param s The input binary string.
	 * @return The maximum odd binary number.
	 *
	 * @TimeComplexity: O(N), where N is the length of the input string.
	 * @SpaceComplexity: O(N).
	 */
	public static String maximumOddBinaryNumber(String s) {
	    int zerosCount = 0;
	    int onesCount = 0;

	    // Count the number of zeros and ones in the input binary string.
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == '1') {
	            onesCount++;
	        } else {
	            zerosCount++;
	        }
	    }

	    StringBuilder str = new StringBuilder();

	    // Append '1' to the string until there is only one '1' left.
	    while (onesCount > 1) {
	        str.append('1');
	        onesCount--;
	    }

	    // Append '0' to the string for the remaining zeros.
	    while (zerosCount > 0) {
	        str.append('0');
	        zerosCount--;
	    }

	    // Append the last '1' to make the number odd.
	    str.append('1');

	    return str.toString();
	}


}
