package com.source.open.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0051_NQueens {

	/*
	 * Runtime Details 2ms 		Beats 90.46% of users with Java
	 * Memory  Details 43.7MB 	Beats 92.68% of users with Java
	*/	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> allBoards = new ArrayList<>();

		char[][] board = new char[n][n];

		for (int i = 0; i < board.length; i++)
			Arrays.fill(board[i], '.');

		helper(board, allBoards, 0);

		return allBoards;
	}

	public void helper(char[][] board, List<List<String>> allBoards, int col) {

		if (col == board.length) {
			saveBoard(board, allBoards);
			return;
		}

		for (int row = 0; row < board.length; row++) {
			if (isSafe(row, col, board)) {
				board[row][col] = 'Q';
				helper(board, allBoards, col + 1);
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

	public void saveBoard(char[][] board, List<List<String>> allBoards) {

		List<String> res = new ArrayList<>(board.length);

		for (int i = 0; i < board.length; i++)
			res.add(new String(board[i]));

		allBoards.add(res);
	}

}
