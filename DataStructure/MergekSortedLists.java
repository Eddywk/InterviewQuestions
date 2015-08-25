package DataStructure;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*Definition for singly-linked list.*/
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.*/
class MergekSortedLists {
	
	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
		public int compare(ListNode n1, ListNode n2){
			return n1.val - n2.val;
		}
	};
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.size() == 0){
			return null;
		}
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
		/*Initialization: Add all heads into heap*/
		for(int i = 0; i < lists.size(); i++){
			if(lists.get(i) != null){
				heap.add(lists.get(i));
			}
		}
		/*Build new list*/
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while(!heap.isEmpty()){
			ListNode cur = heap.poll();
			head.next = cur;
			head = cur;
			if(cur.next != null){
				heap.add(cur.next);
			}
		}
		return dummy.next;
	}
}
