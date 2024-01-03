package com.prudhvi.geeks_for_geeks.january;

public class Jan_4_FindElementOccuringOnceWhenAllOtherAppearsThrice {

	public static void main(String[] args) {
		int N = 4;
		int	arr[] = {1, 10, 1, 1};
		System.out.println(singleElement(arr, N));

	}
	/*
	Time Complexity:
		The outer loop runs 32 times (for each bit in an integer). 
		The inner loop runs for each element in the array. 
		Therefore, the overall time complexity is O(32 * N), where (N) is the size of the array.
	
	Space Complexity:
		The space complexity is constant O(1)) since the code uses a fixed amount of space for variables regardless of the input size. 
		The primary space used is for integer variables (`singleElement`, `setBitCount`, `i`, `j`), and it doesn't depend on the size of the input array.
	
	In summary, the time complexity is O(32*N), and the space complexity is O(1). The time complexity is linear in the size of the array, but the constant factor is relatively small (32 iterations).
	 */
	public static int singleElement(int[] arr, int N) {
		int singleElement = 0;

		// Iterate through each bit position (32 bits for an integer)
		for (int i = 0; i <= 31; i++) {
			int setBitCount = 0;

			// Count the number of set bits at the current position for all elements
			for (int j = 0; j < N; j++) {
				// Check if the bit at the current position is set for the j-th element
				setBitCount = ((1 << i) & arr[j]) != 0 ? setBitCount + 1 : setBitCount;
			}

			// Reconstruct the single element based on the modulo 3 count of set bits
			// If the setBitCount % 3 is not 0, set the corresponding bit in the singleElement
			singleElement = ((setBitCount % 3) != 0) ? singleElement + (1 << i) : singleElement;
		}

		// Return the single element that appears only once
		return singleElement;
	}


}
