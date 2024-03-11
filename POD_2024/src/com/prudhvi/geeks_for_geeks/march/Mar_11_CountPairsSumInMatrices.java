package com.prudhvi.geeks_for_geeks.march;

import java.util.HashSet;
import java.util.Set;

public class Mar_11_CountPairsSumInMatrices {

	public static void main(String[] args) {
		int n = 3, x = 21;
		int[][]	mat1 = {{1, 5, 6},
				        {8, 10, 11},
				        {15, 16, 18}};
		int[][]	mat2 = {{2, 4, 7},
				        {9, 10, 12},
				        {13, 16, 20}};
		System.out.println(countPairs(mat1, mat2, n, x));

	}
	/**
	 * Counts pairs of elements from two matrices such that the sum of elements from the second matrix
	 * with a corresponding element from the first matrix is equal to a given target value.
	 *
	 * @param mat1 The first matrix.
	 * @param mat2 The second matrix.
	 * @param n    The size of the matrices (assumed to be square matrices with dimensions nxn).
	 * @param x    The target sum value.
	 * @return The count of pairs satisfying the condition.
	 *
	 * Time Complexity: O(n^2), where n is the size of the matrices.
	 * Space Complexity: O(n^2), as a set is used to store elements from the first matrix.
	 */
	public static int countPairs(int mat1[][], int mat2[][], int n, int x) {
	    
	    // HashSet to store unique elements from the first matrix (mat1).
	    Set<Integer> set = new HashSet<>();
	    
	    // Populate the HashSet with elements from the first matrix (mat1).
	    for(int i = 0; i < mat1.length; i++){
	        for(int j = 0; j < mat1[i].length; j++){
	            set.add(mat1[i][j]);
	        }
	    }

	    // Counter to keep track of the number of pairs whose sum equals the target value 'x'.
	    int pairCount = 0;
	    
	    // Iterate through the elements of the second matrix (mat2).
	    for(int i = 0; i < mat2.length; i++){
	        for(int j = 0; j < mat2[i].length; j++){
	            // Calculate the remaining number needed to form a pair with the current element.
	            int remainingNum = x - mat2[i][j];
	            
	            // If the remaining number is present in the HashSet, increment the pairCount.
	            if(set.contains(remainingNum)){
	               pairCount++; 
	            }
	        }
	    }
	    
	    // Return the total count of pairs whose sum equals the target value 'x'.
	    return pairCount;
	}


}
