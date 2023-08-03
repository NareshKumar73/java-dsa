package com.source.open.leetcode;

public class LC_0026_Remove_Duplicates_from_Sorted_Array {

	/*
	 * Runtime Details 1ms 		Beats 98.89% of users with Java
	 * Memory  Details 44.2MB 	Beats 21.47% of users with Java
	*/
	public int removeDuplicates(int[] nums) {

		int i = 0, k = 1;

		if (nums.length == 1)
			return 1;

		while (k < nums.length) {

			while (k < nums.length && nums[i] == nums[k]) {
				k++;
			}

			if (k >= nums.length)
				break;

			nums[++i] = nums[k];
		}

		return i + 1;
	}
	
}
