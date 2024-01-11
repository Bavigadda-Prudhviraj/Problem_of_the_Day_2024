package com.prudhvi.geeks_for_geeks.january;
/*
Given a non-negative integer S represented as a string, remove K digits from the number so that the new number is the smallest possible.
Note : The given num does not contain any leading zero.
Example 1: Input:
	S = "149811", K = 3
	Output:  111
	Explanation:  Remove the three digits  4, 9, and 8 to form the new number 111 which is smallest.
	Example 2: Input:
	S = "1002991", K = 3
	Output:  21
Explanation:  Remove the three digits 1(leading one), 9, and 9 to form the new number 21(Note that the output must not contain leading zeroes) which is the smallest.

Your Task:
You don't need to read input or print anything. Your task is to complete the function removeKdigits() which takes the string S and an integer K as input and returns the new number which is the smallest possible.

Expected Time Complexity: O(S).
Expected Auxiliary Space: O(S).

Constraints:
1<= K <= |S|<=106
 */
import java.util.Stack;

public class Jan_11_RemoveKDigits {

	public static void main(String[] args) {
		String S = "149811";
		int K = 3;
		System.out.println(removeKdigits(S, K));

	}
	public static String removeKdigits(String s, int k) {
	    // If the length of the string is equal to k, return "0"
	    if (s.length() == k) 
	        return "0";
	    // Use a stack to track the digits while removing k digits
	    Stack<Character> st = new Stack<>();
	    // Iterate through each character in the string
	    for (char ch : s.toCharArray()) {
	        // Remove digits from the stack while the current character is smaller and k > 0
	        while (st.size() > 0 && k > 0 && ch < st.peek()) {
	            st.pop();
	            k--;
	        }
	        // Skip leading zeros, but push non-zero digits onto the stack
	        if (st.isEmpty() && ch == '0') 
	            continue;
	        else 
	            st.push(ch);
	    }
	    // Remove remaining digits from the stack if needed
	    while (!st.isEmpty() && k > 0) {
	        st.pop();
	        k--;
	    }
	    // If the stack is empty, return "0"
	    if (st.size() == 0) 
	        return "0";
	    // Build the result string by reversing the characters in the stack
	    StringBuilder sb = new StringBuilder();
	    while (!st.isEmpty()) {
	        char ch = st.pop();
	        sb.append(ch);
	    }
	    // Reverse the result string and convert it to a string
	    return sb.reverse().toString();
	}


}
