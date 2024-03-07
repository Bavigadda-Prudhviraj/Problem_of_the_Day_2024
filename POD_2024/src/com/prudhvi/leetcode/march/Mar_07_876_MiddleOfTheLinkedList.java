package com.prudhvi.leetcode.march;


public class Mar_07_876_MiddleOfTheLinkedList {
	/**
	 * Finds the middle node of a linked list.
	 *
	 * @param head The head of the linked list.
	 * @return The middle node.
	 *
	 * Time Complexity: O(N), where N is the number of nodes in the linked list.
	 * Space Complexity: O(1).
	 */
	public ListNode middleNode(ListNode head) {
	    // Check if the linked list is empty.
	    if (head == null) {
	        return head;
	    }

	    // Initialize two pointers, 'slow' and 'fast', both starting from the head.
	    ListNode slow = head;
	    ListNode fast = head;

	    // Iterate while 'fast' and 'fast.next' are not null.
	    while (fast != null && fast.next != null) {
	        // Move 'slow' one step.
	        slow = slow.next;
	        // Move 'fast' two steps.
	        fast = fast.next.next;
	    }

	    // Return the middle node.
	    return slow;
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
