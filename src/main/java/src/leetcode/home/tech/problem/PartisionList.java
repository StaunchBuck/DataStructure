package src.leetcode.home.tech.problem;

public class PartisionList {

	public static void main(String[] args) {
		
		ListNode one6 = new ListNode(2,null);
		ListNode one5 = new ListNode(5,one6);
		ListNode one4 = new ListNode(2,one5);
		ListNode one3 = new ListNode(0,one4);
		ListNode one2 = new ListNode(3,one3);
		ListNode one1 = new ListNode(4,one2);
		ListNode one = new ListNode(1,one1);
		
		ListNode temp = one;
		while(temp != null) {
			System.out.print(" "+temp.val);
			temp=temp.next;
		}
		System.out.println("");
		ListNode result = new PartisionList().partition(one,3);
		
		ListNode temp1 = result;
		while(temp1 != null) {
			System.out.print(" "+temp1.val);
			temp1=temp1.next;
		}

	}
	// 1 4 3 0 2 5 2   -> 3
	public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(90,head);
        ListNode pointer1 = dummy;
        ListNode pointer2 = dummy;
        
        while(pointer2 != null){
            if(pointer2.next != null && pointer2.next.val < x){
                if(pointer1 == pointer2){
                    pointer1 = pointer1.next;
                }else{
                    ListNode temp1 = pointer1.next;
                    pointer1.next = pointer2.next;
                    ListNode temp2 = pointer2.next.next;
                    pointer2.next.next = temp1;
                    pointer2.next = pointer2.next.next;
                    pointer2.next = temp2;
                    pointer1 = pointer1.next;
                    continue;
                }
            }
            pointer2 = pointer2.next; 
        }
        return dummy.next;
    }
}