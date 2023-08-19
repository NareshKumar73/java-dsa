package com.source.open.leetcode;

public class LC_0045_Jump_Game_II {

	/*
	 * Runtime Details 1ms 	  	Beats 93.27% of users with Java 
	 * Memory  Details 45MB		Beats 11.14% of users with Java
	 */	
	public int jump(int[] nums) {
		int jumps = 0, currEnd = 0, currFarthest = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			currFarthest = Math.max(currFarthest, i + nums[i]);
			if (i == currEnd) {
				currEnd = currFarthest;
				jumps++;
			}
		}
		return jumps;
	}
	
}
