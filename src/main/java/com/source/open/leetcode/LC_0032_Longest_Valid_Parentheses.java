package com.source.open.leetcode;

import java.util.LinkedList;

public class LC_0032_Longest_Valid_Parentheses {

	/*
	 * Runtime Details 1ms 		Beats 100%   of users with Java
	 * Memory  Details 40.8MB 	Beats 99.19% of users with Java
	*/
	public int longestValidParenthesesUsingTwoPointers(String s) {
		int left = 0, right = 0, maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right > left) {
				left = right = 0;
			}
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left > right) {
				left = right = 0;
			}
		}
		return maxlength;
	}

	public int longestValidParenthesesUsingStack(String s) {
		int maxans = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		stack.addFirst(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.addFirst(i);
			} else {
				stack.pollFirst();
				if (stack.isEmpty()) {
					stack.addFirst(i);
				} else {
					maxans = Math.max(maxans, i - stack.peekFirst());
				}
			}
		}
		return maxans;
	}

}
