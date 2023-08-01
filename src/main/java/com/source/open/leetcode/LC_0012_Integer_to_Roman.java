package com.source.open.leetcode;

public class LC_0012_Integer_to_Roman {
	
	public String intToRomanSimpler(int num) {
		String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] huns = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] thos = { "", "M", "MM", "MMM" };

        return thos[ num / 1000] + 
        	   huns[(num % 1000) / 100] + 
        	   tens[(num %  100) /  10] + 
        	   ones[ num %   10];
    }

	/*
	 * Runtime Details 3ms 		Beats 99.96% of users with Java
	 * Memory  Details 42.8MB	Beats 99.80% of users with Java
     */
	public String intToRomanOptimized(int i) {

		StringBuilder sb = new StringBuilder();

		while (i >= 1000) {
			sb.append('M');
			i -= 1000;
		}
		if (i >= 900) {
			sb.append("CM");
			i -= 900;
		}
		if (i >= 500) {
			sb.append('D');
			i -= 500;
		}
		if (i >= 400) {
			sb.append("CD");
			i -= 400;
		}
		while (i >= 100) {
			sb.append('C');
			i -= 100;
		}
		if (i >= 90) {
			sb.append("XC");
			i -= 90;
		}
		if (i >= 50) {
			sb.append('L');
			i -= 50;
		}
		if (i >= 40) {
			sb.append("XL");
			i -= 40;
		}
		while (i >= 10) {
			sb.append('X');
			i -= 10;
		}
		if (i >= 9) {
			sb.append("IX");
			i -= 9;
		}
		if (i >= 5) {
			sb.append('V');
			i -= 5;
		}
		if (i == 4) {
			sb.append("IV");
			i -= 4;
		}
		while (i >= 1) {
			sb.append('I');
			i -= 1;
		}

		return sb.toString();
	}

}
