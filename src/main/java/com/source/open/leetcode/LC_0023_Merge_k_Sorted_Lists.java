package com.source.open.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_0023_Merge_k_Sorted_Lists {


	/*
	 * Runtime Details 8ms 		Beats 32.35% of users with Java
	 * Memory  Details 44.6MB 	Beats 12.34% of users with Java
	*/
	public ListNode mergeKLists(ListNode[] lists) {
		// Min Heap
		PriorityQueue<ListNode> min = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));

		int i = 0;
		while (i < lists.length) {
			ListNode head = lists[i];
			while (head != null) {
				min.add(head);
				head = head.next;
			}
			i++;
		}

		ListNode head = min.poll();
		ListNode curr = head;

		// merging LinkedList
		while (!min.isEmpty()) {
			ListNode temp = min.poll();
			temp.next = null;
			curr.next = temp;
			curr = temp;
		}

		return head;
	}

}
