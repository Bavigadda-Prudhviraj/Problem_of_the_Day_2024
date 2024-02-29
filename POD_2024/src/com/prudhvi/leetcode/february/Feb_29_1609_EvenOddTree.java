package com.prudhvi.leetcode.february;

import java.util.LinkedList;
import java.util.Queue;

public class Feb_29_1609_EvenOddTree {
	/**
	 * Checks if the given binary tree is an even-odd tree.
	 *
	 * @param root The root of the binary tree.
	 * @return True if the tree is an even-odd tree, otherwise false.
	 *
	 * @TimeComplexity: O(N), where N is the number of nodes in the tree.
	 * @SpaceComplexity: O(W), where W is the maximum width of the tree.
	 */
	public boolean isEvenOddTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 0;

		while (!queue.isEmpty()) {
			int minMax = (level == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				// Check for the first level (odd values).
				if (level == 0) {
					// Return false if the values are not strictly increasing or are even.
					if ((minMax >= node.val) || (level == 0 && node.val % 2 == 0))
						return false;
				}
				// Check for the second level (even values).
				else if (level == 1) {
					// Return false if the values are not strictly decreasing or are odd.
					if ((minMax <= node.val) || (level == 1 && node.val % 2 == 1))
						return false;
				}

				minMax = node.val;

				// Add the children to the queue.
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}

			// Switch the level for the next iteration.
			level = (level == 0) ? 1 : 0;
		}

		return true;
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
