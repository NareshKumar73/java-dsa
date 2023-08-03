package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_0046_Permutations {

	List<List<Integer>> res;

	/*
	 * Runtime Details 1ms 		Beats 98.58% of users with Java
	 * Memory  Details 44.1MB 	Beats 31.55% of users with Java
	*/
	public List<List<Integer>> permute(int[] nums) {

		res = new ArrayList<>();

		generatePermutation(nums, 0, nums.length - 1);

		return res;
	}

	void generatePermutation(int[] nums, int l, int r) {

		if (l == r) {
			List<Integer> p = new ArrayList<>(nums.length);

			for (Integer n : nums)
				p.add(n);

			res.add(p);
			return;
		}

		for (int i = l; i <= r; i++) {
			swap(nums, l, i);
			generatePermutation(nums, l + 1, r);
			swap(nums, l, i);
		}
	}

	void swap(int[] nums, int l, int r) {
		int t = nums[l];
		nums[l] = nums[r];
		nums[r] = t;
	}

}
