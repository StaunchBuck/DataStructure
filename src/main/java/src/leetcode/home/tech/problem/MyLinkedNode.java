package src.leetcode.home.tech.problem;

public class MyLinkedNode {

	protected static ListNode head = null;
	
	public MyLinkedNode(Integer... values) {
		head = build(values,0,values.length);
	}

	public static void main(String[] args) {
		MyLinkedNode obj = new MyLinkedNode(1,2,3,4,5);
		obj.printListNode();
		obj.get();
	}

	public ListNode get() {
		return head;
		
	}

	private static ListNode build(Integer[] values, int pos, int length) {
		if(pos == values.length) {
			return null;
		}
		ListNode nextNode = build(values,pos+1,length);
		ListNode node = new ListNode();
		node.val = values[pos];
		node.next = nextNode;
		return node;		
	}
	
	public void printListNode() {
		ListNode temp = head;
		System.out.print("[ ");
		while(temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.print("]");
		System.out.println("");
	}
	
	public void printListNodeExternal(ListNode head) {
		ListNode temp = head;
		System.out.print("[ ");
		while(temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.print("]");
		System.out.println("");
	}
	
	
	
	
	

}
