package com.prudhvi.geeks_for_geeks.january;
//https://www.youtube.com/watch?v=nqrXHJWMeBc
//https://www.youtube.com/watch?v=0nF-BMYy7tc&t=216s
public class Jan_5_CountPossibleWaysToConstructBuildings {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(TotalWays(n));

	}
	public static int TotalWays(int N) {
	    // Initialize variables to keep track of the current building and space counts
	    long currentBuilding = 1;
	    long currentSpace = 1;
	    
	    // Define the modulo value to handle large numbers
	    long mod = 1000000007;

	    // Iterate through the positions starting from the second position
	    for (int i = 2; i <= N; i++) {
	        // Calculate the new count of buildings and spaces based on the pattern
	        long newBuilding = currentSpace;
	        long newSpace = (currentBuilding + currentSpace + mod) % mod;

	        // Update the current counts for the next iteration
	        currentBuilding = newBuilding;
	        currentSpace = newSpace;
	    }

	    // Calculate the total count of arrangements modulo 10^9 + 7
	    long total = (currentBuilding + currentSpace + mod) % mod;

	    // Return the squared total count as the final result
	    return (int) ((total * total) % mod);
	}



}
