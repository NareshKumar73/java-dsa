package com.source.open.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_0001_Two_Sum {

	// Complexity Analysis

	// Time complexity: O(n).
	// We traverse the array containing n elements only once.
	// Each lookup in the table costs only O(1) time.

	// Space complexity: O(n).
	// The extra space required depends on the number of items stored in the hash
	// table, which stores at most n elements.

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int second = target - nums[i];

			if (map.containsKey(second))
				return new int[] { map.get(second), i };
			else
				map.put(nums[i], i);
		}

		return null;
	}

}
