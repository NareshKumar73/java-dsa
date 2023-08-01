package com.source.open.leetcode;

public class LC_0024_Swap_Nodes_in_Pairs {


	/*
	 * Runtime Details 0ms 		Beats 100%   of users with Java
	 * Memory  Details 40.1MB 	Beats 80.64% of users with Java
	*/
	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode root = new ListNode(0), even;

		root.next = head;
		even = root;

		while (head != null && head.next != null) {
			even.next = head.next;
			head.next = head.next.next;

			even.next.next = head;
			even = even.next.next;

			head = head.next;
		}
		return root.next;
	}
	
}
