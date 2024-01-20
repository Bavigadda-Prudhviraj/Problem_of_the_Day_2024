package com.prudhvi.geeks_for_geeks.january;


public class Jan_20_DistributeCandiesBinaryTree {

	/**
	 * Calculates the minimum steps needed to distribute candy among nodes in a binary tree.
	 *
	 * @param root The root of the binary tree.
	 * @return The minimum steps needed to distribute candy.
	 */
	static int steps;
	public static int distributeCandy(Node root) {
	    // Initialize the global variable to store the total steps
	    steps = 0;
	    // Call the recursive function to calculate the minimum steps
	    minSteps(root);
	    // Return the total steps
	    return steps;
	}

	/**
	 * Recursive helper function to calculate the minimum steps needed to distribute candy.
	 *
	 * @param root The current node in the binary tree.
	 * @return The excess candies at the current node.
	 */
	public static int minSteps(Node root) {
	    // Base case: If the current node is null, return 0
	    if (root == null) 
	        return 0;

	    // Recursively calculate the excess candies in the left subtree
	    int left = minSteps(root.left);
	    // Recursively calculate the excess candies in the right subtree
	    int right = minSteps(root.right);
	    // Update the global variable "steps" with the absolute sum of left and right
	    steps += Math.abs(left) + Math.abs(right);
	    // Return the total excess candies at the current node
	    return (left + right + root.data - 1);
	}


}
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}