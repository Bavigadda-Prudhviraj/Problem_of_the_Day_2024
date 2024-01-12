package com.prudhvi.leetcode.january;

import java.util.Arrays;
import java.util.HashSet;

public class Jan_12_1704_DetermineIfStringHalvesAreAlike {

	public static void main(String[] args) {
		String string = "book";
		System.out.println(halvesAreAlike(string));

	}
	/*
	Time Complexity: O(n) for iterating over String
	Space Complexity: O(10) = O(1), for hashSet. 
	 */
	public static boolean halvesAreAlike(String s) {
	    // Get the length of the string
	    int n = s.length();
	    // Variables to store vowel counts for the left and right halves
	    int leftVowelCount = 0;
	    int rightVowelCount = 0;
	    // Set to store vowels
	    HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	    // Iterate through the characters of the string
	    for (int i = 0; i < n; i++) {
	        // Check if the current character is a vowel and belongs to the left half
	        leftVowelCount = (i < n/2) && set.contains(s.charAt(i)) ? leftVowelCount + 1 : leftVowelCount;
	        // Check if the current character is a vowel and belongs to the right half
	        rightVowelCount = (i >= n/2) && set.contains(s.charAt(i)) ? rightVowelCount + 1 : rightVowelCount;
	    }
	    // Check if the vowel counts for the two halves are equal
	    return leftVowelCount == rightVowelCount;
	}


}
