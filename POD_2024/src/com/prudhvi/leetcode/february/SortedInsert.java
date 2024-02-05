package com.prudhvi.leetcode.february;



public class SortedInsert {

	
	/**
	 * Inserts a new node with the given data into a sorted circular linked list.
	 *
	 * @param head The head of the sorted circular linked list.
	 * @param data The data to be inserted into the linked list.
	 * @return The head of the updated sorted circular linked list after insertion.
	 *
	 * Time Complexity: O(n) - In the worst case, it iterates through the entire list.
	 * Space Complexity: O(1) - The function uses a constant amount of space for variables.
	 */
	public Node sortedInsert(Node head, int data) {
	    // Check if the linked list is empty.
	    if (head == null) {
	        Node newNode = new Node(data);
	        newNode.next = newNode;
	        return newNode;
	    }

	    Node current = head;

	    // Traverse the circular linked list to find the appropriate position for insertion.
	    while (true) {
	        // Check if the data should be inserted between the current and next nodes.
	        if (data >= current.data && data <= current.next.data) {
	            Node newNode = new Node(data);
	            newNode.next = current.next;
	            current.next = newNode;
	            break;
	        }

	        // Check if there is more than one node in the linked list.
	        if (current.next != head) {
	            current = current.next;
	        } else {
	            // Insert the new node at the end of the circular linked list.
	            Node newNode = new Node(data);
	            current.next = newNode;
	            newNode.next = head;

	            // Update the head if the new node should be the new head.
	            if (data <= head.data) {
	                head = newNode;
	            }
	            break;
	        }
	    }

	    return head;
	}


}
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
	}
}

