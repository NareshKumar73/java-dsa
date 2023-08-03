package com.source.open.leetcode;

public class LC_0038_Count_and_Say {

	/*
	 * Runtime Details 2ms 		Beats 98.39% of users with Java
	 * Memory  Details 39.98MB 	Beats 91.71% of users with Java
	*/	
	public String countAndSay(int n) {
		return generator("1", n - 1, new StringBuilder());
	}

	String generator(String s, int n, StringBuilder sb) {

		if (n == 0)
			return s;

		sb.setLength(0);

		int count = 1, i;

		for (i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				sb.append(count);
				sb.append(s.charAt(i - 1));
				count = 1;
			} else
				count++;
		}

		sb.append(count);
		sb.append(s.charAt(i - 1));

		return generator(sb.toString(), n - 1, sb);
	}
	
}
