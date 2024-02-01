package com.prudhvi.geeks_for_geeks.february;
/*
Given a string s check if it is "Panagram" or not.

A "Panagram" is a sentence containing every letter in the English Alphabet.
 */
public class Feb_1_PanagramChecking {

	public static void main(String[] args) {
		String s = "Bawds jog, flick quartz, vex nymph";
		System.out.println(checkPangram(s));

	}

	/**
	 * Checks if the given string is a pangram, i.e., it contains every letter of the alphabet at least once.
	 *
	 * @param s The input string to be checked.
	 * @return True if the string is a pangram, false otherwise.
	 * 
	 * @TimeComplexity: O(n), where n is the length of the input string.
	 * - The function iterates through each character in the input string once.
	 * 
	 * @SpaceComplexity: O(1) because the size of the boolean array (check) is constant (26).
	 * - The space required does not grow with the size of the input string.
	 */
	public static boolean checkPangram(String s) {
	    // Array to keep track of the presence of each letter in the alphabet.
	    boolean[] check = new boolean[26];
	    // Convert the input string to lower case for case-insensitive comparison.
	    String str = s.toLowerCase();
	    // Iterate through each character in the string.
	    for (int i = 0; i < str.length(); i++) {
	        // Check if the character is a lower case letter, and mark its presence in the array.
	        if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') 
	            check[str.charAt(i) - 'a'] = true;
	    }
	    
	    // Check if any letter is missing in the array, indicating that the string is not a pangram.
	    for (int i = 0; i < check.length; i++) {
	        if (check[i] == false) 
	            return false;
	    }
	    
	    // If all letters are present, return true, indicating a pangram.
	    return true;
	}

}
