package com.prudhvi.geeks_for_geeks.march;


import java.util.HashSet;

import java.util.Set;

public class Mar_08_CheckIfFrequenciesCanBeEqual {

	public static void main(String[] args) {
		String s = "xxxyyyaabb";
		System.out.println(sameFreq(s));
		System.out.println(sameFreqOptimized(s));

	}
	/**
	 * Checks if it's possible to make all character frequencies in the string the same by removing at most one character.
	 *
	 * @param s The input string.
	 * @return True if it's possible, otherwise false.
	 *
	 * Time Complexity: O(N), where N is the length of the string.
	 * Space Complexity: O(1), as the hash array has a constant size (26 characters).
	 */
	public static boolean sameFreqOptimized(String s) {
	    // Initialize an array to store the frequency of each character.
	    int[] hash = new int[26];
	    // Initialize the minimum frequency to the length of the input string.
	    int minFreq = s.length();
	    // Flag to track if a character with a frequency different than the minimum frequency is encountered.
	    boolean flag = false;

	    // Count the frequency of each character in the input string.
	    for (char c : s.toCharArray()) {
	        hash[c - 'a']++;
	    }

	    // Find the minimum frequency among the non-zero frequencies.
	    for (int i = 0; i < 26; i++) {
	        if (hash[i] == 0) continue;
	        minFreq = Math.min(minFreq, hash[i]);
	    }

	    // Check if it's possible to make all frequencies the same by removing at most one character.
	    for (int i = 0; i < 26; i++) {
	        if (hash[i] == 0 || hash[i] == minFreq) continue;
	        // If the flag is already set or the difference between the frequency and minFreq is greater than 1, return false.
	        if (flag || hash[i] - minFreq > 1) return false;
	        flag = true;
	    }

	    // If the loop completes, it's possible to make all frequencies the same by removing at most one character.
	    return true;
	}


	/**
	 * Checks if it's possible to make all character frequencies in the string the same by removing at most one character.
	 *
	 * @param s The input string.
	 * @return True if it's possible, otherwise false.
	 *
	 * Time Complexity: O(N), where N is the length of the string.
	 * Space Complexity: O(1), as the frequency array has a constant size (26 characters) and the set also has a constant size.
	 */
	public static boolean sameFreq(String s) {
	    // Initialize an array to store the frequency of each character.
	    int[] freq = new int[26];
	    
	    // Count the frequency of each character in the input string.
	    for (int i = 0; i < s.length(); i++) {
	        freq[s.charAt(i) - 'a']++;
	    }
	    
	    // Set to store unique frequencies encountered.
	    Set<Integer> set = new HashSet<>();
	    // Counter to track how many frequencies are already present in the set.
	    int containsCheck = 0;

	    // Iterate over the frequency array.
	    for (int ele : freq) {
	        if (ele != 0) {
	            // Check if the frequency is already present in the set.
	            if (set.contains(ele)) {
	                containsCheck++;
	            }
	            // Add the frequency to the set.
	            set.add(ele);
	        }
	        
	        // If more than one frequency is already present, return false.
	        if (containsCheck > 1) {
	            return false;
	        }
	    }

	    // Check the conditions for making frequencies the same.
	    if (set.size() == 1 || set.size() > 2) {
	        return true;
	    }

	    int val1 = -1;
	    int val2 = -1;
	    int index = 1;

	    // Extract the two unique frequencies from the set.
	    for (Integer val : set) {
	        if (index == 1) {
	            val1 = val;
	            index++;
	        } else if (index == 2) {
	            val2 = val;
	            index++;
	        }
	    }

	    // Check if the frequencies differ by at most 1.
	    if (Math.max(val2, val1) - Math.min(val1, val2) != 1) {
	        return false;
	    }

	    // If all conditions are satisfied, return true.
	    return true;
	}


}
