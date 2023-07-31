package com.source.open.leetcode;

public class LC_0005_Longest_Palindromic_Substring {

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0, n = s.length();

		char[] letters = s.toCharArray();

		for (int i = 0; i < n; i++) {
			int len1 = expandAroundCenter(letters, n, i, i);
			int len2 = expandAroundCenter(letters, n, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		return new String(letters, start, end + 1 - start);
	}

	private int expandAroundCenter(char[] letters, int n, int L, int R) {

		while (L >= 0 && R < n && letters[L] == letters[R]) {
			L--;
			R++;
		}

		return R - L - 1;
	}
}
