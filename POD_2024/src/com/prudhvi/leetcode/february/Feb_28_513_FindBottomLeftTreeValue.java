package com.prudhvi.leetcode.february;

import java.util.LinkedList;
import java.util.Queue;

public class Feb_28_513_FindBottomLeftTreeValue {

	/**
	 * Finds and returns the value of the bottom-left node in a binary tree.
	 *
	 * @param root The root of the binary tree.
	 * @return The value of the bottom-left node.
	 *
	 * @TimeComplexity: O(n), where n is the number of nodes in the binary tree.
	 * @SpaceComplexity: O(w), where w is the maximum width of the binary tree.
	 */
	public int findBottomLeftValue(TreeNode root) {
	    // Initialize a queue for level-order traversal.
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    int bottomLeft = -1;

	    // Perform level-order traversal.
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            TreeNode node = queue.poll();
	            // If it is the first node in the current level, update the bottomLeft value.
	            if (i == 0) 
	                bottomLeft = node.val;
	            // Enqueue the left and right children, if they exist.
	            if (node.left != null) 
	                queue.add(node.left);
	            
	            if (node.right != null) 
	                queue.add(node.right);
	            
	        }
	    }
	    return bottomLeft;
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
