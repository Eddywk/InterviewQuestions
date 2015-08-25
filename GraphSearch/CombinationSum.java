package GraphSearch;

import java.util.ArrayList;
import java.util.Arrays;

class CombinationSum {
	/*Given a set of candidate numbers (C) and a target number (T), 
	 *find all unique combinations in C where the candidate numbers sums to T.
	  The same repeated number may be chosen from C unlimited number of times.

		Note:
		All numbers (including target) will be positive integers.
		Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
		The solution set must not contain duplicate combinations.
		For example, given candidate set 2,3,6,7 and target 7, 
		A solution set is: 
		[7] 
		[2, 2, 3] */
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(candidates == null || candidates.length == 0){
			return result;
		}	
		Arrays.sort(candidates);
		ArrayList<Integer> c = new ArrayList<Integer>();
		helper(result, c, candidates, target, 0);
		return result;
	}
	
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combination, 
			int[] candidates, int target, int pos){
		if(target == 0){
			result.add(new ArrayList<Integer>(combination));
			return;
		}else if(target < 0){
			return;
		}
		/*To remove duplicated combination, we set pos*/
		for(int i = pos; i < candidates.length; i++){
			if(candidates[i] > target){
				break;
			}
			combination.add(candidates[i]);
			helper(result, combination, candidates, target - candidates[i], i);
			combination.remove(combination.size() - 1);
		}
	}
}
