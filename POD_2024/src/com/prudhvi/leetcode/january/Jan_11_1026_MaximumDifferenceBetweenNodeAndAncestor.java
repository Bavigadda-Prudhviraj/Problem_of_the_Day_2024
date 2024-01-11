package com.prudhvi.leetcode.january;
import com.prudhvi.leetcode.january.Jan_8_RangeSumOfBST.TreeNode;

public class Jan_11_1026_MaximumDifferenceBetweenNodeAndAncestor {
	/*
	Time Complexity:
		- The recursive function `maxAncestorDifference` is called for each node in the binary tree exactly once.
		- The time complexity is O(N), where N is the number of nodes in the binary tree.
	
	Space Complexity:
		- The space complexity is determined by the recursion stack during the recursive calls.
		- In the worst case, the maximum depth of the recursion stack is equal to the height of the binary tree. For a balanced binary tree, the height is (log N), and in the worst case (unbalanced tree), it can be O(N).
		- Therefore, the space complexity is O(N) in the worst case.
		- Additionally, the algorithm uses a constant amount of extra space for variables (`currentMax`, `currentMin`, `leftDifference`, and `rightDifference`).
	
	In summary, the time complexity is O(N), and the space complexity is O(N), where (N) is the number of nodes in the binary tree. The algorithm efficiently traverses the tree to find the maximum difference between any node and its ancestors.
	 */
	public int maxAncestorDiff(TreeNode root) {
	    // Call the recursive method to calculate the maximum ancestor difference
	    return maxAncestorDifference(root, root.val, root.val);
	}

	public static int maxAncestorDifference(TreeNode node, int currentMax, int currentMin) {
	    // Base case: if the node is null, return the absolute difference between max and min values
	    if (node == null) 
	        return Math.abs(currentMax - currentMin);

	    // Update the currentMax and currentMin based on the current node's value
	    currentMax = Math.max(node.val, currentMax);
	    currentMin = Math.min(node.val, currentMin);

	    // Recursively calculate the maximum ancestor difference in the left and right subtrees
	    int leftDifference = maxAncestorDifference(node.left, currentMax, currentMin);
	    int rightDifference = maxAncestorDifference(node.right, currentMax, currentMin);

	    // Return the maximum difference between the left and right subtrees
	    return Math.max(leftDifference, rightDifference);
	}


}
