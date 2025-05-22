package org.learning.src.leetcode.home.tech.problem.linkedList;

import home.tech.problem.ListNode;
import home.tech.problem.MyLinkedNode;

public class ReverseLinkedList2 {

	public static void main(String[] args) {
		MyLinkedNode listNode = new MyLinkedNode(1, 2, 3, 4, 5);
		ListNode head = listNode.get();

		ReverseLinkedList2 obj = new ReverseLinkedList2();
		listNode.printListNodeExternal(obj.reverseBetween(head, 2, 4));
	}

	public ListNode reverseBetween(ListNode head, int l, int r) {

		ListNode subHead = head;
		ListNode prevSubHead = null;
		if (l != 1) {
			for (int i = 1; i < l - 1; i++)
				subHead = subHead.next;
			prevSubHead = subHead;
			subHead = subHead.next;
		}

		ListNode prev = null;
		ListNode curr = subHead;
		ListNode next = null;

		while (r - l >= 0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			r--;
		}
		if (prevSubHead != null) {
			prevSubHead.next = prev;
			subHead.next = curr;
			return head;
		} else {
			subHead.next = curr;
			return prev;
		}
	}

}
