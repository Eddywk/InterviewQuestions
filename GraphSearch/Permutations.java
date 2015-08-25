package GraphSearch;

import java.util.ArrayList;

class Permutations {
	/*Given a collection of numbers, return all possible permutations.
		For example,
		[1,2,3] have the following permutations:
		[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].*/
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0){
			return result;
		}
		
		ArrayList<Integer> permutation = new ArrayList<Integer>();
		helper(permutation, result, num);
		
		return result;
	}
	
	/*Recursion Function*/
	private void helper(ArrayList<Integer> permutation, ArrayList<ArrayList<Integer>> result, int[] num){
		if(permutation.size() == num.length){
			result.add(new ArrayList<Integer>(permutation));
			return;
		}
		
		for(int i = 0; i < num.length; i++){
			if(!permutation.contains(num[i])){
				permutation.add(num[i]);
				helper(permutation, result, num);
				permutation.remove(permutation.size() - 1);
			}
		}
	}
}
