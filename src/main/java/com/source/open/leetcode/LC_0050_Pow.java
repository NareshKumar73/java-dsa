package com.source.open.leetcode;

public class LC_0050_Pow {

	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 40.7MB 	Beats 60.27% of users with Java
	*/
	public double myPow(double x, int n) {
		return binaryExp(x, (long) n);
	}

	private double binaryExp(double x, long n) {
		// Base case, to stop recursive calls.
		if (n == 0)
			return 1;

		// Handle case where, n < 0.
		if (n < 0)
			return 1.0 / binaryExp(x, -1 * n);

		// Perform Binary Exponentiation.
		// If 'n' is odd we perform Binary Exponentiation on 'n - 1'
		// and multiply result with 'x'.
		if (n % 2 == 1)
			return x * binaryExp(x * x, (n - 1) / 2);

		// Otherwise we calculate result by performing Binary Exponentiation on 'n'.
		else
			return binaryExp(x * x, n / 2);
	}

}
