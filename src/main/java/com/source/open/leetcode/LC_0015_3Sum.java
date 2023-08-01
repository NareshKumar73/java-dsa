package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0015_3Sum {

	/*
	 * Runtime Details 35ms		Beats 93.45% of users with Java
	 * Memory  Details 52.1MB 	Beats 10.32% of users with Java						
	 */
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int total = nums[i] + nums[left] + nums[right];
				if (total == 0) {
					List<Integer> tuple = new ArrayList<>();
					tuple.add(nums[i]);
					tuple.add(nums[left]);
					tuple.add(nums[right]);

					res.add(tuple);

					left++;
					right--;

					while (nums[left] == nums[left - 1] && left < right)
						left++;

					while (nums[right] == nums[right + 1] && left < right)
						right--;
					
				} else if (total < 0) {
					left += 1;
				} else {
					right -= 1;
				}
			}
		}

		return res;
	}

}
