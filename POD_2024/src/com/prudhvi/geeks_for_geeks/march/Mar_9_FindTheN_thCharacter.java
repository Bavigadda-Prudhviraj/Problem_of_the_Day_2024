package com.prudhvi.geeks_for_geeks.march;

public class Mar_9_FindTheN_thCharacter {

	public static void main(String[] args) {
		String s = "1100";
		int		r = 2, n = 3;
		System.out.println(nthCharacter(s, r, n));

	}

	/**
	 * Finds the nth character in a string generated using a specific pattern.
	 *
	 * @param s The initial string.
	 * @param r The number of repetitions.
	 * @param n The index of the character to be found.
	 * @return The nth character in the generated string.
	 *
	 * Time Complexity: O(r * n), where r is the number of repetitions and n is the length of the string.
	 * Space Complexity: O(n), as a new string is generated in each iteration.
	 */

	public static char nthCharacter(String s, int r, int n) {

	    // Base case: If the number of rounds 'r' is 0, return the character at index 'n' in the original string 's'.
	    if (r == 0)
	        return s.charAt(n);

	    // Iterate through 'r' rounds of pattern transformation.
	    for (int i = 0; i < r; i++) {
	        String temp = "";

	        // Generate the transformed string 'temp' based on the pattern.
	        for (int k = 0; k <= n; k++) {
	            // If the character at index 'k' in the original string 's' is '0', append "01" to 'temp';
	            // otherwise, append "10".
	            if (s.charAt(k) == '0')
	                temp = temp + "01";
	            else
	                temp = temp + "10";
	        }

	        // Update the original string 's' with the transformed string 'temp'.
	        s = temp;
	    }

	    // Return the character at the specified index 'n' in the final transformed string.
	    return s.charAt(n);
	}

}
