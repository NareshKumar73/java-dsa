package com.source.open.leetcode;

public class LC_0019_Remove_Nth_Node_From_End_of_List {

	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 40.2MB 	Beats 95.72% of users with Java
	*/
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode res = head;

		int count = 0;

		ListNode walk = head;

		while (walk != null) {
			walk = walk.next;
			count++;
		}

		if (count == 0)
			return null;

		if (n == count)
			return res.next;

		int runTo = count - n;

		while (--runTo > 0) {
			head = head.next;
		}

		head.next = head.next.next;

		return res;
	}

}
