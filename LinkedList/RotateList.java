package LinkedList;
/*Given a list, rotate the list to the right by k places, where k is non-negative.
  For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.*/
class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n == 0){
			return head;
		}
		int len = 1;
		ListNode p = head;
		/*Get length of the linked list*/
		while(p.next != null){
			len++;
			p = p.next;
		}
		/*Compute number of steps to reach break point(n may greater than length of list, so n % len)*/
		int step = len - n % len;
		for(int i = 0; i < step; i++){
			p = p.next;
		}
		head = p.next;
		/*Break the list*/
		p.next = null;
		return head;
	}
}
