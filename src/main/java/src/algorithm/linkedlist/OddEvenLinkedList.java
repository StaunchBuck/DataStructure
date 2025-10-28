package src.algorithm.linkedlist;

import src.leetcode.home.tech.problem.ListNode;
import src.leetcode.home.tech.problem.MyLinkedNode;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        MyLinkedNode obj1 = new MyLinkedNode(1,2,3,4,5);
        OddEvenLinkedList n = new OddEvenLinkedList();
        ListNode res = n.oddEvenList(obj1.get());
        obj1.printListNodeExternal(res);
    }
    public ListNode oddEvenList(ListNode head) {

        ListNode node = head;
        ListNode oddEnd = node;
        ListNode evenEnd = node.next;
        while(evenEnd != null && evenEnd.next != null){
            ListNode n = new ListNode(evenEnd.next.val);
            ListNode temp = oddEnd.next;
            oddEnd.next = n;
            n.next = temp;
            evenEnd.next = evenEnd.next.next;
            oddEnd = oddEnd.next;
            evenEnd = evenEnd.next;
        }
        return head;
    }
}
