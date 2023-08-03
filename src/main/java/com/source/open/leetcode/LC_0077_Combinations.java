package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_0077_Combinations {

	/*
	 * Runtime Details 1ms 		Beats 100%   of users with Java
	 * Memory  Details 45.4MB 	Beats 64.91% of users with Java
	*/
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		generateCombinations(1, n, k, new ArrayList<Integer>(k), result);
		return result;
	}

	private void generateCombinations(int start, int n, int k, List<Integer> combination, List<List<Integer>> result) {
		if (k == 0) {
			result.add(new ArrayList<>(combination));
			return;
		}
		for (int i = start; i <= n - k + 1; i++) {
			combination.add(i);
			generateCombinations(i + 1, n, k - 1, combination, result);
			combination.remove(combination.size() - 1);
		}
	}
	
}
