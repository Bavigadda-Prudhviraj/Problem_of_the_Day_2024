package com.prudhvi.geeks_for_geeks.february;

import java.util.LinkedList;
import java.util.Queue;



public class Feb_7_MinDistanceBetweenTwoGivenNodesOfBinaryTree {
	/**
	 * Finds the distance between two nodes with values 'a' and 'b' in a binary tree.
	 *
	 * @param root The root of the binary tree.
	 * @param a    The value of the first node.
	 * @param b    The value of the second node.
	 * @return The distance between the nodes 'a' and 'b'.
	 *
	 * Time Complexity: O(N) - N is the number of nodes in the binary tree.
	 * Space Complexity: O(N) - N is the maximum number of nodes at any level in the binary tree.
	 */
	public int findDist(Node root, int a, int b) {
	    // Find the Lowest Common Ancestor (LCA) of nodes 'a' and 'b'.
	    Node lca = lca(root, a, b);
	    
	    // Find the level (distance from the root) of nodes 'a' and 'b' relative to the LCA.
	    int levelA = findLevel(lca, a);
	    int levelB = findLevel(lca, b);

	    // Return the sum of the levels, which represents the distance between nodes 'a' and 'b'.
	    return levelA + levelB;
	}

	
	/**
	 * Finds the level (distance from the root) of a given node in the binary tree using BFS.
	 *
	 * @param root The root of the binary tree.
	 * @param data The value of the node whose level is to be found.
	 * @return The level of the node with the specified value.
	 *
	 * Time Complexity: O(N) - N is the number of nodes in the binary tree.
	 * Space Complexity: O(N) - N is the maximum number of nodes at any level in the binary tree.
	 */
	public static int findLevel(Node root, int data) {
	    // Create a queue for BFS traversal.
	    Queue<Node> queue = new LinkedList<>();

	    // Initialize the level to 0.
	    int level = 0;

	    // Enqueue the root node to start BFS.
	    queue.add(root);

	    // Perform BFS to find the level of the node with the specified value.
	    while (!queue.isEmpty()) {
	        // Get the number of nodes at the current level.
	        int size = queue.size();

	        // Process nodes at the current level.
	        for (int i = 0; i < size; i++) {
	            // Dequeue a node.
	            Node node = queue.poll();

	            // Check if the node has the specified value.
	            if (node.data == data)
	                return level;

	            // Enqueue the left child if it exists.
	            if (node.left != null) {
	                queue.add(node.left);
	            }

	            // Enqueue the right child if it exists.
	            if (node.right != null) {
	                queue.add(node.right);
	            }
	        }

	        // Increment the level for the next iteration.
	        level++;
	    }

	    // If the node is not found, return -1.
	    return -1;
	}


	/**
	 * Finds the Lowest Common Ancestor (LCA) of two nodes in a binary tree.
	 *
	 * @param root The root of the binary tree.
	 * @param n1   The value of the first node.
	 * @param n2   The value of the second node.
	 * @return The LCA of the two nodes.
	 *
	 * Time Complexity: O(N) - N is the number of nodes in the binary tree.
	 * Space Complexity: O(H) - H is the height of the binary tree (recursion stack space).
	 */
	public Node lca(Node root, int n1, int n2) {
	    // Base case: If the root is null, return null.
	    if (root == null)
	        return null;

	    // If the current root data matches either of the nodes, it is the LCA.
	    if (root.data == n1 || root.data == n2)
	        return root;

	    // Recursively find the LCA in the left and right subtrees.
	    Node left = lca(root.left, n1, n2);
	    Node right = lca(root.right, n1, n2);

	    // If both left and right are not null, the current root is the LCA.
	    if (left != null && right != null)
	        return root;
	    // If right is null and left is not null, the LCA is in the left subtree.
	    else if (right == null && left != null)
	        return left;
	    // If left is null and right is not null, the LCA is in the right subtree.
	    else
	        return right;
	}


    
    class Node
    {
        int data;
        Node left, right;
       Node(int item)    {
            data = item;
            left = right = null;
        }
    } 

}
