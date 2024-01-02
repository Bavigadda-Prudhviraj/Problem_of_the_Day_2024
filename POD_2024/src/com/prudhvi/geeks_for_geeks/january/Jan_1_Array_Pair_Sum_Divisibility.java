package com.prudhvi.geeks_for_geeks.january;

import java.util.HashMap;

public class Jan_1_Array_Pair_Sum_Divisibility {

	public static void main(String[] args) {
		int[] nums = { 9, 5, 7, 3 };
		int k = 6;
		System.out.println(canPair(nums, k));

	}

	public static boolean canPair(int[] nums, int k) {
		if (nums.length % 2 != 0) {
			return false;
		}
		HashMap<Integer, Integer> reminderFrequencies = new HashMap<>();

		for (int ele : nums) {
			reminderFrequencies.put((ele % k), reminderFrequencies.getOrDefault((ele % k), 0) + 1);
		}

		for (int ele : nums) {
			int remainder = ele % k;
			int frequency = reminderFrequencies.getOrDefault(remainder, 0);
			if (remainder == 0) {
				if ((frequency % 2) != 0)
					return false;

			} else if ((2 * remainder) == k && (frequency % 2 != 0)) {
				if ((frequency % 2) != 0)
					return true;
			} else {
				int anotherNumFrequncy = reminderFrequencies.getOrDefault((k - remainder), 0);
				if (anotherNumFrequncy != frequency)
					return false;

			}
		}
		return true;
	}
}
