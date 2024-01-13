package com.prudhvi.geeks_for_geeks.january;

import com.prudhvi.geeks_for_geeks.january.Jan_8_Merge2SortedLinkedListInReverseOrder.Node;

public class Jan_13_InsertionSortForSinglyLinkedList {

	/**
	 * Sorts a linked list using the insertion sort algorithm.
	 *
	 * @param head_ref The head of the linked list to be sorted.
	 * @return The head of the sorted linked list.
	 * @TimeComplexity :O(n^2) where n is the number of nodes in the linked list.
	 * @SpaceComplexity : O(1) since the sorting is done in-place.
	 */
	public static Node insertionSort(Node head_ref) {
	    // Check if the list is empty or has only one element
	    if (head_ref == null || head_ref.next == null)
	        return head_ref;

	    // Initialize the sorted linked list
	    Node sortedHead = null;

	    // Iterate through the original linked list
	    while (head_ref != null) {
	        // Save the reference to the next node
	        Node nextNode = head_ref;
	        // Move the head of the original list to the next node
	        head_ref = head_ref.next;
	        // Disconnect the next node from the original list
	        nextNode.next = null;
	        // Insert the next node into the sorted linked list
	        sortedHead = insertNode(sortedHead, nextNode);
	    }
	    // Return the head of the sorted linked list
	    return sortedHead;
	}

	/**
	 * Inserts a node into a sorted linked list.
	 *
	 * @param sortedNode The head of the sorted linked list.
	 * @param newNode    The node to be inserted.
	 * @return The head of the sorted linked list after insertion.
	 */
	public static Node insertNode(Node sortedNode, Node newNode) {
	    // Check if the sorted list is empty or the new node should be the new head
	    if (sortedNode == null || sortedNode.data >= newNode.data) {
	        // Insert the new node at the beginning
	        newNode.next = sortedNode;
	        sortedNode = newNode;
	    } else {
	        // Traverse the sorted list to find the correct position for the new node
	        Node tempNode = sortedNode;
	        while (tempNode.next != null && tempNode.next.data < newNode.data) {
	            tempNode = tempNode.next;
	        }
	        // Insert the new node into the sorted list
	        newNode.next = tempNode.next;
	        tempNode.next = newNode;
	    }
	    // Return the head of the sorted linked list after insertion
	    return sortedNode;
	}


}
