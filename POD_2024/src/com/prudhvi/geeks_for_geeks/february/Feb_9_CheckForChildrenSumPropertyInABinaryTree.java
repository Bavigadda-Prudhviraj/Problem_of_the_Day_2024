package com.prudhvi.geeks_for_geeks.february;

public class Feb_9_CheckForChildrenSumPropertyInABinaryTree {
	/**
	 * Checks if the sum property holds for a given binary tree.
	 * 
	 * The sum property states that for every node in the tree,
	 * the value of the node is equal to the sum of the values
	 * of its left and right subtrees (if they exist).
	 * 
	 * @TimeComplexity: O(n), where n is the number of nodes in the tree.
	 *                  The function visits each node once.
	 * 
	 * @SpaceComplexity: O(h), where h is the height of the tree.
	 *                   The space used by the recursive call stack.
	 * 
	 * @param root The root of the binary tree.
	 * @return 1 if the sum property holds, 0 otherwise.
	 */
	public static int isSumProperty(Node root) {
	    // Base case: an empty tree satisfies the sum property.
	    if (root == null) 
	        return 1;
	    
	    // Check if the sum property holds for the current node.
	    if (((root.left != null) && (root.right != null)) && (root.data == (root.left.data + root.right.data))) {
	        // Recursively check the sum property for the left and right subtrees.
	        int left = isSumProperty(root.left);
	        int right = isSumProperty(root.right);
	        return (left & right);
	    } else if (root.left != null && root.right == null && (root.data == root.left.data)) {
	        // If there is no right subtree, check the sum property for the left subtree only.
	        int left = isSumProperty(root.left);
	        int right = isSumProperty(root.right);
	        return (left & right);
	    } else if (root.right != null && root.left == null && (root.data == root.right.data)) {
	        // If there is no left subtree, check the sum property for the right subtree only.
	        int left = isSumProperty(root.left);
	        int right = isSumProperty(root.right);
	        return (left & right);
	    } else if ((root.left == null) && (root.right == null)) 
	        // Leaf nodes satisfy the sum property.
	        return 1;
	      else 
	        // If none of the conditions are met, the sum property does not hold.
	        return 0;
	    
	}

	class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

}
