package com.source.open.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_0020_Valid_Parentheses {

	/*
	 * Runtime Details 1ms 		Beats 98.87% of users with Java
	 * Memory  Details 40.7MB 	Beats 48.20% of users with Java
	*/

	public boolean isValid(String s) {

		Deque<Character> stack = new ArrayDeque<>();

		for (char ch : s.toCharArray()) {

			switch (ch) {

			case '(':
			case '{':
			case '[':
				stack.addFirst(ch);
				break;

			case ')':
				if (stack.isEmpty() || stack.pollFirst() != '(') {
					return false;
				}
				break;

			case '}':
				if (stack.isEmpty() || stack.pollFirst() != '{') {
					return false;
				}
				break;

			case ']':
				if (stack.isEmpty() || stack.pollFirst() != '[') {
					return false;
				}
				break;
			}
		}

		return stack.isEmpty();
	}
}
