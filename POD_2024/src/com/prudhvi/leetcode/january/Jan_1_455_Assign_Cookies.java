package com.prudhvi.leetcode.january;

import java.util.Arrays;

public class Jan_1_455_Assign_Cookies {

	public static void main(String[] args) {
		int[] g = {1,2,3}; 
		int[] s = {1,1};
		System.out.println(findContentChildren(g, s));
	}

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int greedFactor = 0;
		int cookieSize = 0;
		int childrenCount = 0;

		while (greedFactor < g.length && cookieSize < s.length) {
			if (g[greedFactor] <= s[cookieSize]) {
				childrenCount++;
				greedFactor++;
			}
			cookieSize++;
		}
		return childrenCount;

	}

}
