package com.prudhvi.leetcode.march;

public class Mar_3_19_RemoveNthNodeFromEndOfList {
	/**
	 * Removes the N-th node from the end of a linked list.
	 *
	 * @param head The head of the linked list.
	 * @param n    The position of the node to remove from the end.
	 * @return The head of the linked list after removal.
	 *
	 * Time Complexity: O(N), where N is the number of nodes in the linked list.
	 * Space Complexity: O(1).
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    // Create a dummy node to simplify edge cases.
	    ListNode dummy = new ListNode();
	    dummy.next = head;

	    // Initialize two pointers, slow and fast, both starting from the dummy node.
	    ListNode slow = dummy;
	    ListNode fast = dummy;

	    // Move the fast pointer ahead by N steps to create a gap of N nodes between slow and fast.
	    for (int i = 0; i < n; i++) {
	        fast = fast.next;
	    }

	    // Move both pointers until the fast pointer reaches the end.
	    while (fast.next != null) {
	        fast = fast.next;
	        slow = slow.next;
	    }

	    // Remove the N-th node from the end by adjusting the next pointer of the slow pointer.
	    slow.next = slow.next.next;

	    // Return the head of the modified linked list.
	    return dummy.next;
	}


	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
