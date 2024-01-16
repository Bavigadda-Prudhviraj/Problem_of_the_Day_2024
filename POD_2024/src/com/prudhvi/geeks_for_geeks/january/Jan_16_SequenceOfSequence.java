package com.prudhvi.geeks_for_geeks.january;
//https://www.geeksforgeeks.org/problems/sequence-of-sequence1155/1
public class Jan_16_SequenceOfSequence {

	public static void main(String[] args) {
		int m = 10, n = 4;
		System.out.println(numberSequence(m, n));

	}

	/**
	 * Calculates the number of sequences of length 'n' that can be formed using numbers from 1 to 'm'.
	 * @param m The maximum number that can be used in the sequence.
	 * @param n The length of the sequence.
	 * @return The total number of valid sequences.
	 * @TimeComplexity : The time complexity is exponential, O(2^(n/2)), due to the recursive nature.
	 * @SpaceComplexity : The space complexity is O(n) for the recursive call stack.
	 */
	public static int numberSequence(int m, int n) {
	    // Base case: an empty sequence is a valid sequence.
	    if (n == 0)
	        return 1;

	    // If 'n' is greater than 'm', no valid sequence can be formed.
	    if (n > m)
	        return 0;

	    // Recursive cases:
	    // 1. Select the next number from the range 1 to 'm/2' (inclusive).
	    // 2. Select the next number from the range 'm/2 + 1' to 'm' (inclusive).
	    return numberSequence(m / 2, n - 1) + numberSequence(m - 1, n);
	}

}
