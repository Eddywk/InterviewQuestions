package Others;

import java.util.ArrayList;
import java.util.Arrays;

class Sum implements Comparable<Sum>{
    int sum;
    int index;
    public Sum(int s, int i){
        this.sum = s;
        this.index = i;
    }
    
    public int compareTo(Sum other){
        return this.sum - other.sum;
    }
}

class SubarraySumClosest {
    public static ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length <= 1){
            result.add(0);
            result.add(0);
            return result;
        }
        int sum = 0;
        Sum[] sums = new Sum[nums.length];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sums[i] = new Sum(sum, i); 
        }
        Arrays.sort(sums);
        print(sums);
        int idx1 = -1, idx2 = -1;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < sums.length; i++){
        	System.out.println("i = " + i);
            if(Math.abs(sums[i].sum) < diff){
                diff = Math.abs(sums[i].sum);
                idx1 = 0;
                idx2 = sums[i].index;
                System.out.println("sums[i] = " + sums[i].sum + " diff = " + diff + " idx1 = " + idx1 + " idx2 = " + idx2);
            }
            if(i != 0 && sums[i].sum - sums[i - 1].sum < diff){
                diff = sums[i].sum - sums[i - 1].sum;
                idx1 = sums[i - 1].index < sums[i].index ? sums[i - 1].index + 1 : sums[i].index + 1;
                idx2 = sums[i - 1].index > sums[i].index ? sums[i - 1].index : sums[i].index;
                System.out.println("sums[i] = " + sums[i].sum + " sums[i - 1] = " + sums[i - 1].sum + " diff = " + diff + " idx1 = " + idx1 + " idx2 = " + idx2);
            }
            if(i != sums.length - 1 && sums[i + 1].sum - sums[i].sum < diff){
                diff = sums[i + 1].sum - sums[i].sum;
                idx1 = sums[i].index < sums[i + 1].index ? sums[i].index + 1 : sums[i + 1].index + 1;
                idx2 = sums[i].index > sums[i + 1].index ? sums[i].index : sums[i + 1].index;
                System.out.println("sums[i] = " + sums[i].sum + " sums[i + 1] = " + sums[i + 1].sum + " diff = " + diff + " idx1 = " + idx1 + " idx2 = " + idx2);
            }
        }
        result.add(idx1);
        result.add(idx2);
        return result;
    }
    
    private static void print(Sum[] S){
    	StringBuilder sb1 = new StringBuilder();
    	StringBuilder sb2 = new StringBuilder();
    	sb1.append("Sum: ");
    	sb2.append("Index: ");
    	for(Sum s : S){
    		sb1.append(s.sum + " ");
    		sb2.append(s.index + " ");
    	}
    	System.out.println(sb1.toString());
    	System.out.println(sb2.toString());
    }
    
    public static void main(String args[]){
    	int[] A = {-10,-2,-3,-100,1,2,3,-1,4};
    	subarraySumClosest(A);
    }
}
