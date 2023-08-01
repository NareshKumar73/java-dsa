package com.source.open.leetcode;

import java.util.Arrays;

public class LC_0016_3Sum_Closest {

	/*
	 * Runtime Details 13ms 	Beats 94.88% of users with Java
	 * Memory  Details 43.2MB 	Beats 44.95% of users with Java
	*/
	public int threeSumClosest(int nums[], int target) {

		if (nums.length == 3)
			return nums[0] + nums[1] + nums[2];

		int closestSum = Integer.MAX_VALUE;
		int diffClosest = Math.abs(closestSum - target);

		int sum = 0;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int lower = i + 1;
			int upper = nums.length - 1;
			while (lower < upper) {
				sum = nums[i] + nums[lower] + nums[upper];

				int diffSum = Math.abs(target - sum);

				if (diffSum < diffClosest) {
					closestSum = sum;
					diffClosest = diffSum;
				}

				if (sum <= target)
					lower++;
				else
					upper--;
			}
		}
		
		return closestSum;
	}

}
