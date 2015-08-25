package ArrayandString;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class FindSecondSmallest {
    public static int findSecondSmallest(int[] A){
        int min = A[0];
        int second = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++){
        	if(A[i] < min){
        		second = min;
        		min = A[i];
        	}else if(A[i] < second){
        		second = A[i];
        	}
        }
        return second;
    }
    
    public static int findKthSmallestByHeap(int[] A, int k){
    	Queue<Integer> heap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
    	for(int num : A){
    		if(heap.size() < k){
    			heap.add(num);
    		}else{
    			if(heap.peek() > num){
    				heap.poll();
    				heap.add(num);
    			}
    		}
    	}
    	for(int n : heap){
    		System.out.println(n);
    	}
    	return heap.peek();
    }
    
    public static int findKthSmallestByQuickSelection(int[] A, int k){
    	return findKthSmallestByQuickSelection(A, k, 0, A.length - 1);
    }
    
    public static int findKthSmallestByQuickSelection(int[] A, int k, int start, int end){
    	int key = A[start];
    	int left = start;
    	int right = end;
    	while(left < right){
    		while(left < right && A[left] < A[key]){
    			left++;
    		}
    		while(left < right && A[right] >= A[key]){
    			right--;
    		}
    		if(left < right){
    			swap(A, left, right);
    		}
    	}
    	
    	swap(A, start, right);
    	
		if(k == right + 1){
			return A[right];
		}else if(k > right + 1){
			return findKthSmallestByQuickSelection(A, k, right + 1, end);
		}else{
			return findKthSmallestByQuickSelection(A, k, start, right - 1);
		}
    }
    
    private static void swap(int[] A, int i, int j){
    	int tmp = A[i];
    	A[i] = A[j];
    	A[j] = tmp;
    }
    
    public static void main(String args[]){
    	int[] A = {1, 3, 0, 2, 4, 5};
////    	System.out.println(findSecondSmallest(A));
//    	System.out.println(findKthSmallestByHeap(A, 5));
    	System.out.println(findKthSmallestByQuickSelection(A, 2));
    }
}
