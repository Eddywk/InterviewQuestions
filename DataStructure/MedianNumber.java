package DataStructure;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianNumber {
	Queue<Integer> min_heap;
	Queue<Integer> max_heap;
	
	public MedianNumber(){
		this.max_heap = new PriorityQueue<Integer>(100, Collections.reverseOrder());
		this.min_heap = new PriorityQueue<Integer>();
	}
	
	public int getMedianNumber(int number){
		if(max_heap.isEmpty()){
			max_heap.offer(number);
			return number;
		}
		int median;
		if(max_heap.size() <= min_heap.size()){
			median = min_heap.peek();
			if(min_heap.size() - max_heap.size() > 1){
				max_heap.offer(min_heap.poll());
			}
		}else{
			median = max_heap.peek();
			if(max_heap.size() - min_heap.size() > 1){
				min_heap.offer(max_heap.poll());
			}
		}
		min_heap.offer(number);
		return median;
	}
	
	public void testMaxHeap(int number){
		max_heap.offer(number);
		System.out.println(max_heap.peek());
	}
	
	public void testMinHeap(int number){
		min_heap.offer(number);
		System.out.println(min_heap.peek());
	}
	
	public static void main(String args[]){
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] num2 = {3, 1, 2, 5, 4, 7, 6, 9};
		MedianNumber mn = new MedianNumber();
		for(int i = 0; i < num.length; i++){
			System.out.println("Adding "+ num[i]+", Now median is: " + mn.getMedianNumber(num[i]) + " [Max-Heap Size: "+ mn.max_heap.size() + " Min-Heap Size: " + mn.min_heap.size() +"]");
			//mn.testMaxHeap(num2[i]);
			//mn.testMinHeap(num2[i]);
		}
	}
}
