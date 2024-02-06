package com.prudhvi.geeks_for_geeks.february;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Feb_6_CountTheNodesAtDistanceKFromLeaf {
	
	/**
	 * Counts and returns the number of nodes at a distance k from leaf nodes in a binary tree.
	 *
	 * @param root The root of the binary tree.
	 * @param k The distance from leaf nodes to search for.
	 * @return The number of nodes at a distance k from leaf nodes.
	 *
	 * Time Complexity: O(N) - Visits each node once.
	 * Space Complexity: O(N) - Uses a HashSet and ArrayList to store nodes.
	 */
	public int printKDistantfromLeaf(Node root, int k) {
	    // Set to store unique nodes at a distance k from leaf nodes.
	    Set<Node> set = new HashSet<>();
	    // List to maintain the current path while traversing the tree.
	    ArrayList<Node> list = new ArrayList<>();
	    // Helper function to perform DFS and count nodes at distance k.
	    helper(root, set, list, k, 0);
	    // Return the count of unique nodes at distance k.
	    return set.size();
	}

	/**
	 * Helper function for DFS traversal and counting nodes at distance k.
	 *
	 * @param root The current node in the traversal.
	 * @param set Set to store unique nodes at a distance k from leaf nodes.
	 * @param list List to maintain the current path while traversing the tree.
	 * @param k The distance from leaf nodes to search for.
	 * @param level The current level or depth in the tree.
	 */
	public static void helper(Node root, Set<Node> set, ArrayList<Node> list, int k, int level) {
	    // Base case: If the current node is null, return.
	    if (root == null) {
	        return;
	    }
	    // Add the current node to the path.
	    list.add(root);

	    // Check if the current node is a leaf node.
	    if (root.left == null && root.right == null) {
	        // Check if the distance from the leaf node to the current level is equal to k.
	        if (level - k >= 0 && !set.contains(list.get(list.size() - k - 1))) {
	            // Add the node at a distance k from the leaf node to the set.
	            set.add(list.get(list.size() - k - 1));
	        }
	    }

	    // Recursively traverse the left and right subtrees.
	    helper(root.left, set, list, k, level + 1);
	    helper(root.right, set, list, k, level + 1);

	    // Remove the current node from the path (backtrack).
	    list.remove(list.size() - 1);
	}

	
	class Node{
		Node left;
		Node right;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}

}


