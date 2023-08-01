package com.source.open.leetcode;

public class LC_0021_Merge_Two_Sorted_Lists {

	/*
	 * Runtime Details 0ms 		Beats 100%  of users with Java
	 * Memory  Details 42.4MB 	Beats 6.89% of users with Java
	*/
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		ListNode head = new ListNode(0);

		ListNode res = head;

		while (list1 != null && list2 != null) {

			if (list1.val <= list2.val) {
				head.next = list1;
				list1 = list1.next;
				head = head.next;
			} else {
				head.next = list2;
				list2 = list2.next;
				head = head.next;
			}
		}

		if (list1 != null) {
			head.next = list1;
		}

		if (list2 != null) {
			head.next = list2;
		}

		return (res == null) ? res : res.next;
	}
}
