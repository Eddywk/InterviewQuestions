package GraphSearch;

import java.util.ArrayList;
import java.util.Arrays;

class Subsets2 {
	/*Given a collection of integers that might contain duplicates, S, return all possible subsets.

		Note:
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.
		For example,
		If S = [1,2,2], a solution is:
		[
		  [2],
		  [1],
		  [1,2,2],
		  [2,2],
		  [1,2],
		  []
		]*/
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0){
			return result;
		}
		Arrays.sort(num);
		ArrayList<Integer> subset = new ArrayList<Integer>();
		helper(result, subset, num, 0);
		return result;
	}
	
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int[] num, int pos){
		result.add(new ArrayList<Integer>(subset));
		
		for(int i = pos; i < num.length; i++){
			/*Skip duplicated elements*/
			if(i != pos && num[i] == num[i - 1]){
				continue;
			}
			subset.add(num[i]);
			helper(result, subset, num, i + 1);
			subset.remove(subset.size() - 1);
		}
	}
}
