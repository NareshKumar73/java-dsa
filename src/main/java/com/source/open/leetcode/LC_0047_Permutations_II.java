package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC_0047_Permutations_II {

	/*
	 * Runtime Details 2ms 	  	Beats 91.60% of users with Java 
	 * Memory  Details 44.1MB	Beats 73.34% of users with Java
	 */
	public List<List<Integer>> permuteUniqueOptimized(int[] nums) {
		// Create a list to store the final results
		List<List<Integer>> res = new ArrayList<>();
		// Sort the input array to group duplicates together
		Arrays.sort(nums);
		// Create a boolean array to keep track of used numbers
		boolean[] used = new boolean[nums.length];
		// Call the recursive backtrack method to generate all permutations
		backtrack(nums, used, new ArrayList<>(), res);
		// Return the list of permutations
		return res;
	}

	private void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
		// If the current permutation is complete, add it to the results list
		if (curr.size() == nums.length) {
			res.add(new ArrayList<>(curr));
			return;
		}

		// Loop through the indices of the input array
		for (int i = 0; i < nums.length; i++) {
			// Skip if the number has already been used or if it's a duplicate that has
			// already been used
			if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
				continue;
			}
			// Mark the current number as used, add it to the current permutation list
			used[i] = true;
			curr.add(nums[i]);
			// Recursively call backtrack to generate all permutations
			backtrack(nums, used, curr, res);
			// Mark the current number as unused, remove it from the current permutation
			// list
			used[i] = false;
			curr.remove(curr.size() - 1);
		}
	}

	List<List<Integer>> res;

	public List<List<Integer>> permuteUnique(int[] nums) {
		res = new ArrayList<>();

		generatePermutation(nums, 0, nums.length - 1);
		
		return res;
	}

	void generatePermutation(int[] nums, int l, int r) {
		if (l == r) {
			List<Integer> p = Arrays.stream(nums).boxed().collect(Collectors.toList());

			boolean fullMatch = false;

			for (int i = 0; i < res.size(); i++) {
				List<Integer> q = res.get(i);

				int k = 0;
				while (k < q.size() && q.get(k) == p.get(k))
					k++;

				if (k == q.size()) {
					fullMatch = true;
					break;
				}
			}

			if (!fullMatch)
				res.add(p);

			return;
		}

		for (int i = l; i <= r; i++) {
			if (l == i || l != i && nums[l] != nums[i]) {
				swap(nums, l, i);
				generatePermutation(nums, l + 1, r);
				swap(nums, l, i);
			}
		}
	}

	void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}
