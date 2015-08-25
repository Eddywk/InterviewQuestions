package LinkedList;

class LinkedList {
	ListNode head = null;
	ListNode tail = null;
	
	LinkedList(ListNode head){
		this.head = head;
		this.tail = this.head;
	}
	
	public void print(){
		StringBuffer sb = new StringBuffer();
		ListNode node = head;
		while(node != null){
			sb.append(node.val + " ");
			node = node.next;
		}
		System.out.println(sb.toString());
	}
		
	
	public ListNode find(int x){
		ListNode node = head;
		while(node != null){
			if(node.val == x){
				//System.out.println("Find node: "+node.val);
				return node;
			}
			node = node.next;
		}		
		return null;
	}
	
	/*Reverse a linked list*/
	public void reverse(){
		ListNode prev = null;
		while(head != null){
			/*Store current head's next node*/
			ListNode next = head.next;
			/*Change next pointer to its previous node*/
			head.next = prev;
			/*Store current head as previous node of next head*/
			prev = head;
			/*Current head move to next node*/
			head = next;
		}
		this.head = prev;
	}
	
	/*Using merge sort to sort a linked list*/
	public void sort(){
		if(head == null || head.next == null) return;
		this.head = mergesort(this.head);
	}
	
	/*Insert a node into this linked list*/
	public void insert(int x){
		ListNode node = new ListNode(x);
		tail.next = node;
		tail = node;
	}
	
	
	public void reorder(){
		if(head == null || head.next == null) return;
		
		ListNode mid = findMid(head);
		ListNode tail = reverse(mid.next);
		mid.next = null;
		mergeReorder(head, tail);
	}
	
	/*Judge a linked list has a cycle or not*/
	public boolean hasCycle(){
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}
	
	public ListNode findCycleNode(){
		if(hasCycle()){
			ListNode slow = head;
			ListNode fast = head;
			while(fast != null && fast.next != null){
				slow = slow.next;
				fast = fast.next.next;
				if(slow == fast){
					slow = head;
					break;
				}
			}
			while(slow != fast){
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}else{
			return null;
		}
	}
	
	/*Reverse a linked list from position m to n. Do it in-place and in one-pass.*/
	public void rangeReverse(int m, int n){
		/*Error Checking: Empty list or only one element*/
		if(head == null || head.next == null) return;
		
		/*Set up dummy node, because head may change*/
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		/*newHead: The head of reversed sub-list
		 *newTail: The tail of reversed sub-list*/
		ListNode newHead, newTail;
		/*prev: The node before newHead in original list
		 *post: The node after newTail in original list*/
		ListNode prev = head, post = head;
		/*Find prev in original list*/
		int p = m -1;
		while(p > 0){
			prev = prev.next;
			p--;
		}
		/*Find post in original list*/
		int q = n + 1;
		while(q > 0){
			post = post.next;
			q--;
		}
		/*Initialize newTail and newHead*/
		newTail = newHead= prev.next;
		/*Reverse sub-list*/
		int k = n - m;
		ListNode last = null;
		while(newHead != null && k >= 0){
			ListNode next = newHead.next;
			newHead.next = last;
			last = newHead;
			newHead = next;
			k--;
		}
		newHead = last;
		/*Combine all parts*/
		prev.next = newHead;
		newTail.next = post;
		/*Set new head after reverse*/
		this.head = dummy.next;
	}
	
	/*******************************************
	 *************Private Functions*************
	 *******************************************/
	
	/*Reverse a linked list*/
	private ListNode reverse(ListNode head){
		ListNode prev = null;
		while(head != null){
			/*Store current head's next node*/
			ListNode next = head.next;
			/*Change next pointer to its previous node*/
			head.next = prev;
			/*Store current head as previous node of next head*/
			prev = head;
			/*Current head move to next node*/
			head = next;
		}
		return prev;
	}
	
	private void mergeReorder(ListNode head1, ListNode head2){
		ListNode dummy = new ListNode(0);
		int index = 0;
		while(head1 != null && head2 != null){
			if(index % 2 == 0){
				dummy.next = head1;
				head1 = head1.next;
			}else{
				dummy.next = head2;
				head2 = head2.next;
			}
			
			dummy = dummy.next;
			index++;
		}
		
		if(head1 != null){
			dummy.next = head1;
		}
		if(head2 != null){
			dummy.next = head2;
		}
	}
	
	/*Merge Sort main function*/
	private ListNode mergesort(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode mid = findMid(head);
		ListNode right = mergesort(mid.next);
		/*Cut the linked list into two sub lists*/
		mid.next = null;
		ListNode left = mergesort(head);
		return merge(left, right);
	}
	
	/*Find the middle node start from head h*/
	private ListNode findMid(ListNode h){
		ListNode slow = h;
		ListNode fast = h.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private ListNode merge(ListNode head1, ListNode head2){
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while(head1 != null && head2 != null){
			if(head1.val < head2.val){
				tail.next = head1;
				head1 = head1.next;
			}else{
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		/*Add remaining node from list1 or list2*/
		if(head1 != null){
			tail.next = head1;
		}
		if(head2 != null){
			tail.next = head2;
		}
		/*Return new head of sorted sub list*/
		return dummy.next;
	}
	
}
