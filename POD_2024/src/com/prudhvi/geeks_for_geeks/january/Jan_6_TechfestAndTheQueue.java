package com.prudhvi.geeks_for_geeks.january;

public class Jan_6_TechfestAndTheQueue {

	public static void main(String[] args) {
		int a = 9;
		int b = 12;
		System.out.println(sumOfPowers(a, b));

	}
	/*
	Time Complexity:
			1. The code initializes an array `sieve` using the Sieve of Eratosthenes to store the smallest prime factor for each number up to `maxNum`. The Sieve of Eratosthenes has a time complexity of O(N log log N), where N is the value of `maxNum`.
			2. The code then iterates over the numbers in the range [a, b] and calculates the sum of powers for each number. For each number, it factorsize it using the previously computed `sieve` array. 
			   The factorization loop takes time proportional to the number of prime factors, which can be considered O(log i) for each number i in the given range.
		Therefore, the overall time complexity is O(N log log N) + O((b - a + 1)log b).
	
	Space Complexity:
			1. The space complexity is determined by the `sieve` array, which has a size of `maxNum + 1`. Therefore, the space complexity is O(N).
			2. Additional space is used for integer variables and loop indices, but they are constant with respect to the input.
		Therefore, the overall space complexity is O(N).
	
	In summary, the time complexity is O(N log log N) + O((b - a + 1)log b), and the space complexity is O(N). The dominant factor in time complexity is the Sieve of Eratosthenes for generating prime factors.
	 */
	public static long sumOfPowers(long a, long b) {
		// Determine the maximum number in the range
		int maxNum = (int) Math.max(a, b);
		// Array to store the smallest prime factor for each number
		Integer[] sieve = new Integer[maxNum + 1];
		// Build the Sieve of Eratosthenes
		for (int i = 2; i <= maxNum; i++) {
			if (sieve[i] != null)
				continue;
			sieve[i] = i;
			for (int j = i + i; j <= maxNum; j += i) 
				sieve[j] = sieve[j] == null ? i : Math.min(sieve[j], i);
		}

		int ans = 0;
		// Calculate the sum of prime factorization powers for each number in the range
		for (int i = (int) Math.min(a, b); i <= maxNum; i++) {
			int cur = i;
			while (cur > 1) {
				++ans;
				cur /= sieve[cur];
			}
		}
		// Return the total sum of prime factorization powers
		return ans;
	}


}
