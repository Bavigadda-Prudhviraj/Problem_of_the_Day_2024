package com.prudhvi.geeks_for_geeks.january;

import java.util.ArrayList;

public class Jan_9_SearchPattern_KMP_Algorithm {

	public static void main(String[] args) {
		String txt = "geeksforgeeks";
		String pat = "geek";
		System.out.println(search(pat, txt));

	}
	/*
	The method lPS_array_construction takes a string str as input and returns an integer array LPS_arr, 
	which represents the Longest Proper Prefix which is also a Suffix (LPS) array for the given string.
	
	Time Complexity:
			The time complexity of the code is O(n+m), where n is the length of the inputs string (pat + txt). 
			
	Space Complexity:
			The space complexity is O(n + m) since we create an array of the same length as the input string to store the LPS values.
	 */
    public static ArrayList<Integer> search(String pat, String txt){
        String str = pat + "@" + txt;
		int[] LPS_arr=new int[str.length()];
		//Iterate through the characters of the string starting from the second character (index 1).
		for(int i=1;i<str.length();i++) {
			//Get the LPS value of the previous character LPS_arr[i-1] and assign it to the variable index.
			int index=LPS_arr[i-1]; // i-1 it doesn't work
			//Enter a while loop to find the LPS value for the current character.
			//Check if the character at the current index str.charAt(i) is equal to the character at the index  in the string.
			while (str.charAt(i)!=str.charAt(index)){
				if(index<=0) {
					index=-1;
					break;
				}
				//If they are not equal, move to the previous LPS value by assigning index with the LPS value of the previous index LPS_arr[index-1].
				 index=LPS_arr[index-1];
				 //Repeat this process until a match is found or the index becomes less than or equal to 0.
			}
			//If a match is found, assign index + 1 as the LPS value for the current character in LPS_arr.
			LPS_arr[i]=index+1;
		}
		// arrayList to store the indexes;
		ArrayList<Integer> index = new ArrayList<>();
		//iterate over the LPS array and store the indexes
        for(int i = 0; i < LPS_arr.length; i++){
            if(LPS_arr[i] == pat.length()){
                index.add(i - pat.length()*2 + 1);
            }
        }
		return index;
    }

}
