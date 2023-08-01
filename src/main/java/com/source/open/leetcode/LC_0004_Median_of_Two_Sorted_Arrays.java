package com.source.open.leetcode;

public class LC_0004_Median_of_Two_Sorted_Arrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;

		boolean odd = (((len1 + len2) & 1) == 1);

		double d;

		if (len1 == 0)
			d = odd ? nums2[len2 / 2] : (nums2[(len2 / 2) - 1] + nums2[len2 / 2]) / 2.0;
		else if (len2 == 0)
			d = odd ? nums1[len1 / 2] : (nums1[(len1 / 2) - 1] + nums1[len1 / 2]) / 2.0;
		else {

			int halfLen = (len1 + len2) / 2;

			int[] nums3 = new int[halfLen + 2];

			int i = 0, j = 0, k = 0;

			while (i < len1 && j < len2 && k < halfLen + 2) {
				nums3[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
			}

			if (i == len1) {
				while (j < len2 && k < halfLen + 2) {
					nums3[k++] = nums2[j++];
				}
			} else if (j == len2) {
				while (i < len1 && k < halfLen + 2) {
					nums3[k++] = nums1[i++];
				}
			}

			if (odd)
				d = nums3[halfLen];
			else
				d = (double) (nums3[halfLen - 1] + nums3[halfLen]) / 2.0;
		}
		
		return d;
	}
	
}
