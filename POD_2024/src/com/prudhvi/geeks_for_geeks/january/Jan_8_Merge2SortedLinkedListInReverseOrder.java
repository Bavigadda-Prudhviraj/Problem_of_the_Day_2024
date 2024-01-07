package com.prudhvi.geeks_for_geeks.january;
// https://www.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1
public class Jan_8_Merge2SortedLinkedListInReverseOrder {

	public Node mergeResult(Node node1, Node node2) {
	    // If the second linked list is null, reverse the first linked list and return
	    if (node2 == null) 
	        return reverseLinkedList(node1);
	    // If the first linked list is null, reverse the second linked list and return
	    if (node1 == null) 
	        return reverseLinkedList(node2);
	    // Create a dummy node as the head of the merged list
	    Node head = new Node(0);
	    Node temp = head;
	    // Traverse both linked lists and merge them
	    while (node1 != null && node2 != null) {
	        if (node1.data <= node2.data) {
	            temp.next = node1;
	            node1 = node1.next;
	        } else {
	            temp.next = node2;
	            node2 = node2.next;
	        }
	        temp = temp.next;
	    }
	    // If there are remaining nodes in the first linked list, append them
	    if (node1 != null) 
	        temp.next = node1;
	    // If there are remaining nodes in the second linked list, append them
	    else 
	        temp.next = node2;
	    // Reverse the merged list and return
	    return reverseLinkedList(head.next);
	}

	public static Node reverseLinkedList(Node head) {
	    // If the linked list is empty or has only one node, return the head
	    if (head == null || head.next == null) 
	        return head;
	    // Initialize pointers for reversing the linked list
	    Node currentHead = head;
	    Node reversedHead = null;

	    // Traverse the linked list and reverse it
	    while (currentHead != null) {
	        Node nextNode = currentHead.next;
	        currentHead.next = reversedHead;
	        reversedHead = currentHead;
	        currentHead = nextNode;
	    }
	    // Return the reversed head of the linked list
	    return reversedHead;
	}


	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	} 
    
}
	

