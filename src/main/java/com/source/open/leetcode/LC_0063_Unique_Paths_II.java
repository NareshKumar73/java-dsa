package com.source.open.leetcode;

public class LC_0063_Unique_Paths_II {

	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 40.7MB 	Beats 50.19% of users with Java
	*/	
    public int uniquePathsWithObstaclesOptimized(int[][] obstacleGrid) {
        if (obstacleGrid == null 		|| 
        	obstacleGrid.length == 0 	|| 
        	obstacleGrid[0].length == 0 || 
        	obstacleGrid[0][0] == 1) {
            return 0;
        }

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[] previous = new int[n];
		int[] current = new int[n];
		previous[0] = 1;

		for (int i = 0; i < m; i++) {
			current[0] = obstacleGrid[i][0] == 1 ? 0 : previous[0];
			for (int j = 1; j < n; j++) {
				current[j] = obstacleGrid[i][j] == 1 ? 0 : current[j - 1] + previous[j];
			}
			System.arraycopy(current, 0, previous, 0, n);
		}

		return previous[n - 1];
	}
	
//  Recursion with memoization
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null 		|| 
			obstacleGrid.length == 0 	|| 
			obstacleGrid[0].length == 0 || 
			obstacleGrid[0][0] == 1) {
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] mem = new int[m][n];

		return uniquePathUtil(m - 1, n - 1, mem, obstacleGrid);
	}

	public int uniquePathUtil(int m, int n, int[][] mem, int[][] grid) {

		if (m == -1 || n == -1 || grid[m][n] == 1)
			return 0;

		if (m == 0 && n == 0)
			return mem[m][n] = 1;

		if (mem[m][n] > 0)
			return mem[m][n];

		return mem[m][n] = uniquePathUtil(m - 1, n, mem, grid) + 
						   uniquePathUtil(m, n - 1, mem, grid);
	}

}
