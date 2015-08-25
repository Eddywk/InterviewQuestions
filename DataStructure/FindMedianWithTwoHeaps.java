package DataStructure;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianWithTwoHeaps {
	Queue<Integer> maxHeap = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
	Queue<Integer> minHeap = new PriorityQueue<Integer>();
	
	public double getMedian(){
		if(maxHeap.isEmpty() && minHeap.isEmpty()){
			return Integer.MIN_VALUE;
		}
		Queue<Integer> heap;
		if(minHeap.size() == maxHeap.size()){
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
		heap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
		return heap.peek();
	}
	
	public void push(int x){
		if(maxHeap.isEmpty() && minHeap.isEmpty()){
			maxHeap.add(x);
			return;
		}
		if(maxHeap.size() == minHeap.size()){
			maxHeap.add(x);
			if(maxHeap.peek() > minHeap.peek()){
				shift();
			}
		}else{
			Queue<Integer> heap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
			heap.add(x);
			if(maxHeap.peek() > minHeap.peek()){
				shift();
			}
		}
	}
	
	private void shift(){
		int maxTop = maxHeap.poll();
		int minTop = minHeap.poll();
		maxHeap.add(minTop);
		minHeap.add(maxTop);
	}
}
