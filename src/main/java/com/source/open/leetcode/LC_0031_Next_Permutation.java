package com.source.open.leetcode;

public class LC_0031_Next_Permutation {

	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 42.3MB 	Beats 50.99% of users with Java
	*/
	public void nextPermutation(int[] digits) {

		int l = 0;
		int r = digits.length - 1;
		int i = digits.length - 2;

		while (i >= 0 && digits[i] >= digits[i + 1])
			i--;

		if (i == -1) {
			while (l < r) {
				swap(digits, l, r);
				l++;
				r--;
			}
			return;
		}

		while (digits[r] <= digits[i])
			r--;

		swap(digits, i, r);

		l = i + 1;
		r = digits.length - 1;

		while (l < r) {
			swap(digits, l, r);
			l++;
			r--;
		}
	}

	void swap(int[] a, int l, int r) {
		int t = a[l];
		a[l]  = a[r];
		a[r]  = t;
	}
}
