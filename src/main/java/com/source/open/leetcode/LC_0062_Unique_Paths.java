package com.source.open.leetcode;

public class LC_0062_Unique_Paths {

	/*
	 * Runtime Details 0ms 		Beats 100% of users with Java
	 * Memory  Details 39.1MB 	Beats 78%  of users with Java
	*/	
	public int uniquePaths(int m, int n) {

		int[][] mem = new int[m + 1][n + 1];

		return uniquePathUtil(m, n, mem);
	}

	public int uniquePathUtil(int m, int n, int[][] mem) {

		if (m == 1 || n == 1) 
			return mem[m][n] = 1;

		if (mem[m][n] > 0)
			return mem[m][n];

		return mem[m][n] = uniquePathUtil(m - 1, n, mem) + 
						   uniquePathUtil(m, n - 1, mem);
	}
}
