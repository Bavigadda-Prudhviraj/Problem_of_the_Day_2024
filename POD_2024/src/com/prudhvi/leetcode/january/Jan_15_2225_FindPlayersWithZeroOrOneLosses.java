package com.prudhvi.leetcode.january;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Jan_15_2225_FindPlayersWithZeroOrOneLosses {

	public static void main(String[] args) {
		int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
		System.out.println(findWinners(matches));

	}
    /**
     * Finds the winners in a set of matches.
     *
     * @param matches An array representing the matches where each element is an array [win, loss].
     * @return A list containing two lists - the first list contains players who never lost, and
     *         the second list contains players who lost only one match.
     * @TimeComplexity : 2 * O(n log n), we are sorting the two arrays at the end;
     * @SpaceComplexity : O(n + m), n are the never lost people and, m are the people who lost one match.
     */
    public static List<List<Integer>> findWinners(int[][] matches) {
        // Frequency of losses for each player
        HashMap<Integer, Integer> lossMatchFrequency = new HashMap<>();

        // Count the frequency of losses for each player
        for (int i = 0; i < matches.length; i++) {
            int lossPlayer = matches[i][1];
            lossMatchFrequency.put(lossPlayer, lossMatchFrequency.getOrDefault(lossPlayer, 0) + 1);
        }

        // Lists to store players who never lost and players who lost only one match
        List<Integer> neverLost = new ArrayList<>();
        List<Integer> lostOneMatch = new ArrayList<>();

        // Iterate through matches to populate the lists
        for (int i = 0; i < matches.length; i++) {
            int winPlayer = matches[i][0];
            int lossPlayer = matches[i][1];

            // If the winning player is not in the loss frequency map, they never lost
            if (!lossMatchFrequency.containsKey(winPlayer)) {
                neverLost.add(winPlayer);
                // Assume they lost one match for sorting purposes
                lossMatchFrequency.put(winPlayer, 1);
            }

            // If the losing player has only lost one match, add them to the list
            if (lossMatchFrequency.get(lossPlayer) == 1) {
                lostOneMatch.add(lossPlayer);
            }
        }

        // Sort the lists in ascending order
        Collections.sort(neverLost);
        Collections.sort(lostOneMatch);

        // Create a list to store the result and add the two lists
        List<List<Integer>> winners = new ArrayList<>();
        winners.add(neverLost);
        winners.add(lostOneMatch);

        return winners;
    }

}
