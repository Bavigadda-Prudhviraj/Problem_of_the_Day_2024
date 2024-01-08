package com.prudhvi.leetcode.january;



public class Jan_8_RangeSumOfBST {  
	public int rangeSumBST(TreeNode root, int low, int high) {
		// Initialize an array to store the sum value (using an array to pass by reference)
		int[] sum = new int[1];
		// Call the recursive method to calculate the range sum
		rangeSum(root, sum, low, high);
		// Return the calculated sum
		return sum[0];
	}

	public static void rangeSum(TreeNode root, int[] sum, int low, int high) {
		// Base case: If the current node is null, return
		if (root == null) 
			return;
		// Check if the current node's value is within the specified range
		if (root.val >= low && root.val <= high) 
			// Add the current node's value to the sum
			sum[0] += root.val;
		// Recursively explore the left subtree if the value is greater than the low bound
		if (root.val > low) 
			rangeSum(root.left, sum, low, high);
		// Recursively explore the right subtree if the value is less than the high bound
		if (root.val < high) 
			rangeSum(root.right, sum, low, high);
		
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {}
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
