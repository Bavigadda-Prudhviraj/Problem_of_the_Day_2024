package com.prudhvi.leetcode.march;

import java.util.HashMap;

public class Mar_11_791_CustomSortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * This method customizes the sorting of characters in the input string 's' based on the specified order string.
	 * It uses counting sort to achieve the custom sorting.
	 *
	 * Time Complexity: O(n + m)
	 *   - n is the length of the input string 's'.
	 *   - m is the length of the order string.
	 *   - The method iterates through 's' and 'order' strings, and the two loops together contribute O(n + m).
	 *
	 * Space Complexity: O(1) (constant space)
	 *   - The method uses a fixed-size array 'sCounts' of size 26 to store the counts of characters.
	 *   - The StringBuilder 'builder' is used to build the result string, and its space complexity is not directly proportional to the input size.
	 *   - Thus, the space complexity is considered constant, O(1).
	 *
	 * @param order The order string specifying the desired order of characters.
	 * @param s     The input string to be custom sorted.
	 * @return      The custom sorted string based on the specified order.
	 */
	public String customSortStringSc(String order, String s) {
	    
	    // Array to store the counts of each character in the input string 's'.
	    int[] sCounts = new int[26];
	    
	    // Count the occurrences of each character in the input string 's'.
	    for (int i = 0; i < s.length(); ++i){
	        sCounts[s.charAt(i) - 'a']++;  
	    }

	    // StringBuilder to build the custom sorted string.
	    StringBuilder builder = new StringBuilder();

	    // Iterate through each character in the order string.
	    for (int i = 0; i < order.length(); ++i){
	        char c = order.charAt(i);
	        
	        // Append the character to the result string as many times as its count in the input string.
	        while (sCounts[c - 'a'] > 0){
	            builder.append(c);
	            sCounts[c - 'a']--;
	        }
	    }
	    
	    // Append any remaining characters (not present in the order string) to the result string.
	    for (int i = 0; i < 26; ++i){
	        while (sCounts[i] > 0){
	            builder.append((char)('a' + i));
	            sCounts[i]--;
	        }
	    }

	    // Return the final custom sorted string.
	    return builder.toString();
	}
	public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder str = new StringBuilder();
        for(char ch : order.toCharArray()){
            if(map.containsKey(ch)){
                str.append(String.valueOf(ch).repeat(Math.max(map.get(ch),0)));
                map.remove(ch);
            }
        }
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                str.append(String.valueOf(ch).repeat(Math.max(map.get(ch),0)));
                map.remove(ch);
            }
        }
        return str.toString();
        
    }

}
