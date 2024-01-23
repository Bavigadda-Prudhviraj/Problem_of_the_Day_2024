package com.prudhvi.geeks_for_geeks.january;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Jan_23_CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Finds the order of courses to be taken based on prerequisites.
	 *
	 * @param n               The total number of courses.
	 * @param m               The total number of prerequisites.
	 * @param prerequisites  A list of prerequisites where each pair [a, b] indicates course 'b' is a prerequisite for course 'a'.
	 * @return                An array representing the order of courses to be taken, or an empty array if it's impossible.
	 * @TimeComplexity      O(n + m), where n is the total number of courses and m is the total number of prerequisites.
	 * @SpaceComplexity     O(n), as the function uses arrays and queues to store prerequisites and course order.
	 */
	public static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
	    ArrayList<Integer>[] adj = new ArrayList[n];  // Adjacency list to represent the graph
	    for (int i = 0; i < n; i++)
	        adj[i] = new ArrayList<>();

	    int[] inDegree = new int[n];  // Array to store in-degrees of courses

	    // Build the graph and calculate in-degrees
	    for (int i = 0; i < m; i++) {
	        adj[prerequisites.get(i).get(1)].add(prerequisites.get(i).get(0));
	        inDegree[prerequisites.get(i).get(0)]++;
	    }

	    Queue<Integer> queue = new LinkedList<>();  // Queue for topological sorting
	    List<Integer> result = new ArrayList<>();   // List to store the order of courses

	    // Add courses with in-degree 0 to the queue
	    for (int i = 0; i < n; i++) {
	        if (inDegree[i] == 0)
	            queue.add(i);
	    }

	    // Perform topological sorting
	    while (!queue.isEmpty()) {
	        int index = queue.poll();
	        result.add(index);
	        for (int neighbor : adj[index]) {
	            inDegree[neighbor]--;
	            if (inDegree[neighbor] == 0) {
	                queue.add(neighbor);
	            }
	        }
	    }

	    // Check if all courses are included in the result
	    if (result.size() != n) {
	        return new int[0];  // If not, return an empty array
	    }

	    // Convert the result list to an array and return
	    return result.stream().mapToInt(Integer::intValue).toArray();
	}


}
