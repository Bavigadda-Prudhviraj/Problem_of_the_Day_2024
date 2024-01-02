package com.prudhvi.geeks_for_geeks.january;

public class Jan_3_Smallest_window_containing_0_1_2 {

	public static void main(String[] args) {
		String string = "01212";
		System.out.println(smallestSubstring(string));

	}

	public static int smallestSubstring(String S) {
	    int n = S.length();
	    int zero = 0, one = 0, two = 0;

	    int start = 0, end = 0;
	    int minLengthString = Integer.MAX_VALUE;
	    
	    // Iterate through the string using the two-pointer technique
	    while (end < n) {
	    	
	        char character = S.charAt(end);
	        // Count occurrences of '0', '1', and '2'
	        if (character == '0') zero++;
	        else if (character == '1') one++;
	        else two++;

	        // Check if the current substring contains all three characters
	        //we don't get out of bound index because when start reaches the end of string all the occurrences will become 0;
	        while (zero > 0 && one > 0 && two > 0) {
	            // Update the minimum length of the substring
	            minLengthString = Math.min(minLengthString, end - start + 1);
	            
	            // Move the start pointer to reduce the length of the substring
	            char startChar = S.charAt(start);
	            if (startChar == '0') zero--;
	            else if (startChar == '1') one--;
	            else two--;
	            start++;
	        }
	        
	        // Move the end pointer to explore the next substring
	        end++;
	    }

	    // Return the length of the smallest substring containing all three characters
	    return (minLengthString == Integer.MAX_VALUE) ? -1 : minLengthString;
	}


}
