package GraphSearch;

import java.util.ArrayList;
import java.util.List;

class SubsetWithSizeK {
	public static List<List<Integer>> subsetSizeK(int n, int k){
		int[] nums = new int[n];
		int idx = 0;
		for(int i = 1; i <= n; i++){
			nums[idx++] = i;
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> subset = new ArrayList<Integer>();
		helper(result, subset, nums, k, 0);
		return result;
	}
	
	private static void helper(List<List<Integer>> result, List<Integer> subset, int[] nums, int k, int pos){
		if(subset.size() == k){
			result.add(new ArrayList<Integer>(subset));
			return;
		}
		for(int i = pos; i < nums.length; i++){
			subset.add(nums[i]);
			helper(result, subset, nums, k, i + 1);
			subset.remove(subset.size() - 1);
		}
	}
	
	public static void main(String[] args){
		List<List<Integer>> res = subsetSizeK(4, 2);
		for(List<Integer> list : res){
			for(int i : list){
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
