package com.source.open.leetcode;

public class LC_0029_Divide_Two_Integers {

	/*
	 * Runtime Details 1ms 		Beats 98.95% of users with Java
	 * Memory  Details 40.3MB 	Beats 9.28%  of users with Java
	*/
	public int divide(int dividend, int divisor) {

		int quotient = 0;

		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		boolean negative = false;

		if (dividend < 0) {
			dividend = 0 - dividend;
			negative = !negative;
		}

		if (divisor < 0) {
			divisor = 0 - divisor;
			negative = !negative;
		}

		for (int x = 31; x >= 0; x--) {
			if ((dividend >>> x) - divisor >= 0) {
				quotient += 1 << x;
				dividend -= divisor << x;
			}
		}

		return negative ? -quotient : quotient;
	}
	
}
