package src.leetcode.home.tech.problem.linkedList;


import src.leetcode.home.tech.problem.ListNode;
import src.leetcode.home.tech.problem.MyLinkedNode;

public class ReorderList {
	public static ListNode newHead = null;
	public static boolean complete = false;
	
	public static void main(String[] args) {
		MyLinkedNode obj = new MyLinkedNode(1,2);
		new ReorderList().reorderList(obj.get());
		obj.printListNode();

	}
	
	public void reorderList(ListNode head) {
		newHead = head;
		new ReorderList().perform(head);
	}

	public ListNode perform(ListNode currentNode) {
		ListNode nextNode;
		if (currentNode.next != null)
			nextNode=perform(currentNode.next);
		else
			return currentNode;
		
		if (newHead.next == currentNode) {
			complete = true;
			newHead.next=nextNode;
			nextNode.next=currentNode;
			currentNode.next=null;
		}else if(newHead == currentNode) {
			complete = true;
		}
		if(!complete) {
			currentNode.next=null;
			ListNode temp = newHead.next;
			newHead.next = nextNode;
			nextNode.next = temp;
			newHead = temp;
		}

		return currentNode;
	}
}
