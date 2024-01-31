package com.prudhvi.leetcode.january;

import java.util.Arrays;
import java.util.Stack;

public class Jan_31_739_DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures = {73,74,75,71,69,72,76,73};
		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));

	}

	/**
	 * Calculates the number of days one must wait until a warmer day for each day in the given temperatures.
	 *
	 * @param temperatures Array representing daily temperatures.
	 * @return An array representing the number of days until a warmer day for each corresponding day.
	 *
	 * @TimeComplexity: O(n)
	 *   - The method iterates through each day once.
	 *   - Each day is processed at most twice in the stack.
	 *
	 * @SpaceComplexity: O(n)
	 *   - The stack stores indices of the days, and in the worst case, all days are stored in the stack.
	 */
	public static int[] dailyTemperatures(int[] temperatures) {
	    int n = temperatures.length;
	    int[] days = new int[n];
	    Stack<Integer> stack = new Stack<>();
	    stack.add(n - 1);

	    // Iterate backward through the temperatures.
	    for (int i = n - 2; i >= 0; i--) {
	        // Pop elements from the stack until finding a warmer day.
	        while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) 
	            stack.pop();
	        // If there is a warmer day, calculate the number of days until it.
	        if (!stack.isEmpty()) 
	            days[i] = stack.peek() - i;
	        // Add the current day to the stack.
	        stack.add(i);
	    }
	    // The resulting array contains the number of days until a warmer day for each day.
	    return days;
	}


}
