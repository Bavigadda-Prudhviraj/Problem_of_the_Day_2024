package com.prudhvi.leetcode.january;
import java.util.ArrayList;
import com.prudhvi.leetcode.january.Jan_8_RangeSumOfBST.TreeNode;

public class Jan_9_872_LeafSimilarTrees {
	/*
	Time Complexity:
		1. The `inOrderTraversal` function performs an in-order traversal of the binary tree, visiting each node once. 
		   The time complexity of the in-order traversal is O(N), where N is the total number of nodes in the tree.
		2. The function is called twice, once for each tree (`root1` and `root2`). 
		   Therefore, the overall time complexity is O(N1 + N2), where N1 and N2 are the numbers of nodes in the respective trees.

	Space Complexity:
		1. The space complexity is determined by the storage of the ArrayLists (`list1` and `list2`) during the in-order traversal.
		2. In the worst case, both trees are completely unbalanced (skewed), and the space required for each list is O(N), where N is the number of nodes in the respective tree.
		3. Therefore, the overall space complexity is O(N1 + N2), where N1 and N2 are the numbers of nodes in the respective trees.
	
	In summary, the time complexity is O(N1 + N2), and the space complexity is also O(N1 + N2), where N1 and N2 are the numbers of nodes in the respective trees. 
	The code efficiently compares the leaf nodes of two binary trees using in-order traversal and ArrayLists.
	 */
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
	    // Initialize lists to store leaf sequences of the two trees
	    ArrayList<Integer> list1 = new ArrayList<>();
	    ArrayList<Integer> list2 = new ArrayList<>();
	    // Perform in-order traversal to get the leaf sequences
	    inOrderTraversal(root1, list1);
	    inOrderTraversal(root2, list2);
	    // Check if the leaf sequences are equal
	    return list1.equals(list2);
	}

	// Recursive in-order traversal to collect leaf values
	public static void inOrderTraversal(TreeNode root, ArrayList<Integer> list) {
	    if (root == null)
	        return;
	    // Traverse left subtree
	    inOrderTraversal(root.left, list);
	    // If the node is a leaf, add its value to the list
	    if (root.left == null && root.right == null)
	        list.add(root.val);
	    // Traverse right subtree
	    inOrderTraversal(root.right, list);
	}
}
