package GraphSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a set of candidate numbers (C) and a target number (T), 
 *find all unique combinations in C where the candidate numbers sums to T.
  Each number in C may only be used once in the combination.

	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 2,3,6,7 and target 7, 
	For example, given candidate set 10,1,6,7,2,1,5 and target 8,
	A solution set is: 
	[1,7]
	[1,2,5]
	[2,6]
	[1,1,6]*/
class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0){
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(result, list, num, target, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, 
        int[] num, int target, int pos){
        if(target == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }else if(target < 0){
            return;
        }
        /*Using prev pointer to skip duplicated calculation*/
        int prev = -1;
        for(int i = pos; i < num.length; i++){
            int cur = num[i];
            if(cur > target){
                break;
            }
            if(cur == prev){
                continue;
            }
            list.add(cur);
            helper(result, list, num, target - cur, i + 1);
            prev = cur;
            list.remove(list.size() - 1);
        }
    }
}
