package com.prudhvi.geeks_for_geeks.march;

public class Mar_10_RemoveAllDuplicatesFromAGivenString {

	public static void main(String[] args) {
		String string = "cacbbcCCBc";
		System.out.println(removeDuplicates(string));;

	}
	/**
	 * Removes duplicate characters from a given string while preserving the order of appearance.
	 * This method removes duplicate characters from the input string while preserving the order of the first occurrence of each character.
	 * @param str The input string.
	 * @return A new string with duplicate characters removed.
	 *
	 * @TimeComplexity: O(N), where N is the length of the input string.
	 * @SpaceComplexity: O(1), as the frequency arrays have a fixed size (26).
	 */
	public static String removeDuplicates(String str) {
	    // Arrays to keep track of the frequency of upper case and lower case letters (26 letters in the English alphabet).
	    int[] uppercaseFreq = new int[26];
	    int[] lowercaseFreq = new int[26];

	    // Loop through each character in the input string to populate the frequency arrays.
	    for (int i = 0; i < str.length(); i++) {
	        char currentChar = str.charAt(i);
	        
	        // If the current character is an upper case letter, update its frequency in the uppercaseFreq array.
	        if (currentChar >= 'A' && currentChar <= 'Z') {
	            uppercaseFreq[currentChar - 'A']++;
	        } 
	        // If the current character is a lower case letter, update its frequency in the lowercaseFreq array.
	        else if (currentChar >= 'a' && currentChar <= 'z') {
	            lowercaseFreq[currentChar - 'a']++;
	        }
	    }

	    // StringBuilder to store the result (string without duplicates).
	    StringBuilder resultBuilder = new StringBuilder();

	    // Iterate through the input string to build the result string without duplicates.
	    for (int i = 0; i < str.length(); i++) {
	        char currentChar = str.charAt(i);
	        
	        // If the current character is an upper case letter and its frequency is greater than 0,
	        // mark its frequency as 0 and append it to the resultBuilder.
	        if (currentChar >= 'A' && currentChar <= 'Z' && uppercaseFreq[currentChar - 'A'] > 0) {
	            uppercaseFreq[currentChar - 'A'] = 0;
	            resultBuilder.append(currentChar);
	        } 
	        // If the current character is a lower case letter and its frequency is greater than 0,
	        // mark its frequency as 0 and append it to the resultBuilder.
	        else if (currentChar >= 'a' && currentChar <= 'z' && lowercaseFreq[currentChar - 'a'] > 0) {
	            lowercaseFreq[currentChar - 'a'] = 0;
	            resultBuilder.append(currentChar);
	        }
	    }

	    // Convert the resultBuilder to a string and return the final result.
	    return resultBuilder.toString();
	}


}
