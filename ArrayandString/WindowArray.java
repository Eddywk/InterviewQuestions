package ArrayandString;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class WindowArray {
	
    class IntEntry{
        int num;
        int index;
        public IntEntry(int n, int i){
            this.num = n;
            this.index = i;
        }
    }
	
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        Deque<IntEntry> queue = new ArrayDeque<IntEntry>();
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i >= k && i - queue.peek().index == k){
                queue.pollFirst();
            }
            while(!queue.isEmpty() && queue.peekLast().num <= nums[i]){
                queue.pollLast();
            }
            queue.add(new IntEntry(nums[i], i));
            if(i >= k - 1) result.add(queue.peek().num);
        }
        return result;
    }
}
