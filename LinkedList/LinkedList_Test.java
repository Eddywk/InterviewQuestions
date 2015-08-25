package LinkedList;

class LinkedList_Test {
	
	/*0->null*/
	private static LinkedList listInit0(){
		ListNode head = new ListNode(0);
		LinkedList list = new LinkedList(head);
		return list;
	}
	
	/*2->1->null*/
	private static LinkedList listInit1(){
		ListNode head = new ListNode(2);
		LinkedList list = new LinkedList(head);
		list.insert(1);
		return list;
	}
	
	/*5->4->3->2->1->null*/
	private static LinkedList listInit2(){
		ListNode head = new ListNode(5);
		LinkedList list = new LinkedList(head);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		return list;
	}
	
	/*Cycle start at 4*/
	private static LinkedList listInit3(){
		ListNode head = new ListNode(9);
		LinkedList list = new LinkedList(head);
		list.insert(8);
		list.insert(7);
		list.insert(6);
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		list.insert(0);
		ListNode n = list.find(0);
		n.next = list.find(4);
		return list;
	}
	
	private static void reverseTest(){
		
		System.out.println("Test Case 0:");
		LinkedList list0 = listInit0();
		list0.print();
		list0.reverse();
		list0.print();
		
		System.out.println("Test Case 1:");
		LinkedList list1 = listInit1();
		list1.print();
		list1.reverse();
		list1.print();
		
		System.out.println("Test Case 2:");
		LinkedList list2 = listInit2();
		list2.print();
		list2.reverse();
		list2.print();
	}
	
	private static void sortTest(){
		
		System.out.println("Test Case 0:");
		LinkedList list0 = listInit0();
		list0.print();
		list0.sort();
		list0.print();
		
		System.out.println("Test Case 1:");
		LinkedList list1 = listInit1();
		list1.print();
		list1.sort();
		list1.print();
		
		System.out.println("Test Case 2:");
		LinkedList list2 = listInit2();
		list2.print();
		list2.sort();
		list2.print();
		
	}
	
	private static void reorderTest(){
		System.out.println("Test Case 0:");
		LinkedList list0 = listInit0();
		list0.print();
		list0.reorder();
		list0.print();
		
		System.out.println("Test Case 1:");
		LinkedList list1 = listInit1();
		list1.print();
		list1.reorder();
		list1.print();
		
		System.out.println("Test Case 2:");
		LinkedList list2 = listInit2();
		list2.print();
		list2.reorder();
		list2.print();
	}
	
	private static void cycleTest(){
		System.out.println("Test Case 0:");
		LinkedList list0 = listInit0();
		//list0.print();
		if(list0.hasCycle()){
			System.out.println("list0 has a cycle.");
			System.out.println("Cycle start at node: "+ list0.findCycleNode().val);
		}else{
			System.out.println("list0 has not a cycle.");
		}
		
		System.out.println("Test Case 3:");
		LinkedList list3 = listInit3();
		//list3.print();
		if(list3.hasCycle()){
			System.out.println("list3 has a cycle.");
			System.out.println("Cycle start at node: "+ list3.findCycleNode().val);
		}else{
			System.out.println("list3 has not a cycle.");
		}
	}
	
	private static void rangeReverseTest(){
		
		System.out.println("Test Case 1:");
		LinkedList list1 = listInit1();
		list1.print();
		list1.rangeReverse(1, 2);
		list1.print();
		
		System.out.println("Test Case 2:");
		LinkedList list2 = listInit2();
		list2.reverse();
		list2.print();
		list2.rangeReverse(2, 4);
		list2.print();
	}
	
	public static void main(String args[]){
		reverseTest();
		sortTest();
		reorderTest();
		cycleTest();
		rangeReverseTest();
	}
}
