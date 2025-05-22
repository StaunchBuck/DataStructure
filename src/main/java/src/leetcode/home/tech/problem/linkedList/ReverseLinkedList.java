package src.leetcode.home.tech.problem.linkedList;

import home.tech.problem.ListNode;
import home.tech.problem.MyLinkedNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		MyLinkedNode listNode = new MyLinkedNode(1,2,3,4);
		ListNode head = listNode.get();
		
		ReverseLinkedList obj = new ReverseLinkedList();
		listNode.printListNodeExternal(obj.reverseList(head));	

	}
	
	public ListNode reverseList(ListNode head) {
        
	    ListNode prev = null;
	    ListNode curr = head;
	    ListNode next = null;
	    
	    while(curr.next != null) {
	    	next = curr.next;
	    	curr.next = prev;
	    	prev = curr;
	    	curr = next;
	    }
	    curr.next = prev;
	    return curr;
	}

}
