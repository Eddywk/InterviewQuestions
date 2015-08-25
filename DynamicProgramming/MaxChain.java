package DynamicProgramming;

import java.util.Arrays;
/*You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. 
 * A pair (c, d) can follow another pair (a, b) if b < c. 
 * Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs. 
 * For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }, 
 * then the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
*/
class MaxChain {
	/*DP version*/
	public static int maxChainDP(int[][] pair){
		if(!isValid(pair)){
			return 0;
		}
		/*f[i] means number of max chain that ended in element i*/
		int[] f = new int[pair.length];
		/*Initialization: at least 1 because every element can become max chain itself*/
		Arrays.fill(f, 1);
		/*DP*/
		for(int i = 0; i < pair.length; i++){
			for(int j = 0; j < i; j++){
				if(pair[i][0] > pair[j][1]){
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}
		/*Find max one*/
		int maxChain = Integer.MIN_VALUE;
		for(int i = 0; i < f.length; i++){
			if(f[i] > maxChain){
				maxChain = f[i];
			}
		}	
		return maxChain;
	}
	
	private static boolean isValid(int[][] a){
		if(a == null || a.length == 0){
			return false;
		}
		
		for(int i = 0; i < a.length; i++){
			if(a[i].length != 2 || a[i][0] >= a[i][1]){
				return false;
			}
		}
		return true;
	}
	
	/*Greedy version*/
	/*We can treat this problem as job scheduling problem,
	 *each pair represent a job, left number is start time and right number is deadline
	 *So, we can sort the array by deadline and maxChain means we must find max jobs without conflict*/
	public static int maxChainGreedy(int[][] pair){
		if(!isValid(pair)){
			return 0;
		}
		sortByDue(pair);
		int maxChain = Integer.MIN_VALUE;
		for(int i = 0; i < pair.length; i++){
			int maxLen = getMaxLength(pair, i);
			if(maxLen > maxChain){
				maxChain = maxLen;
			}
		}
		return maxChain;
	}
	
	/*Get maxChain that start at job pos*/
	private static int getMaxLength(int[][] pair, int pos){
		int maxLen = 1;
		int end = pair[pos][1];
		for(int i = pos; i < pair.length; i++){
			if(pair[i][0] > end){
				maxLen++;
				end = pair[i][1];
			}
		}
		return maxLen;
	}
	
	private static void sortByDue(int[][] pair){
		quicksort(pair, 0, pair.length - 1);
	}
	
	private static void quicksort(int[][] a, int low, int high){
		if(low < high){
			int i = low;
			int j = high;
			int key = a[low][1];
			while(i < j){
				while(i < j && a[j][1] >= key){
					j--;
				}
				if(i < j){
					swap(a, i, j);
					i++;
				}
				while(i < j && a[i][1] < key){
					i++;
				}
				if(i < j){
					swap(a, i, j);
					j--;
				}
			}
			quicksort(a, low, i - 1);
			quicksort(a, i + 1, high);
		}
	}
	
	private static void swap(int[][] a, int i, int j){
		int temp_left = a[i][0];
		int temp_right = a[i][1];
		a[i][0] = a[j][0];
		a[i][1] = a[j][1];
		a[j][0] = temp_left;
		a[j][1] = temp_right;
	}

	private static void test(){
		int[][] tc1 = {{5, 22}, {39, 60}, {15, 23}, {24, 40}, {50, 90}};
		int[][] tc2 = {{5, 24}, {39, 60}, {15, 28}, {24, 40}, {50, 90}};
		int[][] tc3 = {{5, 24}, {39, 60}, {15, 23}, {24, 40}, {50, 90}};
		int[][] tc4 = {{5, 24}, {39, 60}, {60, 61}, {61, 62}, {62, 90}};
		int[][] tc5 = {{5, 6}};
		int[][] tc6 = {{}};
		int[][] tc7 = {};
		int[][] tc8 = {{5, 6}, {3, 8}};
		int[][] tc9 = {{5, 24}, {27, 32}, {39, 60}, {34, 46} , {50, 90}};
		int[][] tc10 = {{0, 1}, {2, 3}, {4, 5}, {6, 7}};
		int[][] tc11 = {{1, 100},{5,24}, {15, 28}, {27, 40}, {39, 60} ,{50, 90}};
		System.out.println("Test for DP version:");
		if( maxChainDP(tc1) == 3){
			System.out.println("Test 1 Successed!");
		}else{
			System.out.println("Test 1 Failed!");
		}
		if( maxChainDP(tc2) == 2){
			System.out.println("Test 2 Successed!");
		}else{
			System.out.println("Test 2 Failed!");
		}
		if( maxChainDP(tc3) == 3){
			System.out.println("Test 3 Successed!");
		}else{
			System.out.println("Test 3 Failed!");
		}
		if( maxChainDP(tc4) == 3){
			System.out.println("Test 4 Successed!");
		}else{
			System.out.println("Test 4 Failed!");
		}
		if( maxChainDP(tc5) == 1){
			System.out.println("Test 5 Successed!");
		}else{
			System.out.println("Test 5 Failed!");
		}
		if( maxChainDP(tc6) == 0){
			System.out.println("Test 6 Successed!");
		}else{
			System.out.println("Test 6 Failed!");
		}
		if( maxChainDP(tc7) == 0){
			System.out.println("Test 7 Successed!");
		}else{
			System.out.println("Test 7 Failed!");
		}
		if( maxChainDP(tc8) == 1){
			System.out.println("Test 8 Successed!");
		}else{
			System.out.println("Test 8 Failed!");
		}
		if( maxChainDP(tc9) == 4){
			System.out.println("Test 9 Successed!");
		}else{
			System.out.println("Test 9 Failed!");
		}
		if( maxChainDP(tc10) == 4){
			System.out.println("Test 10 Successed!");
		}else{
			System.out.println("Test 10 Failed!");
		}
		if( maxChainDP(tc11) == 3){
			System.out.println("Test 11 Successed!");
		}else{
			System.out.println("Test 11 Failed!");
		}
		
		System.out.println("Test for Greedy version:");
		if( maxChainGreedy(tc1) == 3){
			System.out.println("Test 1 Successed!");
		}else{
			System.out.println("Test 1 Failed!");
		}
		if( maxChainGreedy(tc2) == 2){
			System.out.println("Test 2 Successed!");
		}else{
			System.out.println("Test 2 Failed!");
		}
		if( maxChainGreedy(tc3) == 3){
			System.out.println("Test 3 Successed!");
		}else{
			System.out.println("Test 3 Failed!");
		}
		if( maxChainGreedy(tc4) == 3){
			System.out.println("Test 4 Successed!");
		}else{
			System.out.println("Test 4 Failed!");
		}
		if( maxChainGreedy(tc5) == 1){
			System.out.println("Test 5 Successed!");
		}else{
			System.out.println("Test 5 Failed!");
		}
		if( maxChainGreedy(tc6) == 0){
			System.out.println("Test 6 Successed!");
		}else{
			System.out.println("Test 6 Failed!");
		}
		if( maxChainGreedy(tc7) == 0){
			System.out.println("Test 7 Successed!");
		}else{
			System.out.println("Test 7 Failed!");
		}
		if( maxChainGreedy(tc8) == 1){
			System.out.println("Test 8 Successed!");
		}else{
			System.out.println("Test 8 Failed!");
		}
		if( maxChainGreedy(tc9) == 4){
			System.out.println("Test 9 Successed!");
		}else{
			System.out.println("Test 9 Failed!");
		}
		if( maxChainGreedy(tc10) == 4){
			System.out.println("Test 10 Successed!");
		}else{
			System.out.println("Test 10 Failed!");
		}
		if( maxChainGreedy(tc11) == 3){
			System.out.println("Test 11 Successed!");
		}else{
			System.out.println("Test 11 Failed!");
		}
		
	}
	
	public static void main(String args[]){
		test();
	}
}
