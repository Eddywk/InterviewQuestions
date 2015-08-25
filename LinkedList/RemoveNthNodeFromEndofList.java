package LinkedList;
/*Given a linked list, remove the nth node from the end of list and return its head.
  For example,
   	Given linked list: 1->2->3->4->5, and n = 2.
   	After removing the second node from the end, the linked list becomes 1->2->3->5.
  Note:
  Given n will always be valid.
  Try to do this in one pass.*/
class RemoveNthNodeFromEndofList {
	/*Using two pointers, one is n-steps ahead than another*/
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n <= 0){
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		int count = 0;
		while(fast != null && count < n){
			fast = fast.next;
			count++;
		}
		/*Handling special case: Head need to be removed.*/
		if(count == n && fast == null){
			return head.next;
		}
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		/*Delete target node*/
		slow.next = slow.next.next;
		return head;
	}
}
