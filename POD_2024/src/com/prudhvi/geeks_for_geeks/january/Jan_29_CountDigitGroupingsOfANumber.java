package com.prudhvi.geeks_for_geeks.january;

public class Jan_29_CountDigitGroupingsOfANumber {

	public static void main(String[] args) {
		String str = "1119";
		System.out.println(TotalCount(str));

	}
	/**
	 * Calculates the total count of subarrays with non-decreasing sums.
	 *
	 * @param str The input string containing digits.
	 * @return The total count of subarrays with non-decreasing sums.
	 *
	 * Time Complexity: O(n^2)
	 *   - The method uses dynamic programming to explore all possible subarrays.
	 *
	 * Space Complexity: O(n^2)
	 *   - The memoization table stores intermediate results for subproblems.
	 */
	public static int TotalCount(String str) {
	    int len = str.length();
	    Integer[][] dp = new Integer[len + 1][len * 9 + 1];
	    return helper(0, 0, str, dp);
	}

	/**
	 * Recursive helper function to calculate the total count of sub arrays.
	 *
	 * @param index        The current index in the input string.
	 * @param prevGrpSum   The sum of the previous group of digits.
	 * @param str          The input string containing digits.
	 * @param dp           Memorization table for dynamic programming.
	 * @return The total count of sub arrays with non-decreasing sums.
	 */
	public static int helper(int index, int prevGrpSum, String str, Integer[][] dp) {
	    // Base case: reached the end of the string, return 1.
	    if (index >= str.length())
	        return 1;

	    // If the result for the current state is already calculated, return it.
	    if (dp[index][prevGrpSum] != null)
	        return dp[index][prevGrpSum];

	    int currentSum = 0;
	    int result = 0;

	    // Explore all possible sub arrays starting from the current index.
	    for (int i = index; i < str.length(); i++) {
	        currentSum += (str.charAt(i) - '0');

	        // Check if the current sub array has a non-decreasing sum with the previous group.
	        if (prevGrpSum <= currentSum) {
	            // Recursively calculate the total count for the remaining part of the array.
	            result += helper(i + 1, currentSum, str, dp);
	        }
	    }

	    // Memorize the result for the current state and return it.
	    return dp[index][prevGrpSum] = result;
	}

    /*
	1.Initial Call: TotalCount("1119")
	
		index = 0, prevGrpSum = 0
		Calls helper(0, 0, "1119", dp)
	2.First Recursive Call: helper(0, 0, "1119", dp)
		
		index = 0, prevGrpSum = 0
		Iterating from i = 0 to 3 (length of "1119")
		Sub-call 1: helper(1, 1, "1119", dp) (currentSum = 1)
		Sub-call 2: helper(2, 2, "1119", dp) (currentSum = 1+1=2)
		Sub-call 3: helper(3, 3, "1119", dp) (currentSum = 1+1+1=3)
		Sub-call 4: helper(4, 4, "1119", dp) (currentSum = 1+1+1+9=12)
		Accumulates results from sub-calls and returns to the initial call.
	3.Second Recursive Call: helper(1, 1, "1119", dp)
	
		index = 1, prevGrpSum = 1
		Iterating from i = 1 to 3
		Sub-call 1: helper(2, 2, "1119", dp) (currentSum = 1)
		Sub-call 2: helper(3, 3, "1119", dp) (currentSum = 1+1=2)
		Sub-call 3: helper(4, 4, "1119", dp) (currentSum = 1+1+1=3)
		Accumulates results from sub-calls and returns to the first recursive call.
		... and so on, until all recursive calls are completed.
     Dry running the code
	TotalCount("1119")
	|
	|-- helper(1, 1, "1119")
	|   |
	|   |-- helper(2, 2, "1119")
	|   |   |
	|   |   |-- helper(3, 3, "1119")
	|   |       |
	|   |       |-- helper(4, 4, "1119")
	|   |
	|   |-- helper(3, 3, "1119")
	|   |   |
	|   |   |-- helper(4, 4, "1119")
	|   |
	|   |-- helper(4, 4, "1119")
	|
	|-- helper(2, 2, "1119")
	|   |
	|   |-- helper(3, 3, "1119")
	|       |
	|       |-- helper(4, 4, "1119")
	|
	|-- helper(3, 3, "1119")
	|   |
	|   |-- helper(4, 4, "1119")
	|
	|-- helper(4, 4, "1119")
	
	This diagram gives you an idea of the recursive calls made by the code and the relationships between them. Note that this is a simplified representation; the actual tree could be much larger for longer input strings
     */

}
