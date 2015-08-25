package Sort;

import LinkedList.ListNode;

class QuickSortLinkedList {
	
	static class ResultType{
		ListNode newHead;
		ListNode newEnd;
		ListNode pivot;
	}
	
	public static ListNode quickSort(ListNode head) {
	    // write your solution here
		if(head == null || head.next == null){
			return head;
		}
		head = quickSort(head, getTail(head), new ResultType());
		return head;
	}
  
	private static ListNode quickSort(ListNode start, ListNode end, ResultType result){
		if(start == null || start == end){
			return start;
		}
		ResultType res = partition(start, end, result.newHead, result.newEnd);
//		System.out.println(pivot.val);
//		System.out.println(newHead.val);
		if(res.newHead != res.pivot){
			ListNode node = res.newHead;
			while(node != null && node.next != null && node != res.pivot){
				node = node.next;
			}
			if(node != null) node.next = null;
			//sort left of pivot
			res.newHead = quickSort(res.newHead, node, new ResultType());
			//recover the list
			node = getTail(res.newHead);
			if(node != null) node.next = res.pivot;
		}
		//sort right of pivot
		res.pivot.next = quickSort(res.pivot.next, res.newEnd, new ResultType());
		return res.newHead;
	}
		  
	private static ResultType partition(ListNode start, ListNode end, ListNode newHead, ListNode newEnd){
		//Set end as the pivot
		ListNode pivot = end;
		ListNode prev = null;
		ListNode cur = start;
		ResultType res = new ResultType();
//		System.out.println("start: " + start.val);
//		System.out.println("end: " + end.val);
//		System.out.println("pivot: " + pivot.val);
//		System.out.println("cur: " + cur.val);
		
		//tail is for appending node to pivot
		ListNode tail = pivot;
		while(cur != pivot){
			if(cur.val < pivot.val){
				if(res.newHead == null) res.newHead = cur;
				prev = cur;
				cur = cur.next;
			}else{
				//fetch out current node and link its prev and next
				if(prev != null) prev.next = cur.next;
				ListNode next = cur.next;
				tail.next = cur;
				tail = tail.next;
				cur = next;
			}
		}
		//if pivot is the smallest element in the list
		if(res.newHead == null){
			res.newHead = pivot;
		}
		res.newEnd = tail;
		res.pivot = pivot;
//		System.out.println("newHead: " + newHead.val);
//		System.out.println("newEnd: " + newEnd.val);
		return res;
	}
  
	private static ListNode getTail(ListNode head){
		while(head != null && head.next != null){
			head = head.next;
		}
		return head;
	}
	
	private static ListNode buildList(int[] list){
		ListNode head = new ListNode(list[0]);
		ListNode node = head;
		for(int i = 1; i < list.length; i++){
			node.next = new ListNode(list[i]);
			node = node.next;
		}
		return head;
	}
	
	private static void print(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] list1 = new int[]{2, 1, 3, 4, 1};
		int[] list2 = new int[]{1, 2};
		int[] list3 = new int[]{2, 1};
		ListNode head1 = buildList(list1);
		ListNode head2 = buildList(list2);
		ListNode head3 = buildList(list3);
		head1 = quickSort(head1);
		print(head1);
//		head2 = quickSort(head2);
//		print(head2);
//		head3 = quickSort(head3);
//		print(head3);
	}
}
