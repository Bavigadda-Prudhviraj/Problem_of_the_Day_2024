package com.prudhvi.geeks_for_geeks.march;

import java.util.ArrayList;

public class Mar_06_SearchPattern {

	public static void main(String[] args) {
		String text = "geeksforgeeks";
		String pattern = "geeks";
		System.out.println(search(pattern, text));

	}

	/**
	 * Searches for occurrences of a pattern in a text using the Knuth-Morris-Pratt algorithm.
	 *
	 * @param pattern The pattern to search for.
	 * @param text    The text to search within.
	 * @return An ArrayList containing the indices where the pattern is found in the text.
	 *
	 * Time Complexity: O(N + M), where N is the length of the pattern and M is the length of the text.
	 * Space Complexity: O(N), where N is the length of the pattern.
	 */
	public static ArrayList<Integer> search(String pattern, String text) {
	    int n = pattern.length();
	    // Concatenate the pattern and text with a separator character.
	    String str = pattern + '@' + text;
	    // Initialize the longest prefix suffix array.
	    int[] lps = new int[str.length()];
	    for (int i = 1; i < str.length(); i++) {
	        int prevChar = lps[i - 1];
	        // Calculate the longest prefix suffix length.
	        while (str.charAt(i) != str.charAt(prevChar)) {
	            if (prevChar <= 0) {
	                prevChar = -1;
	                break;
	            }
	            prevChar = lps[prevChar - 1];
	        }
	        lps[i] = prevChar + 1;
	    }
	    // Store the indices where the pattern is found.
	    ArrayList<Integer> indices = new ArrayList<>();
	    for (int i = n; i < lps.length; i++) {
	        if (lps[i] == n) {
	            indices.add(i - (2 * n) + 1);
	        }
	    }
	    return indices;
	}


}
