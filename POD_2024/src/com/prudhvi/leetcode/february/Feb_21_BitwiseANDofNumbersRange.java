package com.prudhvi.leetcode.february;

public class Feb_21_BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		int left = 5;
		int right = 7;
		System.out.println(rangeBitwiseAnd(left, right));

	}
	/**
	 * Computes the bitwise AND of all numbers in the range [left, right].
	 *
	 * @param left  The left bound of the range.
	 * @param right The right bound of the range.
	 * @return The bitwise AND of all numbers in the range [left, right].
	 *
	 * Time Complexity: O(log(max(left, right))), where left and right are the given bounds.
	 * Space Complexity: O(1).
	 */
	public static int rangeBitwiseAnd(int left, int right) {
	    int shiftCount = 0;

	    // Right shift both left and right until they become equal
	    while (left != right) {
	        left >>= 1;
	        right >>= 1;
	        shiftCount++;
	    }

	    // Left shift the common prefix to obtain the result
	    return right << shiftCount;
	}


}
