package com.prudhvi.geeks_for_geeks.february;

public class Feb_28_CheckIfANumberIsDivisibleBy8 {

	public static void main(String[] args) {
		String s = "16";
		System.out.println(divisibleByEight(s));

	}

	/**
	 * Checks if a substring of the given number is divisible by eight.
	 *
	 * @param s The input number as a string.
	 * @return 1 if a substring of the number is divisible by eight, otherwise -1.
	 *
	 * @TimeComplexity: O(1) since the input size is constant (3 digits).
	 * @SpaceComplexity: O(1) as only a constant amount of space is used.
	 */
	public static int divisibleByEight(String s) {
		int length = s.length();
		int ans = -1;
		StringBuilder str = new StringBuilder();
		// If the number has at least 3 digits, check a substring of the last 3 digits.
		if (length >= 3) {
			int index = 1;
			int idx = length - 3;

			// Extract the last 3 digits.
			while (index <= 3) {
				str.append(s.charAt(idx));
				idx++;
				index++;
			}

			// Convert the substring to an integer and check if it is divisible by 8.
			int num = Integer.parseInt(str.toString());
			ans = (num % 8) == 0 ? 1 : -1;
		} else {
			// If the number has less than 3 digits, check the entire number.
			int idx = 0;
			// Convert the entire number to an integer and check if it is divisible by 8.
			while (idx < length) {
				str.append(s.charAt(idx));
				idx++;
			}

			int num = Integer.parseInt(str.toString());
			ans = (num % 8) == 0 ? 1 : -1;
		}
		return ans;
	}

}
