package Design;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Rehashing {
	public static ListNode[] rehashing(ListNode[] hashTable) {
        ListNode[] newList = new ListNode[hashTable.length * 2];
        int size = newList.length;
        for(ListNode node : hashTable){
            while(node != null){
            	ListNode next = node.next;
            	node.next = null;
                int key = node.val >= 0 ? node.val % size : (node.val % size + size) % size;
                if(newList[key] == null){
                    newList[key] = node;
                }else{
                    ListNode p = newList[key];
                    while(p.next != null){
                        p = p.next;
                    }
                    p.next = node;
                }
                node = next;
            }
        }
        return newList;
	}
	
	private static void print(ListNode[] table){
		for(int i = 0; i < table.length; i++){
			if(table[i] == null){
				System.out.println("Index: " + i + " null");
			}else{
				ListNode node = table[i];
				StringBuilder sb = new StringBuilder();
				sb.append("Index: " + i);
				while(node != null){
					sb.append(" " + node.val);
					node = node.next;
				}
				System.out.println(sb.toString());
			}
		}
	}
	
	public static void main(String args[]){
		ListNode[] oldTable = new ListNode[3];
		ListNode node = new ListNode(29);
		node.next = new ListNode(5);
		oldTable[2] = node;
//		print(oldTable);
		ListNode[] newTable = rehashing(oldTable);
		print(newTable);
	}
}
