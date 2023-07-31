package com.source.open.leetcode;

public class LC_0002_Add_Two_Number {

	// Complexity Analysis

	// Time complexity: O(n).
	// We traverse the list containing n elements only once.

	// Space complexity: O(1).
	// If we leave the resultant List that we used
	// to store the result then we only used constant space.

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode root = new ListNode(0);
		ListNode curr = root;
		int carry = 0;

		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			curr.next = new ListNode(sum);
			curr = curr.next;

			l1 = l1.next;
			l2 = l2.next;
		}

		ListNode rest = l1 == null ? l2 : l1;

		while (rest != null) {
			int sum = rest.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			curr.next = new ListNode(sum);
			curr = curr.next;

			rest = rest.next;
		}

		if (carry == 1) {
			curr.next = new ListNode(1);
		}

		return root.next;
	}

}
