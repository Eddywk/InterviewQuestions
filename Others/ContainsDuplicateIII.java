package Others;

import java.util.HashMap;

class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0){
            return false;
        }
        HashMap<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            long num = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = num / ((long)t + 1);
            System.out.println("Bucket = " + bucket);
            if(map.containsKey(bucket) //In the same bucket
            || (map.containsKey(bucket - 1) && num - map.get(bucket - 1) <= t)
            || (map.containsKey(bucket + 1) && map.get(bucket + 1) - num <= t)){
                return true;
            }
            if(map.entrySet().size() >= k){
                long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, num);
        }
        return false;
    }
    
    public static void main(String[] args){
    	int[] nums = {-1, -1};
    	System.out.println(containsNearbyAlmostDuplicate(nums, 1, 0));
    }
}
