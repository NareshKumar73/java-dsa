package com.source.open.leetcode;

public class LC_0009_Palindrome_Number {

	public boolean isPalindrome(int x) {

		long num = 0;
		long original = x;
		boolean leadingZero = true;

		if (x == 0)
			return true;

		if (x < 0)
			return false;

		while (x > 0) {

			if (leadingZero && x % 10 == 0) {
				x /= 10;
				continue;
			} else {
				leadingZero = false;
			}

			num *= 10;
			num += (x % 10);
			x /= 10;
		}

		if (num == original)
			return true;
		else
			return false;
	}

}
