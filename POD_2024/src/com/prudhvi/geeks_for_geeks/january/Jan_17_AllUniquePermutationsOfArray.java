package com.prudhvi.geeks_for_geeks.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Jan_17_AllUniquePermutationsOfArray {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 1, 2));
		System.out.println(uniquePerms(arrayList, 3));
	}

	/**
	 * Generates unique permutations of the given ArrayList of integers.
	 *
	 * @param arr The input ArrayList of integers.
	 * @param n   The size of the input ArrayList.
	 * @return An ArrayList containing unique permutations of the input elements.
	 * @TimeComplexity The time complexity is O(N!), where N is the size of the input ArrayList.
	 * @SpaceComplexity The space complexity is O(N!) due to the storage of unique permutations.
	 */
	public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
	    // Sort the input ArrayList to ensure unique permutations
	    Collections.sort(arr);
	    // ArrayList to store unique permutations
	    ArrayList<ArrayList<Integer>> uniquePermutations = new ArrayList<>();
	    // Temporary ArrayList to store the current permutation
	    ArrayList<Integer> currentPermutation = new ArrayList<>();
	    // Set to track unique permutations using HashSet
	    Set<ArrayList<Integer>> set = new HashSet<>();
	    // Array to keep track of whether an element is used in the current permutation
	    boolean[] check = new boolean[n];
	    // Generate unique permutations recursively
	    generatePermutations(arr, 0, check, currentPermutation, uniquePermutations, set);
	    // Return the ArrayList of unique permutations
	    return uniquePermutations;
	}

	/**
	 * Recursive helper function to generate unique permutations.
	 * @param arr                The input ArrayList of integers.
	 * @param index              The current index in the generation process.
	 * @param check              An array to track whether an element is used.
	 * @param currentPermutation The current permutation being generated.
	 * @param uniquePermutations The ArrayList to store unique permutations.
	 * @param set                The HashSet to track unique permutations.
	 */
	public static void generatePermutations(ArrayList<Integer> arr, int index, boolean[] check,
	        ArrayList<Integer> currentPermutation, ArrayList<ArrayList<Integer>> uniquePermutations,
	        Set<ArrayList<Integer>> set) {
		
	    // Base case: If the current permutation is complete, add it to the result
	    if (index == arr.size()) {
	        // Convert the ArrayList to a new one to avoid modification during set operations
	        if (!set.contains(new ArrayList<>(currentPermutation))) {
	            set.add(new ArrayList<>(currentPermutation));
	            uniquePermutations.add(new ArrayList<>(currentPermutation));
	        }
	        return;
	    }

	    // Iterate through the elements in the input ArrayList
	    for (int i = 0; i < arr.size(); i++) {
	        if (!check[i]) {
	            // Mark the current element as used
	            check[i] = true;
	            // Add the current element to the current permutation
	            currentPermutation.add(arr.get(i));
	            // Recursively generate permutations for the next index
	            generatePermutations(arr, index + 1, check, currentPermutation, uniquePermutations, set);
	            // Backtrack: Unmark the current element as unused and remove it from the permutation
	            check[i] = false;
	            currentPermutation.remove(currentPermutation.size() - 1);
	        }
	    }
	}


}
