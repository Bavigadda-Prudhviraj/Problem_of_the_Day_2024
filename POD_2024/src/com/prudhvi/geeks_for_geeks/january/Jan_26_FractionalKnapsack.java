package com.prudhvi.geeks_for_geeks.january;

import java.util.Arrays;
import java.util.Comparator;

public class Jan_26_FractionalKnapsack {

	public static void main(String[] args) {
	    int n = 3, w = 50;
	    int[] value = {60, 100, 120};
	    int[] weight = {10, 20, 30};
	    Item[] arr = new Item[n];
	    for (int i = 0; i < n; i++)
	        arr[i] = new Item(value[i], weight[i]);
		
		System.out.println( fractionalKnapsack(w, arr, n));

	}
	/**
	 * Solves the fractional knapsack problem to maximize the total value of items within a given weight capacity.
	 *
	 * @param W   The maximum weight capacity of the knapsack.
	 * @param arr An array of items with their values and weights.
	 * @param n   The number of items.
	 * @return The maximum total value that can be obtained.
	 */
	public static double fractionalKnapsack(int W, Item arr[], int n) {
	    // Check for invalid inputs
	    if (W <= 0 || n <= 0)
	        return 0;

	    // Create an array of Items to store additional information
	    Items[] items = new Items[n];
	    for (int i = 0; i < n; i++)
	        items[i] = new Items(arr[i].value, arr[i].weight, ((arr[i].value * 1.0) / arr[i].weight));

	    // Sort the items based on value per weight in descending order
	    Arrays.sort(items, new MyComparator());

	    // Initialize variables
	    double maxValue = 0;

	    // Iterate through the sorted items
	    for (int i = n - 1; i >= 0; i--) {
	        // Check if the entire item can be added to the knapsack
	        if (items[i].weight <= W) {
	            maxValue += items[i].value;
	            W -= items[i].weight;
	        } else {
	            // Add a fraction of the item to fill the remaining capacity
	            maxValue += W * items[i].valuePerWeight;
	            W = 0;
	            break;
	        }
	    }
	    return maxValue;
	}

}
/**
 * Helper class representing an item with its value, weight, and value per weight.
 */
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
/**
 * Comparator class to sort Items based on value per weight in descending order.
 */
class Items {
	int value;
	int weight;
	double valuePerWeight;

	public Items(int value, int weight, double valuePerWeight) {
		this.value = value;
		this.weight = weight;
		this.valuePerWeight = valuePerWeight;
	}

}

class MyComparator implements Comparator<Items> {
	public int compare(Items o1, Items o2) {
	    if(o1.valuePerWeight <  o2.valuePerWeight){
	        return -1;
	    }
	    else if(o1.valuePerWeight >  o2.valuePerWeight){
	        return 1;
	    }
	    else{
	        return 0;
	    }
	}

}
