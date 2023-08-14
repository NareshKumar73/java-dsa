package com.source.open.leetcode;

public class LC_0287_Find_the_Duplicate_Number {

	/*
	 * Runtime Details 4ms 		Beats 87.87% of users with Java
	 * Memory  Details 56.22MB 	Beats 86.77% of users with Java
	*/	
	public int findDuplicate(int[] nums) {

	// while the value at index 0 is not equal to the value stored at value index
	// e.g. num[0] = 5 and num[5] = 5 so exit we found our duplicate
	// e.g. num[0] = 4 and num[4] = 3 so now we will store this 3 in next
	// and put our 4 to index 4 and in next iteration we check for our new number 3
	// till all are sorted and only duplicate is left at nums[0].
		while (nums[0] != nums[nums[0]]) {
			int next = nums[nums[0]];
			nums[nums[0]] = nums[0];
			nums[0] = next;
		}

		return nums[0];
	}
}
