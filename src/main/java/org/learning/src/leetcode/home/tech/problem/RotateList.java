package org.learning.src.leetcode.home.tech.problem;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        k = k%size;

        ListNode pointer1 = new ListNode(-1000,head);
        ListNode pointer2 = head;
        int count = 0;
        while(true){
            
            if(pointer2.next != null){
                count++;
                pointer2 = pointer2.next;
                if(count >= k)
                    pointer1 = pointer1.next;
            }else
                break;     
        }
        System.out.println(pointer1.val+" "+pointer2.val+" "+k);
        ListNode newHead = pointer1.next;
        pointer1.next = null;
        pointer2.next = head;
        return newHead;
    }

}
