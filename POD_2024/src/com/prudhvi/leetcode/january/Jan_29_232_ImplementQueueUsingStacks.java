package com.prudhvi.leetcode.january;

import java.util.Stack;
/*
	This code implements a queue using two stacks, FrontOrAddingStack and rearOrRemovingStack. 
	The queue follows the First-In-First-Out (FIFO) principle, meaning elements are added to the back and removed from the front. 
	The push, pop, peek, and empty methods provide the basic functionalities of adding elements to the back, removing elements from the front, getting the front element without removing it, and checking if the queue is empty, respectively.
	
	Time Complexity:
			1.Push operation is O(1) as it involves pushing an element onto the FrontOrAddingStack.
			2.Pop operation is O(n) in the worst case if it needs to transfer all elements from one stack to the other. 
			  However, on average, it is O(1) as the elements are moved only once from one stack to the other, 
			  giving it an amortized O(1) time complexity.
			3.Peek operation has a similar time complexity to the pop operation, O(n) in the worst case 
			  and Note:-O(1) amortized.
			4.Empty operation is O(1) since it only involves checking if both stacks are empty.
			Note:-To know more about amortized time complexity mention at the end of the code.

	Space Complexity:
			The space complexity is O(n), where n is the number of elements in the queue. 
			In the worst case, all elements can be stored in both the FrontOrAddingStack and rearOrRemovingStack.
	
	In this particular implementation of the queue using two stacks, 
	the push operation is O(1), 
	the pop operation is O(1) amortized, 
	the peek operation is O(1) amortized, and 
	the empty operation is O(1). 
	The space complexity is O(n).
 */
public class Jan_29_232_ImplementQueueUsingStacks {

	/**
	 * Implementation of a Queue using two Stacks.
	 */
	class MyQueue {

	    // Stack for push operation
	    Stack<Integer> push;
	    
	    // Stack for pop operation
	    Stack<Integer> pop;

	    /**
	     * Constructor to initialize the two Stacks.
	     */
	    public MyQueue() {
	        push = new Stack<Integer>();
	        pop = new Stack<Integer>();
	    }

	    /**
	     * Pushes an element to the back of the queue.
	     *
	     * @param x The element to be pushed.
	     */
	    public void push(int x) {
	        push.push(x);
	    }

	    /**
	     * Removes and returns the element from the front of the queue.
	     *
	     * @return The element at the front of the queue.
	     */
	    public int pop() {
	        // If the pop stack is not empty, directly pop from it
	        if (!pop.isEmpty()) {
	            return pop.pop();
	        } else {
	            // If the pop stack is empty, transfer elements from the push stack
	            // to the pop stack and then pop from the pop stack
	            while (!push.isEmpty())
	                pop.push(push.pop());
	            return pop.pop();
	        }
	    }

	    /**
	     * Returns the element at the front of the queue without removing it.
	     *
	     * @return The element at the front of the queue.
	     */
	    public int peek() {
	        // If the pop stack is not empty, return the top element
	        if (!pop.isEmpty()) {
	            return pop.peek();
	        } else {
	            // If the pop stack is empty, transfer elements from the push stack
	            // to the pop stack and then return the top element of the pop stack
	            while (!push.isEmpty())
	                pop.push(push.pop());
	            return pop.peek();
	        }
	    }

	    /**
	     * Returns true if the queue is empty, false otherwise.
	     *
	     * @return True if the queue is empty, false otherwise.
	     */
	    public boolean empty() {
	        // The queue is empty if both stacks are empty
	        return push.isEmpty() && pop.isEmpty();
	    }
	}

	

}
