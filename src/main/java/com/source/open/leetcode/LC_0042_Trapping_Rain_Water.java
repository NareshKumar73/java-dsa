package com.source.open.leetcode;

public class LC_0042_Trapping_Rain_Water {
	
	/*
	 * Runtime Details 1ms 	  	Beats 93.27% of users with Java 
	 * Memory  Details 42.8MB	Beats 99.52% of users with Java
	 */
	public int trap(int[] height) {

		int ans = 0, i = 0, len = height.length;

		int[] left = new int[len];
		int[] right = new int[len];

//  fill boundary wall size
		left[0] = height[0];
		right[len - 1] = height[len - 1];

//  store max height left wall from left
		for (i = 1; i < len; i++)
			left[i] = Math.max(left[i - 1], height[i]);

//  store max height right wall from right
		for (i = len - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], height[i]);

//  choose the smaller wall and deduct from it the current wall length
		for (i = 0; i < len; i++)
			ans += Math.min(left[i], right[i]) - height[i];

		return ans;
	}
	
}
