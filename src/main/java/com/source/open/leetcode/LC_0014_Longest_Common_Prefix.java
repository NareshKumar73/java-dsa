package com.source.open.leetcode;

public class LC_0014_Longest_Common_Prefix {

	/*		
	 *	Runtime Details 1ms		Beats 82.90%  of users with Java
	 *	Memory  Details 39.8MB 	Beats 99.58%  of users with Java
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 1)
			return strs[0];

		int shortestStringIndex = 0;
		int shortestLen = strs[0].length();

		for (int i = 1; i < strs.length; i++) {
			int len = strs[i].length();
			if (shortestLen > len) {
				shortestLen = len;
				shortestStringIndex = i;
			}
		}

		int lastCommonLetter = shortestLen - 1;

		for (int i = 0; i < strs.length; i++) {
			for (int k = lastCommonLetter; k >= 0; k--) {
				if (strs[i].charAt(k) != strs[shortestStringIndex].charAt(k))
					lastCommonLetter = k - 1;
			}

			if (lastCommonLetter < 0)
				return "";
		}

		return strs[shortestStringIndex].substring(0, lastCommonLetter + 1);
	}
}
