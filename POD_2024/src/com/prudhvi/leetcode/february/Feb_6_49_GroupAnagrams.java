package com.prudhvi.leetcode.february;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feb_6_49_GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}
	
	/**
	 * Groups anagrams from an array of strings.
	 *
	 * @param strs An array of strings.
	 * @return A list of lists containing grouped anagrams.
	 *
	 * Time Complexity: O(N * K * 26) - N is the length of the input array, and K is the maximum length of a string.
	 * Space Complexity: O(N * K) - Uses a HashMap to store anagrams.
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
	    // HashMap to store anagrams grouped by their sorted representation.
	    HashMap<String, List<String>> map = new HashMap<>();
	    // Iterate through each string in the array.
	    for (int i = 0; i < strs.length; i++) {
	        // Get the sorted representation of the current string.
	        String key = getWord(strs[i]);
	        // Retrieve the list of anagrams for the current key.
	        List<String> anagrams = map.getOrDefault(key, new ArrayList<>());
	        // Add the current string to the list of anagrams.
	        anagrams.add(strs[i]);
	        // Update the map with the new list of anagrams for the current key.
	        map.put(key, anagrams);
	    }
	    // List to store the final grouped anagrams.
	    List<List<String>> anagramGroup = new ArrayList<>();
	    // Iterate through the entries in the map and add each list of anagrams to the result.
	    for (Map.Entry<String, List<String>> entry : map.entrySet()) 
	        anagramGroup.add(entry.getValue());
	    
	    return anagramGroup;
	}

	/**
	 * Returns the sorted representation of a word.
	 *
	 * @param str The input string.
	 * @return The sorted representation of the input string.
	 */
	public static String getWord(String str) {
	    // Array to store the frequency of each letter in the word.
	    int[] letter = new int[26];

	    // Update the frequency array based on the characters in the word.
	    for (int i = 0; i < str.length(); i++) 
	        letter[str.charAt(i) - 'a']++;

	    // StringBuilder to build the sorted representation of the word.
	    StringBuilder newStr = new StringBuilder();

	    // Iterate through the frequency array and append each character to the result string.
	    for (int i = 0; i < 26; i++) {
	        if (letter[i] > 0) {
	            for (int j = 0; j < letter[i]; j++) 
	                newStr.append((char) ('a' + i));   
	        }
	    }

	    // Return the sorted representation of the word.
	    return newStr.toString();
	}



}
