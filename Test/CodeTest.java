package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class CodeTest {
	
    public ArrayList<Integer> getAllPrimes(int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n <= 0){
            return result;
        }
        /*Base Cases*/
        result.add(1);
        result.add(2);
        for(int i = 3; i <= n; i++){
            /*Check current number*/
            if(isPrime(result, i)){
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean isPrime(ArrayList<Integer> set, int num){
        for(int prime : set){
            if(num % prime == 0){
                return false;
            }
        }
        return true;
    }
    
    public static void mergesort(int[] num){
        int[] copy = new int[num.length];
        mergesort(num, 0, num.length - 1, copy);
    }
    
    private static void mergesort(int[] num, int start, int end, int[] copy){
    	if(start < end){
	        int mid = start + (end - start) / 2;
	        mergesort(num, start, mid, copy);
	        mergesort(num, mid + 1, end, copy);
	        merge(num, start, mid, end, copy);
    	}
    }
    
    private static void merge(int[] num, int start, int mid, int end, int[] copy){
        for(int i = start; i <= end; i++){
            copy[i] = num[i];
        }
        int left = start;
        int right = mid + 1;
        int cur = start;
        while(left <= mid && right <= end){
            if(copy[left] <= copy[right]){
                num[cur] = copy[left];
                left++;
            }else{
                num[cur] = copy[right];
                right++;
            }
            cur++;
        }
        int remain = mid - left;
        for(int i = 0; i <= remain; i++){
            num[cur++] = copy[left++];
        }
    }
	
    private static boolean isValid(String s){
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '('){
                stack.push(cur);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            stack.pop();
        }
        if(stack.size() != 0){
            return false;
        }
        return true;
    }
    
    public static int maximumSubarray(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
            System.out.print(sum[i] + " ");
        }
        int max = Integer.MIN_VALUE; 
        for(int i = 1; i < sum.length; i++){
            for(int j = 0; j < i; j++){
                max = Math.max(max, sum[i] - sum[j]);
            }
        }
        return max;
    }
    
    private static int getDigitNumber(int n){
        int count = 0;
        while(n != 0){
            n /= 10;
            count++;
        }
        return count;
    }
    
    private static int getDigit(int n, int i){
        n = (int) (n % Math.pow(10, i));
        n /= Math.pow(10, i - 1);
        return n;
    }
    
    private static void printDigit(int n){
    	while(n != 0){
    		int num = n % 10;
    		System.out.println(num);
    		n = (n - num) / 10;
    	}
    }
    
    public static int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        int[] sum = new int[size + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums.get(i - 1);
        }
        int[] left_max = new int[size];
        int[] left_min = new int[size];
        int[] right_max = new int[size];
        int[] right_min = new int[size];
        left_max[0] = left_min[0] = nums.get(0);
        right_max[1] = right_min[1] = nums.get(1);
        for(int i = 1; i < size; i++){
            left_max[i] = Math.max(left_max[i - 1], sum[i + 1]);
            left_min[i] = Math.min(left_min[i - 1], sum[i + 1]);
            for(int j = i + 1; j < size; j++){
            	int min = Integer.MAX_VALUE;
            	int max = Integer.MIN_VALUE;
            	for(int k = j; k <= size; k++){
            		int num = sum[k] - sum[i];
            		System.out.println(num);
            		min = Math.min(min, num);
            		max = Math.max(max, num);
            	}
            	right_max[j] = max;
            	right_min[j] = min;
//                right_max[j] = Math.max(num, right_max[j - 1]);
//                right_min[j] = Math.min(num, right_min[j - 1]);
            }
        }
        right_max[size - 1] = right_min[size - 1] = nums.get(size - 1);
        System.out.println("left_max[17]: " + left_max[17]);
        System.out.println("right_min[18]: " + right_min[18]);
        int diff = 0;
        for(int i = 1; i < size; i++){
            diff = Math.max(diff, Math.abs(left_max[i - 1] - right_min[i]));
            diff = Math.max(diff, Math.abs(left_min[i - 1] - right_max[i]));
        }
        return diff;
    }
    
    public static int strStr(String source, String target) {
        //write your code here
        int t = 0;
        for(int s = 0; s < source.length(); s++){
            char S = source.charAt(s);
            char T = target.charAt(t);
            if(S == T){
                t++;
            }
            if(t == target.length()){
                return s - t + 1;
            }
        }
        return -1;
    }
    
    public enum Vsize {small, middle, large}
    
    public static int[] removeDup(int[] A){
    	int size = 1;
    	for(int i = 1; i < A.length; i++){
    		if(A[i] == A[i - 1]){
    			continue;
    		}
    		A[size++] = A[i];
    	}
    	return Arrays.copyOf(A, size);
    }
    
    public static int[] removeDup2(int[] A){
    	int size = 1;
    	int count = 1;
    	for(int i = 1; i < A.length; i++){
    		if(A[i] == A[i - 1]){
    			count++;
    			if(count > 2){
    				continue;
    			}
    			A[size++] = A[i];
    		}else{
    			A[size++] = A[i];
    			count = 1;
    		}
    	}
    	return Arrays.copyOf(A, size);
    }
    
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, Integer> map = buildTreeMap(start, end, dict);
        List<String> path = new ArrayList<String>();
        path.add(start);
        helper(result, path, start, end, map);
        return result;
    }
    
    private static HashMap<String, Integer> buildTreeMap(String start, String end, Set<String> dict){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        map.put(start, 0);
        while(!queue.isEmpty()){
            String cur = queue.poll();
//            if(cur.equals(end)){
//                continue;
//            }
            for(int i = 0; i < cur.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    if(c == cur.charAt(i)){
                        continue;
                    }
                    String s = replace(cur, i, c);
//                    if(s.equals(end)) System.out.println(s);
                    if(dict.contains(s) || s.equals(end)){
                        if(!map.containsKey(s)){
                            map.put(s, map.get(cur) + 1);
                            queue.add(s);
                        }
                    }
                }
            }
        }
        for(String s : map.keySet()){
        	System.out.println(s + " level: " + map.get(s));
        }
        return map;
    }
    
    private static void helper(List<List<String>> result, List<String> path, String start, String end, HashMap<String, Integer> map){
        if(start.equals(end)){
            result.add(new ArrayList<String>(path));
            return;
        }
        if(!map.containsKey(start)){
            return;
        }
        for(int i = 0; i < start.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == start.charAt(i)){
                    continue;
                }
                String s = replace(start, i, c);
                if(map.containsKey(s) && map.get(s) == map.get(start) + 1){
                    path.add(s);
                    helper(result, path, s, end, map);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
    
    private static String replace(String s, int i, char c){
        char[] chars = s.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
    
    
    
	public static void main(String args[]){
//		
//		int a = -7;
//		int b = (a >> 1);
//		System.out.println(b);
		
//		char c = '0';
//		System.out.println((int)c);
		StringBuilder sb = new StringBuilder();
		sb.append("123");
		sb.insert(sb.length() - 1, 4);
		System.out.println(sb.toString());
		
//		String version1 = "1";
//		String[] s1 = version1.split("\\.");
//		System.out.println(s1.length);
		
//		String[] set = {"hot","dog","dot"};
//		Set<String> dict = new HashSet<String>();
//		for(String s : set){
//			dict.add(s);
//		}
//		findLadders("hot", "dog", dict);
		
//		int a = 3;
//		int i = 0;
//		while(a > 0){
//			a &= (a - 1);
//			i++;
//		}
//		System.out.println(i);
//		String S = "abbbcdabcdefg";
//		String T = "bcd";
//		
//		System.out.println(strStr(S, T));
//		
//		BitSet bs = new BitSet();
		
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("123#####");
//		for(int i = sb.length() - 1; i >= 0; i--){
//			if(sb.charAt(i) != '#'){
//				System.out.println(i);
//				sb.setLength(i + 1);
//				System.out.println(sb.toString());
//				break;
//			}
//		}
//		ArrayList<Integer> list = new ArrayList<Integer>();
////		int[] test = {100,-2,-3,-100,-1,-50};
//		int[] test = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0};
//		for(int num : test){
//			list.add(num);
//		}
//		System.out.println(maxDiffSubArrays(list));
		
//		System.out.print(getDigitNumber(12));
//		System.out.println();
//		System.out.println(getDigit(8121, 4));

//		String s = "()()()";
//		if(isValid(s)){
//			System.out.print("Valid");
//		}else{
//			System.out.print("Invalid");
//		}
//		System.out.print(Math.abs(Integer.MIN_VALUE));
		
//		String s = "abc";
//		StringBuilder sb = new StringBuilder();
//		sb.append(s);
//		sb.deleteCharAt(2);
//		System.out.print(sb.toString());
		
//		Set<Character> hash = new HashSet<Character>();
//		Character.isWhitespace(' ');
//		
//		int[] num = new int[20];
//		java.util.Random myRandom = new java.util.Random();
//		for(int i = 0; i < num.length; i++){
//			num[i] = myRandom.nextInt(100);
//			System.out.print(num[i] + " ");
//		}
//		mergesort(num);
//		System.out.println();
//		System.out.println("Result: ");
//		for(int i : num){
//			System.out.print(i + " ");
//		}
//		int[] nums = {-2,2,-3,4,-1,2,1,-5,3};
//		System.out.println("Result: " + maximumSubarray(nums));
		
//		int a = 5;
//		System.out.print(~a + 1);
	}
}
