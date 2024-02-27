package com.prudhvi.leetcode.february;

public class Feb_27_543_DiameterOfBinaryTree {

	

	/**
	 * Calculates the diameter of a binary tree.
	 *
	 * @param root The root of the binary tree.
	 * @return The diameter of the binary tree.
	 *
	 * Time Complexity: O(n), where n is the number of nodes in the binary tree.
	 * Space Complexity: O(h), where h is the height of the binary tree.
	 */
	public int diameterOfBinaryTree(TreeNode root) {
	    int[] diameter = new int[] { Integer.MIN_VALUE };
	    diameterOfBT(root, diameter);
	    return diameter[0];
	}

	/**
	 * Helper method to calculate the diameter of a binary tree and update the diameter variable.
	 *
	 * @param root The root of the binary tree.
	 * @param diameter An array to store the diameter value.
	 * @return The height of the binary tree.
	 */
	public static int diameterOfBT(TreeNode root, int[] diameter) {
	    if (root == null) {
	        return -1;
	    }
	    // Recursively calculate the height of the left and right subtrees.
	    int leftHeight = diameterOfBT(root.left, diameter);
	    int rightHeight = diameterOfBT(root.right, diameter);
	    // Update the diameter with the sum of left and right subtree heights + 2.
	    diameter[0] = Math.max(diameter[0], leftHeight + rightHeight + 2);
	    // Return the height of the current subtree.
	    return Math.max(leftHeight, rightHeight) + 1;
	}


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
