package com.prudhvi.leetcode.january;

import java.util.Stack;

public class Jan_30_150_EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String[] token = { "4", "13", "5", "/", "+" }; //6
		System.out.println(evalRPN(token));

	}
	/**
	 * Evaluates the given Reverse Polish Notation (RPN) expression.
	 *
	 * @param tokens An array of strings representing the RPN expression.
	 * @return The result of evaluating the RPN expression.
	 *
	 * @TimeComplexity: O(n)
	 *   - The method iterates through each token in the input array once.
	 *
	 * @SpaceComplexity: O(n)
	 *   - The space used by the stack to store intermediate results.
	 */
	public static int evalRPN(String[] tokens) {
	    Stack<Integer> stack = new Stack<>();

	    for (int i = 0; i < tokens.length; i++) {
	        String val = tokens[i];
	        if (val.equals("*") || val.equals("/") || val.equals("+") || val.equals("-")) {
	            // If the token is an operator, pop two operands and perform the operation.
	            int firstNum = stack.pop();
	            int secondNum = stack.pop();

	            if (val.equals("*")) 
	                stack.push(secondNum * firstNum);
	            else if (val.equals("/")) 
	                stack.push(secondNum / firstNum);
	            else if (val.equals("+"))
	                stack.push(secondNum + firstNum);
	            else if (val.equals("-"))
	                stack.push(secondNum - firstNum);
	        } else {
	            // If the token is an operand, push it onto the stack.
	            stack.push(Integer.valueOf(val));
	        }
	    }

	    // The final result is at the top of the stack.
	    return stack.peek();
	}


}
