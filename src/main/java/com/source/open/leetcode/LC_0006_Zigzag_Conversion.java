package com.source.open.leetcode;

public class LC_0006_Zigzag_Conversion {

	public String convert(String s, int numRows) {

		if (numRows == 1)
			return s;

		int i = 0;

		StringBuilder[] map = new StringBuilder[numRows];

		for (int a = 0; a < numRows; a++)
			map[a] = new StringBuilder();

		int index = 0;

		while (i < s.length()) {

			while (i < s.length() && index < numRows) {

				map[index].append(s.charAt(i));

				index++;
				i++;
			}

			index -= 2;

			while (i < s.length() && index > -1) {

				map[index].append(s.charAt(i));

				--index;
				i++;
			}

			index = 1;
		}

		for (int b = 1; b < numRows; b++)
			map[0].append(map[b]);

		return map[0].toString();
	}

}
