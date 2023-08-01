package com.source.open.leetcode;

public class LC_0007_Reverse_Integer {

	public int reverse(int x) {

		StringBuilder sb = new StringBuilder();

		long n = x;

		if (n < 0) {
			n = Math.abs(n);
			sb.append(n);
			sb.append("-");
		} 
		else 
			sb.append(n);

		sb.reverse();

		long result = Long.valueOf(sb.toString());

		return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : Math.toIntExact(result);
	}
	
}
