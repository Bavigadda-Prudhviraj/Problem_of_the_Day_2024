package com.prudhvi.geeks_for_geeks.february;

public class Feb_18_SumOfLeafNodesInBST {
	/**
	 * Computes the sum of leaf nodes in a binary tree.
	 *
	 * @param root The root of the binary tree.
	 * @return The sum of leaf nodes in the binary tree.
	 *
	 * Time Complexity: O(N), where N is the number of nodes in the binary tree.
	 * Space Complexity: O(1), additional space is used for the sum array.
	 */
	public static int sumOfLeafNodes(Node root) {
	    // Initialize an array to store the sum of leaf nodes.
	    int[] sum = new int[1];

	    // Call the helper method to perform the depth-first traversal.
	    leafSum(root, sum);

	    // Return the computed sum of leaf nodes.
	    return sum[0];
	}

	/**
	 * Helper method to perform a depth-first traversal and calculate the sum of leaf nodes.
	 *
	 * @param root The current node in the traversal.
	 * @param sum  The array to store the sum of leaf nodes.
	 */
	public static void leafSum(Node root, int[] sum) {
	    // Base case: If the current node is null, return.
	    if (root == null)
	        return;

	    // If the current node is a leaf node, add its value to the sum.
	    if (root.left == null && root.right == null)
	        sum[0] += root.data;

	    // Recursively call the method for the left and right children.
	    leafSum(root.left, sum);
	    leafSum(root.right, sum);
	}
	
    
    class Node
    {
        int data;
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }

}
