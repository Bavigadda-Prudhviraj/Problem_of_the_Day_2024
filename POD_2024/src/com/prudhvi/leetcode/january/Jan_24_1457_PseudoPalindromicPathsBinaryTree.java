package com.prudhvi.leetcode.january;

import com.prudhvi.leetcode.january.Jan_8_RangeSumOfBST.TreeNode;

public class Jan_24_1457_PseudoPalindromicPathsBinaryTree {

	/**
	 * Calculates the number of pseudo-palindromic paths in a binary tree.
	 *
	 * @param root  The root node of the binary tree.
	 * @return The count of pseudo-palindromic paths in the tree.
	 * 
	 * Time Complexity: O(N), where N is the number of nodes in the binary tree.
	 *   - We visit each node once during the recursive traversal.
	 * Space Complexity: O(H), where H is the height of the binary tree (recursive call stack).
	 *   - The maximum depth of the recursive call stack is the height of the tree.
	 */
	public int pseudoPalindromicPaths(TreeNode root) {
	    int[] count = { 0 };
	    findPseudoPalindromicPaths(root, count, 0);
	    return count[0];
	}

	/**
	 * Recursive helper method to find pseudo-palindromic paths in a binary tree.
	 *
	 * @param root  The current node being processed.
	 * @param count The array to store the count of pseudo-palindromic paths.
	 * @param bit   The bitwise representation of digit occurrences along the path.
	 * 
	 * Time Complexity: O(N), where N is the number of nodes in the binary tree.
	 *   - We visit each node once during the recursive traversal.
	 * Space Complexity: O(H), where H is the height of the binary tree (recursive call stack).
	 *   - The maximum depth of the recursive call stack is the height of the tree.
	 */
	public void findPseudoPalindromicPaths(TreeNode root, int[] count, int bit) {
	    if (root == null)
	        return;

	    // XOR the bit corresponding to the current node's value
	    bit ^= (1 << root.val);

	    // Check if the current node is a leaf (both left and right are null)
	    if (root.left == null && root.right == null) {
	        // Check if the XOR of bits has at most one set bit
	        if ((bit & (bit - 1)) == 0) {
	            count[0]++; // Increment count if it's a pseudo-palindromic path
	        }
	    }

	    // Recursively explore the left and right subtrees
	    findPseudoPalindromicPaths(root.left, count, bit);
	    findPseudoPalindromicPaths(root.right, count, bit);

	    // Backtrack by XORing again to undo the change
	    bit ^= (1 << root.val);
	}



}
