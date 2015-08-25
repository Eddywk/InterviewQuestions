package GraphSearch;

import java.util.ArrayList;
import java.util.Arrays;

class Subsets {
	/*Given a set of distinct integers, S, return all possible subsets.

		Note:
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.
		For example,
		If S = [1,2,3], a solution is:		
		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
		]*/
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(S == null || S.length == 0){
			return result;
		}
		Arrays.sort(S);
		ArrayList<Integer> subset = new ArrayList<Integer>();
		helper(result, subset, S, 0);
		return result;
	}
	
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int[] s, int pos){
		result.add(new ArrayList<Integer>(subset));
		for(int i = pos; i < s.length; i++){
			subset.add(s[i]);
			helper(result, subset, s, i + 1);
			subset.remove(subset.size() - 1);
		}
	}
	
	/*Non-recursion subset*/
	public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(S == null || S.length == 0){
			return result;
		}
		Arrays.sort(S);
		result.add(new ArrayList<Integer>());
		for(int i = 0; i < S.length; i++){
			int size = result.size();
			for(int j = 0; j < size; j++){
				ArrayList<Integer> subset = new ArrayList<Integer>(result.get(j));
				subset.add(S[i]);
				result.add(subset);
			}
		}
		return result;
	}
}
