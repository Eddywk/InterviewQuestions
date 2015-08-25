package ArrayandString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class NumberCount implements Comparable<NumberCount>{
	int num;
	int count = 0;
	public NumberCount(int n){
		this.num = n;
		count++;
	}
    public NumberCount(int n, int c){
        this.num = n;
        this.count = c;
    }
	@Override
	public int compareTo(NumberCount o) {
		// TODO Auto-generated method stub
		return this.count - o.count;
	}
}

class TopKFrequencyNumber {
	public static List<Integer> findTopKFrequencyNumber(int[] A, int k){
		List<Integer> result = new ArrayList<Integer>();
		Queue<NumberCount> heap = new PriorityQueue<NumberCount>(k);
		HashMap<Integer, NumberCount> map = new HashMap<Integer, NumberCount>();
		for(int num : A){
			if(!map.containsKey(num)){
				map.put(num, new NumberCount(num));
			}else{
				map.get(num).count++;
			}
		}
		for(int num : map.keySet()){
			if(heap.size() < k){
				heap.add(map.get(num));
			}else{
				if(heap.peek().count < map.get(num).count){
					heap.poll();
					heap.add(map.get(num));
				}
			}
		}
		while(!heap.isEmpty()){
			result.add(heap.poll().num);
		}
		return result;
	}
	
    //Sorted large size array
    public static List<Integer> findTopKNumbersInSortedArray(int[] A, int k){
        List<Integer> result = new ArrayList<Integer>();
        Queue<NumberCount> heap = new PriorityQueue<NumberCount>(k);
        int prev = A[0];
        int count = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] == prev){
                count++;
            }else{
                if(heap.size() < k){
                    heap.add(new NumberCount(prev, count));
                }else{
                    if(heap.peek().count < count){
                        heap.poll();
                        heap.add(new NumberCount(prev, count));
                    }
                }
                prev = A[i];
                count = 1;
            }
        }
        if(heap.size() < k){
            heap.add(new NumberCount(prev, count));
        }else{
            if(heap.peek().count < count){
                heap.poll();
                heap.add(new NumberCount(prev, count));
            }
        }
        while(!heap.isEmpty()){
            result.add(heap.poll().num);
        }
        return result;
    }
	
	public static void main(String args[]){
		int[] A = {1, 1, 2, 2, 2, 3, 3, 3, 3, 3};
//		List<Integer> res = findTopKFrequencyNumber(A , 2);
		List<Integer> res = findTopKNumbersInSortedArray(A, 2);
		for(int num : res){
			System.out.print(num + " ");
		}
	}
}
