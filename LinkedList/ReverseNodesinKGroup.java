package LinkedList;
/*Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
  If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
  You may not alter the values in the nodes, only nodes itself may be changed.
  Only constant memory is allowed.
	For example,
	Given this linked list: 1->2->3->4->5
	For k = 2, you should return: 2->1->4->3->5
	For k = 3, you should return: 3->2->1->4->5*/
public class ReverseNodesinKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		int size = size(head);
		int i = 0;
		ListNode dummy = new ListNode(0);
		ListNode tail = null;
		dummy.next = tail;
		tail = dummy;
		while(i < size - size % k){
			ListNode next = getNext(head, k);
			ListNode cur = reverse(head, k);
			tail.next = cur;
			tail = head;
			head = next;
			i += k;
		}
		while(head != null){
			tail.next = head;
			tail = head;
			head = head.next;
		}
		return dummy.next;
	}
	
	/*Reverse k nodes*/
	private ListNode reverse(ListNode head, int k){
		int count = 0;
		ListNode prev = null;
		while(head != null && count < k){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
			count++;
		}
		return prev;
	}
	
	/*Return next node and break the link*/
	private ListNode getNext(ListNode head, int k){
		int count = 0;
		while(head != null && count < k - 1){
			head = head.next;
			count++;
		}
		ListNode next = head.next;
		head.next = null;
		return next;
	}
	
	/*Return size of linked list*/
	private int size(ListNode head){
		int count = 0;
		while(head != null){
			head = head.next;
			count++;
		}
		return count;
	}
}
