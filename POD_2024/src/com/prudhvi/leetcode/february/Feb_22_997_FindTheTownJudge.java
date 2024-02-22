package com.prudhvi.leetcode.february;

public class Feb_22_997_FindTheTownJudge {

	public static void main(String[] args) {
		int n = 3;
		int[][] trust = { { 1, 3 }, { 2, 3 } };
		System.out.println(findJudge(n, trust));

	}

	/**
	 * Finds the judge in a town based on the trust relationships.
	 *
	 * @param n      The number of people in the town.
	 * @param trust  The array representing trust relationships where trust[i][0] trusts trust[i][1].
	 * @return The judge's label if found, otherwise -1.
	 *
	 * Time Complexity: O(T), where T is the length of the trust array.
	 * Space Complexity: O(N), where N is the number of people in the town.
	 */
	public static int findJudge(int n, int[][] trust) {
	    // Arrays to track the number of people trusting and being trusted.
	    int[] trusting = new int[n + 1];
	    int[] trusted = new int[n + 1];

	    // Count the trust relationships for each person.
	    for (int i = 0; i < trust.length; i++) {
	        trusting[trust[i][0]]++;
	        trusted[trust[i][1]]++;
	    }

	    int ans = -1;

	    // Iterate through each person to find the judge.
	    for (int i = 1; i <= n; i++) {
	        if (trusting[i] == 0 && trusted[i] == n - 1)
	            ans = i;
	    }

	    return ans;
	}


}
