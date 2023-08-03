package com.source.open.leetcode;

public class LC_0033_Search_in_Rotated_Sorted_Array {

	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 42.1MB 	Beats 5.56%  of users with Java
	*/	
	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {

			int mid = low + ((high - low) / 2);

			if (nums[mid] == target)
				return mid;

			if (nums[low] <= nums[mid]) {

				if (target <= nums[mid] && target >= nums[low])
					high = mid - 1;
				else
					low = mid + 1;
			} else {

				if (target >= nums[mid] && target <= nums[high])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}

		return -1;
	}
	
}
