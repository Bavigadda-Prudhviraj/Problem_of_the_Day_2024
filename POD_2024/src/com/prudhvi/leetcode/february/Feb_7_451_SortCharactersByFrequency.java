package com.prudhvi.leetcode.february;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Feb_7_451_SortCharactersByFrequency {

	public static void main(String[] args) {
		String s = "tree";
		System.out.println(frequencySort(s));

	}
	/**
	 * Sorts the characters in a string based on their frequencies in descending order.
	 *
	 * @param s The input string.
	 * @return A new string with characters sorted based on their frequencies.
	 *
	 * Time Complexity: O(N log N) - N is the length of the input string.
	 * Space Complexity: O(N) - N is the number of unique characters in the input string.
	 */
	public static String frequencySort(String s) {
	    // Create a map to store the frequency of each character.
	    HashMap<Character, Integer> map = new HashMap<>();

	    // Count the frequency of each character in the string.
	    for (int i = 0; i < s.length(); i++) 
	        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
	    

	    // Create an array of Pairs to store frequency and character.
	    Pair[] arr = new Pair[map.size()];
	    int index = 0;

	    // Convert the map entries to Pair objects.
	    for (Map.Entry<Character, Integer> entry : map.entrySet()) 
	        arr[index++] = new Pair(entry.getValue(), entry.getKey());
	    
	    // Sort the array of Pairs based on frequency in descending order.
	    Arrays.sort(arr, new MySort());
	    // Build the final string by appending characters based on their frequencies.
	    StringBuilder result = new StringBuilder();
	    for (int i = arr.length - 1; i >= 0; i--) {
	        int frequency = arr[i].frequency;
	        char character = arr[i].character;
	        // Append the character 'frequency' times.
	        for (int j = 0; j < frequency; j++) 
	            result.append(character);
	    }

	    // Convert StringBuilder to String and return.
	    return result.toString();
	}
}
class MySort implements Comparator<Pair>{

	@Override
	public int compare(Pair o1, Pair o2) {
		return o1.frequency - o2.frequency;
	}
	
}
class Pair{
    int frequency;
    char character;
    public Pair(int frequency, char character){
        this.frequency = frequency;
        this.character = character;
    }
}

