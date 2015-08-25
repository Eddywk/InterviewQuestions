package ArrayandString;

import java.util.ArrayList;

class MinimumSubsetDifference {
	public static int findMinimumDiff(int[] A){
		if(A == null || A.length == 0){
			return 0;
		}
		int sum = sum(A);
		int min = Integer.MAX_VALUE;
		ArrayList<ArrayList<Integer>> subsets = subset(A);
		for(int i = 0; i < subsets.size(); i++){
			int s1 = sum(subsets.get(i));
			int s2 = sum - s1;
			min = Math.min(min, Math.abs(s1 - s2));
		}
		return min;
	} 
	
	private static int sum(int[] A){
		int sum = 0;
		for(int i : A){
			sum += i;
		}
		return sum;
	}
	
	private static int sum(ArrayList<Integer> list){
		if(list.size() == 0){
			return 0;
		}
		int sum = 0;
		for(int i : list){
			sum += i;
		}
		return sum;
	}
	
	private static ArrayList<ArrayList<Integer>> subset(int[] A){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		for(int i = 0; i < A.length; i++){
			int size = result.size();
			for(int j = 0; j < size; j++){
				ArrayList<Integer> list = new ArrayList<Integer>(result.get(j));
				list.add(A[i]);
				result.add(list);
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		int[] S = {12,4,7,1,6,3,3};
		System.out.print(findMinimumDiff(S));
	}
}
