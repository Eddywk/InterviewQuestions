package Sort;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class FindKthLargestNumber {
	/*Version 1: Partition*/
	public static int findkthSmallest(int[] num, int k){
		if(num == null || num.length == 0 || k < 1 || k > num.length){
			return -1;
		}
		return findkthSmallest(num, k, 0, num.length - 1);
	}
	
	private static int findkthSmallest(int[] num, int k, int start, int end){
		int pivot = start;
		int left = start;
		int right = end;
		while(left < right){
			while(num[left] < num[pivot] && left < right){
				left++;
			}
			while(num[right] >= num[pivot] && left < right){
				right--;
			}
			if(left < right){
				swap(num, left, right);
			}
		}
		
		swap(num, pivot, right);
		
		if(k == right + 1){
			return num[right];
		}else if(k > right + 1){
			return findkthSmallest(num, k, right + 1, end);
		}else{
			return findkthSmallest(num, k, start, right - 1);
		}
	}
	
	/*Version 2: Quick Selected*/
	public static int findkthSmallest2(int[] num, int k){
		if(num == null || num.length == 0 || k < 1 || k > num.length){
			return -1;
		}
		return quickSelect(num, k, 0, num.length - 1);
	}	
	
	private static int quickSelect(int[] num, int k, int start, int end){
		int pos = start;
		int key = end;
		for(int i = start; i < end; i++){
			if(num[i] <= num[key]){
				swap(num, pos, i);
				pos++;
			}
		}
		swap(num, key, pos);
		int leftLen = pos - start;
		if(k == leftLen + 1){
			return num[pos];
		}else if(k < leftLen + 1){
			return quickSelect(num, k, start, pos - 1);
		}else{
			return quickSelect(num, k - leftLen - 1, pos + 1, end);
		}
	}
	
	private static void swap(int[] num, int a, int b){
		int tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
	}
	
	/*Find k largest Number*/
	public static int findkthLargest(int[] num, int k){
		if(num == null || num.length == 0 || k < 1 || k > num.length){
			return -1;
		}
		return findkthLargest(num, num.length - k + 1, 0, num.length - 1);
	}	
	
	private static int findkthLargest(int[] num, int k, int start, int end){
		int pos = start;
		int key = end;
		for(int i = start; i < end; i++){
			if(num[i] >= num[key]){
				swap(num, pos , i);
				pos++;
			}
		}
		swap(num, pos, key);
		int leftLen = pos - start;
		if(k == leftLen + 1){
			return num[pos];
		}else if(k < leftLen + 1){
			return findkthLargest(num, k, start, pos - 1);
		}else{
			return findkthLargest(num, k - leftLen - 1, pos + 1, end);
		}
	}
	
	/*Version 2: Using k size heap*/
	public static int findkthByHeap(int[] num, int k){
		if(k < 1 || k > num.length){
			return -1;
		}
		Queue<Integer> heap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		for(int i = 0; i < num.length; i++){
			if(i < k){
				heap.add(num[i]);
			}else{
				if(num[i] < heap.peek()){
					heap.poll();
					heap.add(num[i]);
				}
			}
		}
		return heap.peek();
	}
	
	public static void main(String args[]){
		int[] num = new int[20];
		java.util.Random myRandom = new java.util.Random();
		for(int i = 0; i < num.length; i++){
			num[i] = myRandom.nextInt(100);
			System.out.print(num[i] + " ");
		}
		System.out.println();
		System.out.println("Result:" + findkthSmallest(num, 3));
		System.out.println("Result:" + findkthByHeap(num, 3));
		System.out.println("Result:" + findkthSmallest2(num, 3));
	}
}
