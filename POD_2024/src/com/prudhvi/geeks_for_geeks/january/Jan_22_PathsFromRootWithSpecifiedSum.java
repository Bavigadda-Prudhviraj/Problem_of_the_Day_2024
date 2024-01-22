package com.prudhvi.geeks_for_geeks.january;

import java.util.ArrayList;



public class Jan_22_PathsFromRootWithSpecifiedSum {
	/**
	 * Finds all paths in a binary tree where the sum of node values equals a given target sum.
	 *
	 * @param root The root of the binary tree.
	 * @param sum  The target sum.
	 * @return A list of paths where the sum of node values equals the target sum.
	 */
	public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
	    // Initialize the list to store all paths
	    ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();

	    // Initialize the list to store the current path
	    ArrayList<Integer> currentPath = new ArrayList<>();

	    // Call the recursive function to find paths
	    findPath(root, sum, allPaths, currentPath);

	    // Return the list of all paths
	    return allPaths;
	}

	/**
	 * Recursive helper function to find paths in the binary tree.
	 *
	 * @param root        The current node in the recursion.
	 * @param sum         The remaining sum to achieve.
	 * @param allPaths    The list to store all paths.
	 * @param currentPath The list to store the current path.
	 */
	public static void findPath(Node root, int sum, ArrayList<ArrayList<Integer>> allPaths, ArrayList<Integer> currentPath) {
	    // Base case: If the current node is null, return
	    if (root == null) 
	        return;

	    // Update the remaining sum and add the current node to the current path
	    sum -= root.data;
	    currentPath.add(root.data);

	    // Check if the remaining sum is 0 and add the current path to the list of all paths
	    if (sum == 0) 
	        allPaths.add(new ArrayList<>(currentPath));

	    // Recursively explore the left and right subtrees
	    findPath(root.left, sum, allPaths, currentPath);
	    findPath(root.right, sum, allPaths, currentPath);

	    // Backtrack: Remove the last node from the current path before returning
	    currentPath.remove(currentPath.size() - 1);
	}

}
