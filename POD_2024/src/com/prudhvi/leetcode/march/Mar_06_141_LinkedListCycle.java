package com.prudhvi.leetcode.march;

public class Mar_06_141_LinkedListCycle {

	/**
	 * Checks if a linked list has a cycle using the two-pointer approach.
	 *
	 * @param head The head of the linked list.
	 * @return True if a cycle is present, otherwise false.
	 *
	 * Time Complexity: O(N), where N is the number of nodes in the linked list.
	 * Space Complexity: O(1).
	 */
	public boolean hasCycle(ListNode head) {
	    // Check for null or a single node.
	    if (head == null || head.next == null) {
	        return false;
	    }

	    // Initialize two pointers, slowPointer moves one step at a time, and fastPointer moves two steps at a time.
	    ListNode slowPointer = head;
	    ListNode fastPointer = head;

	    // Iterate until the fastPointer reaches the end or encounters a cycle.
	    while (fastPointer.next != null && fastPointer.next.next != null) {
	        // Move the slowPointer one step.
	        slowPointer = slowPointer.next;
	        // Move the fastPointer two steps.
	        fastPointer = fastPointer.next.next;

	        // If the slowPointer meets the fastPointer, a cycle is detected.
	        if (slowPointer == fastPointer) {
	            return true;
	        }
	    }

	    // If the loop completes without detecting a cycle, return false.
	    return false;
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
