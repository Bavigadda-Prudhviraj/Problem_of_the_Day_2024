package com.prudhvi.leetcode.february;

public class Feb_13_2108_FindFirstPalindromicStringInTheArray {

	public static void main(String[] args) {
		String[] words = {"abc","car","ada","racecar","cool"};
		System.out.println(firstPalindrome(words));

	}

	/**
	 * Finds the first palindrome in an array of words.
	 *
	 * Time Complexity: O(N * M), where N is the number of words and M is the maximum length of a word.
	 *                  The function iterates through each word and checks whether it is a palindrome.
	 *
	 * Space Complexity: O(1).
	 *
	 * @param words An array of words.
	 * @return The first palindrome found in the array, or an empty string if no palindrome is found.
	 */
	public static String firstPalindrome(String[] words) {
	    for (int i = 0; i < words.length; i++) {
	        String word = words[i];
	        boolean isPalindrome = true;
	        int k = 0;
	        int l = word.length() - 1;

	        // Check whether the word is a palindrome.
	        while (k <= l) {
	            if (word.charAt(k) == word.charAt(l)) {
	                k++;
	                l--;
	            } else {
	                isPalindrome = false;
	                break;
	            }
	        }

	        // If the word is a palindrome, return it.
	        if (isPalindrome) {
	            return word;
	        }
	    }

	    // If no palindrome is found, return an empty string.
	    return "";
	}


}
