package Exercise;

import LinkedList.ListNode;

class RotateLinkedList {
	
	static int length = 0;
	
	public static ListNode rotateLinkedList(ListNode head, int k){
		if(head == null){
			return null;
		}
		ListNode newHead = reverse(head);
		if(k >= length){
			return newHead;
		}
		ListNode node = newHead;
		int i = 0;
		while(i < length - k - 1){
			node = node.next;
			i++;
		}		
		ListNode tail = node.next;
		ListNode root = node.next;
		node.next = null;
		while(tail.next != null){
			tail = tail.next;
		}
		tail.next = newHead;
		return root;
	}
	
	private static ListNode reverse(ListNode head){
		ListNode prev = null;
		while(head != null){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
			length++;
		}
		return prev;
	}
	
	public static ListNode buildList(int[] A){
		ListNode head = new ListNode(A[0]);
		ListNode tmp = head;
		for(int i = 1; i < A.length; i++){
			ListNode node = new ListNode(A[i]);
			tmp.next = node;
			tmp = tmp.next;
		}
		return head;
	}
	
	public static void print(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		int[] A = {1, 2, 3, 4, 5, 6};
		ListNode head = buildList(A);
		print(head);
		head = rotateLinkedList(head, 6);
		print(head);
	}
}
