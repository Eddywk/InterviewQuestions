package Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Test4 {
    public static int lengthOfLongestSubstring(String s) {
        boolean[] hash = new boolean[256];
        int start = 0;
        int result = 0;
        for(int i = 0; i < s.length(); ){
            char c = s.charAt(i);
            if(!hash[c]){
                hash[c] = true;
                result = Math.max(result, i - start + 1);
                i++;
            }else{
            	System.out.println(start+" "+i+ " "+ c);
            	int idx = start;
                while(start < i){
                    char cur = s.charAt(start);
                    if(cur == c){
                        idx = start;
                    }
                    start++;
                    hash[cur] = false;
                }
                i = idx + 1;
            }
        }
        return Math.max(result, s.length() - start + 1);
    }
    
    private static int cut(int[] L, int len){
        int count = 0;
        for(int wood : L){
            count += wood / len;
        }
        return count;
    }
    
    public static int woodCut(int[] L, int k) {
        // write your code here
        int max = Integer.MIN_VALUE;
        for(int wood : L){
            max = Math.max(wood, max);
        }
        int start = 0, end = max;
        int len = 0;
        while(start < end){
            len = start + (end - start) / 2;
            if(len == 0){
                return 0;
            }
            int num = cut(L, len);
            if(num > k){
                start = len + 1;
            }else if(num < k){
                end = len;
            }else{
            	System.out.println(len);
                while(cut(L, len) == k){
                    len++;
                }
                System.out.println(len);
                return len;
            }
        }
        return cut(L, len) == k ? len : len - 1;   
    }
    
    public static void main(String args[]){
//    	String s = "wlrbbmqb";
//    	System.out.println(lengthOfLongestSubstring(s));
//    	List<Integer> list; 
    	int[] L = {232,124,456};
    	System.out.println(woodCut(L, 7));
    	
    	Integer a = new Integer(1);
    	Integer b = new Integer(1);
    	System.out.println(a == b);
    }
}
