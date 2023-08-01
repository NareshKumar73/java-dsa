package com.source.open.leetcode;

public class LC_0013_Roman_to_Integer {

	// Complexity Analysis

	// Time complexity: O(n).
	// Space complexity: O(1).
	
	/*	
	 *	Runtime Details 2ms		Beats 100% 	 of users with Java 
	 *	Memory  Details 44.1MB	Beats 19.26% of users with Java	
	*/
	public int romanToInt(String s) {
		int n = s.length();
		int num = 0;

		for (int i = 0; i < n; i++) {

			int current = intValue(s.charAt(i));

			if (i + 1 < n) {

				int next = intValue(s.charAt(i + 1));

				if (current >= next)
					num += current;
				else {
					num += next - current;
					i++;
				}
			} else
				num += current;
		}

		return num;
	}

	private int intValue(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}
}
