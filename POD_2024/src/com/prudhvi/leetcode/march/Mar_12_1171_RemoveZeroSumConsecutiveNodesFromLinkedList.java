package com.prudhvi.leetcode.march;

import java.util.HashMap;


public class Mar_12_1171_RemoveZeroSumConsecutiveNodesFromLinkedList {
	/**
	 * This method removes zero-sum sublists from a given linked list.
	 * It uses a HashMap to keep track of the prefix sums and their corresponding nodes, allowing for efficient detection and removal of zero-sum sublists.
	 *
	 * Time Complexity: O(n)
	 *   - n is the number of nodes in the linked list.
	 *   - The method iterates through the linked list once.
	 *   - Each iteration involves constant-time operations such as HashMap lookups, insertions, and removals.
	 *
	 * Space Complexity: O(n)
	 *   - The method uses a HashMap ('prefixSumNode') to store prefix sums and corresponding nodes.
	 *   - In the worst case, the HashMap may store all unique prefix sums, leading to a space complexity of O(n).
	 *   - Additionally, the method uses constant extra space for variables such as 'dummy', 'prefixSum', 'from', and 'movingNode'.
	 *
	 * @param head The head of the linked list.
	 * @return The linked list after removing zero-sum sublists.
	 */
	public ListNode removeZeroSumSublists(ListNode head) {
	    // HashMap to store prefix sums and their corresponding nodes.
	    HashMap<Integer, ListNode> prefixSumNode = new HashMap<>();
	    
	    // Dummy node to simplify list manipulation.
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    
	    // Initialize prefix sum and add a zero-sum entry to the HashMap for the dummy node.
	    int prefixSum = 0;
	    prefixSumNode.put(0, dummy);
	    
	    // Iterate through the linked list.
	    while (head != null) {
	        // Update the prefix sum.
	        prefixSum += head.val;
	        
	        // Check if the current prefix sum is already present in the HashMap.
	        if (prefixSumNode.containsKey(prefixSum)) {
	            // If found, remove nodes from the list to eliminate the zero-sum sublist.
	            ListNode from = prefixSumNode.get(prefixSum);
	            ListNode movingNode = from;
	            int currentSum = prefixSum;
	            
	            // Traverse the sublist and remove entries from the HashMap.
	            while (movingNode != head) {
	                movingNode = movingNode.next;
	                currentSum += movingNode.val;
	                
	                if (movingNode != head)
	                    prefixSumNode.remove(currentSum);
	            } 
	            
	            // Update the next pointer to remove the zero-sum sublist from the list.
	            from.next = head.next;
	        } else {
	            // If the prefix sum is not present, add it to the HashMap.
	            prefixSumNode.put(prefixSum, head);
	        }
	        
	        // Move to the next node in the linked list.
	        head = head.next;
	    }
	    
	    // Return the modified linked list.
	    return dummy.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}


}
