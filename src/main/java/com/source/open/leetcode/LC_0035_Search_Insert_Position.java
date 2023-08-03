package com.source.open.leetcode;

public class LC_0035_Search_Insert_Position {

	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 42MB 	Beats 99.18% of users with Java
	*/	
	public int searchInsert(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;

		if (target <= nums[start])
			return start;

		if (target > nums[end])
			return nums.length;

		while (start <= end) {

			int mid = start + ((end - start) / 2);

			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return start;
	}
	
}
