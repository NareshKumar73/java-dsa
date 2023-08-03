package com.source.open.leetcode;

public class LC_0041_First_Missing_Positive {

	/*
	 * Runtime Details 1ms 	  Beats 99.91% of users with Java 
	 * Memory Details 58.45MB Beats 74.17% of users with Java
	 */
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;

		boolean[] exist = new boolean[nums.length];

		for (int i = 0; i < len; i++)
			if (nums[i] <= len && nums[i] > 0)
				exist[nums[i] - 1] = true;

		for (int i = 0; i < len; i++)
			if (!exist[i])
				return ++i;

		return nums.length + 1;
	}

	public int firstMissingPositiveCycleSort(int[] nums) {

		// the first two conditions in the if statement take care
		// that negatives and elements greater than the size of
		// the array are ignored, while applying cycle sort, and
		// rest is the similar code of cycle sort

		int i = 0;
		while (i < nums.length) {
			int correct = nums[i] - 1;
			if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[correct]) {

				int temp = nums[i];
				nums[i] = nums[correct];
				nums[correct] = temp;
			} else {
				i++;
			}
		}

		// after cycle sort has been applied, we will find the first element
		// which is not at the correct index, and return that index + 1

		for (int j = 0; j < nums.length; j++) {

			if (nums[j] != j + 1) {
				return j + 1;
			}
		}

		// if every element is at its correct index, then obviously the first
		// missing positive integer is nums.length + 1

		return nums.length + 1;
	}

}
