package com.source.open.leetcode;

import java.util.Arrays;

public class LC_0052_NQueens_II {

	/*
	 * Runtime Details 2ms 		Beats 80.90% of users with Java 
	 * Memory  Details 38.9MB	Beats 95.63% of users with Java
	 */
	int count = 0;
	public int totalNQueens(int n) {
		char[][] board = new char[n][n];

		for (int i = 0; i < board.length; i++)
			Arrays.fill(board[i], '.');

		helper(board, 0);
		return count;
	}

	public void helper(char[][] board, int col) {

		if (col == board.length) {
			count++;
			return;
		}

		for (int row = 0; row < board.length; row++) {
			if (isSafe(row, col, board)) {
				board[row][col] = 'Q';
				helper(board, col + 1);
				board[row][col] = '.';
			}
		}
	}

	public boolean isSafe(int row, int col, char board[][]) {
		int c, r;

//	      Horizontal Check
		for (int j = 0; j < board.length; j++) {
			if (board[row][j] == 'Q')
				return false;
		}

//	      Upper Left
		for (c = col, r = row; c >= 0 && r >= 0; c--, r--) {
			if (board[r][c] == 'Q')
				return false;
		}

//	      Lower Left
		for (c = col, r = row; c >= 0 && r < board.length; c--, r++) {
			if (board[r][c] == 'Q')
				return false;
		}

		return true;
	}

}
