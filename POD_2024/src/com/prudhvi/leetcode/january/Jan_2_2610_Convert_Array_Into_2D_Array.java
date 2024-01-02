package com.prudhvi.leetcode.january;

import java.util.ArrayList;
import java.util.List;

public class Jan_2_2610_Convert_Array_Into_2D_Array {

	public static void main(String[] args) {
		int[] nums = {1,3,4,1,2,3,1};
		System.out.println(findMatrix(nums));

	}

	public static List<List<Integer>> findMatrix(int[] nums) {
		int n = nums.length;
		List<List<Integer>> matrix = new ArrayList<>();
		int[] frequency = new int[n + 1];

		for (int i = 0; i < n; i++) {
			if (frequency[nums[i]] >= matrix.size()) {
				matrix.add(new ArrayList<>());
			}
			matrix.get(frequency[nums[i]]).add(nums[i]);
			frequency[nums[i]]++;
		}
		return matrix;
	}
	

}
