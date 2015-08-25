package LinkedList;

class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null){
			return;
		}
		ListNode mid = findMid(head);
		ListNode right = mid.next;
		mid.next = null;
		right = reverse(right);
		merge(head, right);
	}
	
	private ListNode reverse(ListNode head){
		ListNode prev = null;
		while(head != null){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	private ListNode findMid(ListNode head){
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private void merge(ListNode head1, ListNode head2){
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		dummy.next = node;
		while(head1 != null || head2 != null){
			if(head1 != null){
				node.next = head1;
				node = head1;
				head1 = head1.next;
			}
			if(head2 != null){
				node.next = head2;
				node = head2;
				head2 = head2.next;
			}
		}
	}
}
