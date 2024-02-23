package com.prudhvi.leetcode.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Feb_23_787_CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		int n = 4;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		int src = 0;
		int dst = 3;
		int k = 1;
		System.out.println(findCheapestPrice(n, flights, src, dst, k));

	}

	/**
	 * Finds the cheapest price to reach the destination with at most k stops.
	 *
	 * @param n      The total number of cities.
	 * @param flights The flight information as a 2D array where each row represents [source, destination, cost].
	 * @param src    The source city.
	 * @param dst    The destination city.
	 * @param k      The maximum number of stops allowed.
	 * @return The cheapest price to reach the destination with at most k stops.
	 *
	 * Time Complexity: O(n * k), where n is the total number of cities and k is the maximum number of stops.
	 * Space Complexity: O(n), where n is the total number of cities.
	 */
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	    // Array to store the minimum distance from source to each city.
	    int[] distance = new int[n];
	    Arrays.fill(distance, Integer.MAX_VALUE);

	    // Adjacency list to represent the flights between cities.
	    ArrayList<FlightPair>[] adj = new ArrayList[n + 1];

	    // Initializing the adjacency list.
	    for (int i = 0; i < adj.length; i++) {
	        adj[i] = new ArrayList<>();
	    }

	    // Building the adjacency list from the flight information.
	    for (int i = 0; i < flights.length; i++) {
	        int source = flights[i][0];
	        int destination = flights[i][1];
	        int cost = flights[i][2];
	        adj[source].add(new FlightPair(destination, cost));
	    }

	    // Queue for BFS traversal.
	    Queue<FlightPair> queue = new LinkedList<>();

	    // Starting from the source city with a cost of 0.
	    distance[src] = 0;
	    queue.add(new FlightPair(src, 0));
	    int steps = 0;

	    // Performing BFS to find the shortest distance to reach the destination with at most k stops.
	    while (!queue.isEmpty() && steps <= k) {
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            FlightPair currentStation = queue.poll();
	            ArrayList<FlightPair> connectedStation = adj[currentStation.destination];
	            for (FlightPair neighbor : connectedStation) {
	                int dest = neighbor.destination;
	                int cost = neighbor.cost;
	                int newCost = currentStation.cost + cost;
	                if (distance[dest] > newCost) {
	                    // Update the distance if a shorter path is found.
	                    distance[dest] = newCost;
	                    queue.add(new FlightPair(dest, newCost));
	                }
	            }
	        }
	        steps++;
	    }

	    // Return the minimum distance to the destination or -1 if no path is found.
	    return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
	}
}
/**
 * Represents a pair of destination and cost for a flight.
 */
class FlightPair {
	int destination;
	int cost;

	public FlightPair(int destination, int cost) {
		this.destination = destination;
		this.cost = cost;
	}
}
