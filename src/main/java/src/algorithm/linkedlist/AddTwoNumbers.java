package src.algorithm.linkedlist;

import src.leetcode.home.tech.problem.ListNode;
import src.leetcode.home.tech.problem.MyLinkedNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
//        MyLinkedNode obj1 = new MyLinkedNode(2,4,3);
//        MyLinkedNode obj2 = new MyLinkedNode(5,6,4);

        MyLinkedNode obj1 = new MyLinkedNode(9,9);
        MyLinkedNode obj2 = new MyLinkedNode(1);

//      obj.printListNode();
        ListNode ln1 = obj1.get();
        ListNode ln2 = obj2.get();
        AddTwoNumbers s = new AddTwoNumbers();
        obj1.printListNodeExternal(s.addTwoNumbers(ln1,ln2));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = 0;
            int val2 = 0;
            if(l1 != null){
                val1 = l1.val;
                l1=l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2=l2.next;
            }
            int sum = val1+val2+carry;
            if(sum>9){
                node.val = sum%10;
                carry = 1;
            }else{
                node.val = sum;
                carry = 0;
            }
            if(l1 != null || l2 != null)
                node.next = new ListNode(0);
            else{
                if(carry != 0){
                    node.next = new ListNode(1);
                }
            }
            node = node.next;
        }
        return head;
    }

}
