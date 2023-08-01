package com.source.open.leetcode;

public class LC_0025_Reverse_Nodes_in_k_Group {


	/*
	 * Runtime Details 0ms 		Beats 100% of users with Java
	 * Memory  Details 43.6MB 	Beats 23%  of users with Java
	*/
	public ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode dummy = new ListNode(0);
		
		dummy.next = head;

		ListNode prevGroupTail = dummy;

		while (head != null) {
			int count = 0;
			ListNode groupHead = head;

			// Find the tail of the current group
			while (head != null && count < k) {
				head = head.next;
				count++;
			}

			// If there are less than k nodes remaining, break the loop
			if (count < k) {
				break;
			}

			// Reverse the current group
			ListNode current = groupHead;
			ListNode prev = null;
			ListNode next;
			for (int i = 0; i < k; i++) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}

			// Connect the reversed group to the previous group
			prevGroupTail.next = prev;
			groupHead.next = current;
			prevGroupTail = groupHead;
		}

		return dummy.next;
	}
	
}
