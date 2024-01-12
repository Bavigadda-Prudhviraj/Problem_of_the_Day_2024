package com.prudhvi.geeks_for_geeks.january;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Jan_12_ReverseFirstKElementsOfQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		int[] arr = {1,2, 3, 4, 5};
		int k = 3;
		for( int i = 0; i < arr.length; i++)
			queue.add(arr[i]);
		System.out.println(modifyQueue(queue, k));

	}
	/*
	Time Complexity : O(N) we have to iterate over all the elements in the array;
	Space Complexity: O(N) In worst case have have to store the all the elements in the stack
	
	 */
	public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
	    // Get the size of the queue
	    int n = q.size();
	    // Stack to temporarily store the first 'k' elements
	    Stack<Integer> stack = new Stack<>();
	    // Reverse the first 'k' elements using a stack
	    for (int i = 0; i < k; i++)
	        stack.add(q.poll());
	    // Add the reversed elements back to the queue
	    while (!stack.isEmpty())
	        q.add(stack.pop());
	    // Rotate the remaining elements to maintain the order
	    for (int i = 0; i < (n - k); i++)
	        q.add(q.poll());
	    //return the queue
	    return q;
	}

}
