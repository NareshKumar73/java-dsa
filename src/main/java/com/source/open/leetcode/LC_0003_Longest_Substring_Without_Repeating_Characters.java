package com.source.open.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC_0003_Longest_Substring_Without_Repeating_Characters {

	public int lengthOfLongestSubstring(String s) {
//		Better approach
		return withTwoPointerApproach(s);
//		return withQueue(s);
	}

	// Time complexity: O(n).
	// Space complexity: O(1).
	public int withTwoPointerApproach(String s) {

		int l = 0, max = 0;

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			int index = -1;

			for (int a = l; a < i; a++) {
				if (s.charAt(a) == c) {
					index = a;
					break;
				}
			}

			if (index >= l)
				l = index + 1;

			int count = i + 1 - l;

			if (count > max)
				max = count;
		}

		return max;
	}

	// Time complexity: O(n).
	// Space complexity: O(n). Because of use of Queue
	public int withQueue(String s) {

		Deque<Character> deque = new LinkedList<>();

		int max = 0;
		int count = 0;

		char c;

		if (s.length() > 0) {
			c = s.charAt(0);
			deque.addLast(c);
			count++;
			max++;
		}

		for (int i = 1; i < s.length(); i++) {

			c = s.charAt(i);

			if (deque.contains(c)) {
				char key = 0;
				while (key != c) {
					key = deque.pollFirst();
					count--;
				}
			}
			deque.addLast(c);
			count++;

			if (count > max)
				max = count;
		}

		return max;
	}
}
