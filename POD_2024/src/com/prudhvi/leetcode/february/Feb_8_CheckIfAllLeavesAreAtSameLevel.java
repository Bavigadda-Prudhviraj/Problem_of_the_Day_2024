package com.prudhvi.leetcode.february;

import java.util.LinkedList;
import java.util.Queue;

public class Feb_8_CheckIfAllLeavesAreAtSameLevel {
	/**
	 * Checks if all leaf nodes in the binary tree are at the same level.
	 * 
	 * @TimeComplexity: O(N), where N is the number of nodes in the binary tree.
	 * Each node is processed once in the level order traversal.
	 * 
	 * @SpaceComplexity: O(M), where M is the maximum number of nodes at any level.
	 * The space required for the queue during level order traversal. In the worst
	 * case, the maximum number of nodes at a level is N/2. Thus, the space
	 * complexity is O(N/2) = O(N).
	 * 
	 * @param root The root of the binary tree.
	 * @return True if all leaf nodes are at the same level, false otherwise.
	 */
	public static boolean check(Node root) {
		// Check if the tree is empty, return true
		if (root == null)
			return true;
		// Queue for level order traversal
		Queue<Node> queue = new LinkedList<>();
		// Variables to track the current level and the last level where a leaf node was encountered
		int currentLevel = 0, lastLevel = -1;
		// Flag to alternate between checking levels
		boolean level = true;
		// Add the root to the queue
		queue.add(root);
		// Perform level order traversal
		while (!queue.isEmpty()) {
			int size = queue.size();
			// Process nodes at the current level
			for (int i = 0; i < size; i++) {
				Node currentNode = queue.poll();

				// Check if the current node is a leaf node
				if (currentNode.left == null && currentNode.right == null) {
					if (level) {
						// If this is the first leaf node encountered in the level, update lastLevel
						level = false;
						lastLevel = currentLevel;
					} else {
						// If this is not the first leaf node in the level, compare with lastLevel
						if (lastLevel != currentLevel) {
							return false; // Leaf nodes are not at the same level
						}
					}
				}
				// Enqueue the left and right children if they exist
				if (currentNode.left != null)
					queue.add(currentNode.left);
				if (currentNode.right != null)
					queue.add(currentNode.right);
			}
			// Move to the next level
			currentLevel++;
		}
		// All leaf nodes are at the same level
		return true;
	}
	
	class Node {
		int data;
		Node left, right;
		Node(int item) {
			data = item;
			left = right = null;
		}
	}

}
