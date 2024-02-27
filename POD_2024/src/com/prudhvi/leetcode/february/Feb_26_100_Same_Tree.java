package com.prudhvi.leetcode.february;

public class Feb_26_100_Same_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Checks if two binary trees are the same.
	 *
	 * @param p The root of the first binary tree.
	 * @param q The root of the second binary tree.
	 * @return True if the two binary trees are the same, otherwise false.
	 *
	 * Time Complexity: O(min(m, n)), where m and n are the number of nodes in the two trees.
	 * Space Complexity: O(min(h1, h2)), where h1 and h2 are the heights of the two trees.
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
	    // If both nodes are null, they are the same.
	    if (p == null && q == null)
	        return true;

	    // If one of the nodes is null and the other is not, or their values are different, they are not the same.
	    if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val))
	        return false;
	    else
	        // Recursively check the left and right subtrees.
	        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
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
