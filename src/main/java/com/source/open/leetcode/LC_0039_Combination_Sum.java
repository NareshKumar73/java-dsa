package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_0039_Combination_Sum {

	private List<List<Integer>> res;

	/*
	 * Runtime Details 2ms 		Beats 79.77% of users with Java
	 * Memory  Details 44.1MB 	Beats 37.18% of users with Java
	*/	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		res = new ArrayList<>();
		recurse(new ArrayList<>(), 0, target, candidates);
		return res;
	}

	public void recurse(List<Integer> ans, int start, int target, int[] c) {

		if (target == 0) {
			res.add(new ArrayList<>(ans));
			return;
		}

		for (int i = start; i < c.length; i++) {
			if (target < 0)
				break;
			ans.add(c[i]);
			recurse(ans, i, target - c[i], c);
			ans.remove(ans.size() - 1);
		}
	}
	
}
