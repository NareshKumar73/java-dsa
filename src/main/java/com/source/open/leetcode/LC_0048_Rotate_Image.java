package com.source.open.leetcode;

public class LC_0048_Rotate_Image {

	/*
	 * Runtime Details 0ms 	  	Beats 100% of users with Java 
	 * Memory  Details 42.4MB	Beats 5.4% of users with Java
	 */
	public void rotate(int[][] matrix) {
		int temp = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int k = 0; k < matrix.length; k++) {

			int l = 0;
			int r = matrix[0].length - 1;

			while (l < r) {
				temp 		 = matrix[k][l];
				matrix[k][l] = matrix[k][r];
				matrix[k][r] = temp;
				l++;
				r--;
			}
		}
		
	}
	
}
