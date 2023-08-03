package com.source.open.leetcode;

public class LC_0027_Remove_Element {

	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 40.7MB 	Beats 95.45% of users with Java
	*/
	public int removeElement(int[] nums, int val) {
		int i = 0, k = 0;

		while (i < nums.length) {
			if (nums[i] != val)
				nums[k++] = nums[i];
			i++;
		}
		return k;
	}
	
}
