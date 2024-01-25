package com.prudhvi.geeks_for_geeks.january;

import java.util.LinkedList;
import java.util.Queue;
//https://www.youtube.com/watch?v=Pp7zLmmLcms
public class Jan_25_ShortestPrimePath {

	public static void main(String[] args) {
		int num1 = 1033, num2 = 8179;
		System.out.println(solve(num1, num2));

	}
	/**
	 * Finds the minimum number of steps required to transform Num1 into Num2, where each step involves changing
	 * one digit at a time, and the intermediate numbers must be prime and four-digit numbers.
	 *
	 * @param Num1 The starting number.
	 * @param Num2 The target number.
	 * @return The minimum number of steps required, or -1 if it is not possible.
	 * @TimeComplexity O(n*log(log(n))) sieve, where N is the range of four-digit numbers (1000 to 9999).
	 * @SpaceComplexity O(1000), for the boolean arrays to track prime numbers and visited numbers.
	 */
	public static int solve(int Num1, int Num2) {
	    boolean[] sieve = new boolean[10000];
	    boolean[] primeCheck = new boolean[10000];

	    // Sieve of Eratosthenes to mark non-prime numbers
	    for (int p = 2; p * p < 10000; p++) {
	        if (!sieve[p]) {
	            for (int i = p * p; i < 10000; i += p)
	                sieve[i] = true;
	        }
	    }

	    // Breadth-First Search using a queue to find the minimum steps
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[]{Num1, 0});
	    sieve[Num1] = true;

	    while (!queue.isEmpty()) {
	        int[] num = queue.poll();
	        // If the target number is reached, return the number of steps
	        if (num[0] == Num2)
	            return num[1];

	        // Convert the number to a character array for digit manipulation
	        char[] arr = String.valueOf(num[0]).toCharArray();

	        // Iterate through each digit of the number
	        for (int i = 0; i < 4; i++) {
	            // Try changing the digit to every possible digit (0 to 9)
	            for (char ch = '0'; ch <= '9'; ch++) {
	                char backtrackChar = arr[i];
	                arr[i] = ch;
	                // Create a new number after changing the digit
	                int newNum = Integer.parseInt(new String(arr));
	                // Check if the new number is prime, not visited, and a four-digit number
	                if (!primeCheck[newNum] && !sieve[newNum] && newNum >= 1000) {
	                    primeCheck[newNum] = true;
	                    queue.add(new int[]{newNum, num[1] + 1});
	                }
	                arr[i] = backtrackChar;
	            }
	        }
	    }

	    // If the target number is not reachable, return -1
	    return -1;
	}


}
