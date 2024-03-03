package com.prudhvi.geeks_for_geeks.march;

import java.util.Arrays;
import java.util.Comparator;

public class Mar_03_LargestNumberFormedFromAnArray {

	public static void main(String[] args) {
		int n = 5;
		String arr[] =  {"3", "30", "34", "5", "9"};
		System.out.println(printLargest(n, arr));
	}
	/**
	 * Prints the largest number by concatenating given strings.
	 *
	 * @param n   The number of strings.
	 * @param arr Array of strings.
	 * @return The largest number obtained by concatenating the strings.
	 *
	 * Time Complexity: O(N * M * log N), where N is the number of strings and M is the average length of strings.
	 * Space Complexity: O(N), where N is the number of strings.
	 */
	public static String printLargest(int n, String[] arr) {
	    // Create a comparator to sort strings in descending order of concatenated values.
	    Comparator<String> comparator = (String s1, String s2) -> {
	        String str1 = s1 + s2;
	        String str2 = s2 + s1;
	        return str2.compareTo(str1);
	    };

	    // Sort the array of strings using the comparator.
	    Arrays.sort(arr, comparator);

	    // Create a StringBuilder to concatenate the sorted strings.
	    StringBuilder largestNumber = new StringBuilder();
	    for (String num : arr) {
	        largestNumber.append(num);
	    }

	    // Check if the resulting number starts with '0', indicating it is '0' itself.
	    if (largestNumber.charAt(0) == '0') {
	        return "0";
	    }

	    // Return the largest number obtained by concatenating the strings.
	    return largestNumber.toString();
	}
 

}
