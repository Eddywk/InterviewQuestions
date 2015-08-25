package DataStructure;

import java.util.PriorityQueue;
import java.util.Queue;
/*Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.
  The eligible numbers are like 3, 5, 7, 9, 15 ...
	Example
	If k=4, return 9.*/
class KthPrimeNumber {
	public long kthPrimeNumber(int k) {
		if(k < 1){
			return -1;
		}
		int[] factors = {3, 5, 7};
		/*Make sure using heap, because each time the smallest prime number that 
		 *poll out from heap, so you will not miss any primes!*/
		/*And the (k + 1)th number poll out from heap is we want, become we push 1
		 *in the first place.*/
		Queue<Long> heap = new PriorityQueue<Long>();
		heap.add((long)1);
		int count = 0;
		while(true){
			long cur = heap.poll();
			count++;
			if(count == k + 1){
				return cur;
			}
			for(int num : factors){
				long prime = num * cur;
				if(heap.contains(prime)){
					continue;
				}
				heap.add(prime);
			}
		}	
	}
}
