package com.prudhvi.leetcode.january;

import java.util.Arrays;

public class Jan_14_1657_DetermineIfTwoStringsAreClose {

	public static void main(String[] args) {
		String word1 = "abc", word2 = "bca";
		System.out.println(closeStrings(word1, word2));
		

	}
    /**
     * Checks if two strings are "close" based on the given conditions:
     * 1. They have the same length.
     * 2. The frequency of each unique character in both strings is the same.
     * 3. The set of unique characters in both strings is the same.
     *
     * @param word1 The first input string.
     * @param word2 The second input string.
     * @return True if the strings are "close," false otherwise.
     * @TimeComplexity : O(n + 26 * log(26)) where n is the length of the strings.
     *                   The first part (O(n)) is used for calculating character frequencies, and the second part
     *                   (O(26 * log(26))) is used for sorting the frequency arrays.
     * @SpaceComplexity : O(26) since there are 26 letters in the English alphabet.
     */
    public static boolean closeStrings(String word1, String word2) {
        // Check if the lengths of the two strings are different
        if (word1.length() != word2.length())
            return false;

        // Arrays to store the frequency of each character in the strings
        int[] word1Frequency = new int[26];
        int[] word2Frequency = new int[26];

        // Calculate the frequency of each character in both strings
        for (int i = 0; i < word1.length(); i++) {
            word1Frequency[word1.charAt(i) - 'a']++;
            word2Frequency[word2.charAt(i) - 'a']++;
        }

        // Check if the sets of unique characters are the same
        for (int i = 0; i < 26; i++) {
            // If one string has a character with frequency > 0 while the other has 0, they are not "close"
            if(word1Frequency[i] != 0 && word2Frequency[i] != 0) 
                continue;
            if(word1Frequency[i] == 0 && word2Frequency[i] ==0 ) 
                continue;
        }

        // Sort the frequency arrays to compare if they have the same distribution of character frequencies
        Arrays.sort(word1Frequency);
        Arrays.sort(word2Frequency);

        // Check if the frequency arrays are the same
        for (int i = 0; i < 26; i++) {
            if (word1Frequency[i] !=  word2Frequency[i])
                return false;
        }

        // If all conditions are met, the strings are "close"
        return true;
    }



}
