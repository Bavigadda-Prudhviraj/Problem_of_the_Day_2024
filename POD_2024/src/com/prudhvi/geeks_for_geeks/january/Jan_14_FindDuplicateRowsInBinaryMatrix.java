package com.prudhvi.geeks_for_geeks.january;

import java.util.ArrayList;
import java.util.HashSet;

public class Jan_14_FindDuplicateRowsInBinaryMatrix {

	public static void main(String[] args) {
		int	r = 4, c = 3;
		int[][] matrix = {{ 1, 0, 0},
				          { 1, 0, 0},
				          { 0, 0, 0},
				          { 0, 0, 0}};
		System.out.println(repeatedRows(matrix, r, c));

	}
	/**
	 * Finds the indices of repeated rows in a matrix.
	 *
	 * @param matrix The input matrix.
	 * @param m      The number of rows in the matrix.
	 * @param n      The number of columns in the matrix.
	 * @return       A list containing the indices of rows that are repeated in the matrix.
	 * @TimeComplexity The time complexity is O(m * n), where m is the number of rows and n is the number of columns.
	 *                 This is because each row is converted to a string with O(n) operations,
	 *                 and the set operations are performed m times.
	 * @SpaceComplexity The space complexity is O(m * n) in the worst case, where m is the number of rows and n is the number of columns.
	 *                  This is due to storing each row as a string in the HashSet.
	 */
	public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
	    // HashSet to store unique string representations of rows
	    HashSet<String> set = new HashSet<>();
	    // ArrayList to store indices of repeated rows
	    ArrayList<Integer> copyIndex = new ArrayList<>();
	    // Iterate through each row of the matrix
	    for (int i = 0; i < m; i++) {
	        // Construct a string representation of the current row
	        StringBuilder str = new StringBuilder();
	        for (int j = 0; j < n; j++) 
	            str.append(matrix[i][j]);
	        
	        // Check if the string is already in the set (indicating a repeated row)
	        if (set.contains(str.toString())) {
	            // If repeated, add the index to the result list
	            copyIndex.add(i);
	        } else {
	            // If not repeated, add the string to the set
	            set.add(str.toString());
	        }
	    }

	    // Return the list of indices of repeated rows
	    return copyIndex;
	}

}
