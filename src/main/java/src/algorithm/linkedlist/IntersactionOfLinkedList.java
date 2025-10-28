/*
https://leetcode.com/problems/median-of-two-sorted-arrays/
* */

package src.algorithm.linkedlist;

import src.leetcode.home.tech.problem.ListNode;
import src.leetcode.home.tech.problem.MyLinkedNode;

public class IntersactionOfLinkedList {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        ListNode temp = headA;
        while (temp!=null) {
            sizeA++;
            temp=temp.next;
        }
        temp = headB;
        while (temp!=null) {
            sizeB++;
            temp=temp.next;
        }
        ListNode a = headA, b = headB;
        if (sizeA>sizeB) {
            int diff = sizeA-sizeB;
            while (diff>0) {
                a = a.next;
                diff--;
            }
        } else if (sizeA<sizeB) {
            int diff = sizeB-sizeA;
            while (diff>0) {
                b = b.next;
                diff--;
            }
        }
        while (a!=b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
