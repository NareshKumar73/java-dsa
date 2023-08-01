package com.source.open.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC_0018_4Sum {

	/*	
	 * Runtime	21ms	Beats 	73.85%
	 * Memory	43.7MB	Beats	94.35%
	*/
	public List<List<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);

		List<List<Integer>> res = new LinkedList<>();

		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i - 1] == nums[i])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j - 1] == nums[j])
					continue;

				long sum0 = nums[i] + nums[j];

				int l = j + 1, h = nums.length - 1;
				while (l < h) {
					long sum = sum0 + nums[l] + nums[h];

					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
						l++;
						h--;

						while (nums[l] == nums[l - 1] && l < h)
							l++;

						while (nums[h] == nums[h + 1] && l < h)
							h--;
					} else if (sum < target)
						l++;
					else
						h--;
				}
			}
		}

		return res;
	}
}
