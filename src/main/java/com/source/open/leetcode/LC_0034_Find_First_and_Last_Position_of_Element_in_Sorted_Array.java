package com.source.open.leetcode;

public class LC_0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 44.6MB 	Beats 47.35% of users with Java
	*/	
	public int[] searchRange(int[] nums, int target) {
		
		int first = -1, last = -1;
		int l = 0;
		int r = nums.length - 1;

//		Find first occurrence
		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (nums[mid] == target) {
				first = mid;
				r = mid - 1;
			} else if (nums[mid] > target)
				r = mid - 1;
			else
				l = mid + 1;
		}

		l = 0;
		r = nums.length - 1;

//		Find last occurrence
		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (nums[mid] == target) {
				last = mid;
				l = mid + 1;
			} else if (nums[mid] > target)
				r = mid - 1;
			else
				l = mid + 1;
		}

		return new int[] { first, last };
	}
	
}
