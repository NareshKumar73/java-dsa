package com.source.open.leetcode;

public class LC_0011_Container_With_Most_Water {

	// Complexity Analysis

	// Time complexity: O(n).
	// We traverse the array containing n elements only once.
	// Space complexity: O(1).

	/*
	 * Runtime Details 2ms 		Beats 99.46% of users with Java
	 * Memory  Details 55.52mb 	Beats 72.86% of users with Java						
	 */
	public int maxAreaOptimized(int[] height) {

		int l = 0, r = height.length - 1;
		int area = 0, max = 0;

		while (l < r) {

			if (height[l] < height[r]) {
				area = height[l] * (r - l);
				l++;
			} else {
				area = height[r] * (r - l);
				r--;
			}

			if (max < area)
				max = area;
		}

		return max;
	}

	
	public int maxAreaReadable(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int max = 0;

		while (left < right) {
			int w = right - left;
			int h = Math.min(height[left], height[right]);
			int area = h * w;

			max = Math.max(max, area);

			if (height[left] < height[right])
				left++;
			else if (height[left] > height[right])
				right--;
			else {
				left++;
				right--;
			}
		}

		return max;
	}
	
}
