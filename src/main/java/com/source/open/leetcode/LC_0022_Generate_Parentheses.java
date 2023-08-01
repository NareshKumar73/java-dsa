package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_0022_Generate_Parentheses {

	private List<String> res;


	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 42MB 	Beats 93.47% of users with Java
	*/

	public List<String> generateParenthesis(int n) {
		res = new ArrayList<String>();
		recurse(0, 0, new char[n * 2], n);
		return res;
	}

	public void recurse(int left, int right, char[] b, int n) {
		if (left + right == n * 2) {
			res.add(new String(b));
			return;
		}

		if (left < n) {
			b[left + right] = '(';
			recurse(left + 1, right, b, n);
		}

		if (right < left) {
			b[left + right] = ')';
			recurse(left, right + 1, b, n);
		}
	}
}
