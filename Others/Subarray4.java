package Others;

import java.util.ArrayList;
import java.util.HashMap;

/*1.Find the subarray which sum equals to zero
 *2.Find the subarray which sum closest to zero*/
class Subarray4 {
	/*1.Using HashMap to store subarray which sum equals to zero*/
	/*1.Sort sum[] and compute adjacent two sums to find the one closest to zero*/
	public static ArrayList<int[]> findSumZero(int[] nums){
		/*Idea: we use sum array to solve sub-array problem.
		 *sum[i, j] = sum[j] - sum[i - 1] = 0,
		 *so, we can get sum[j] = sum[i - 1].
		 *we put sum[m] as key into HashTable and index as value
		 *if we can find any sum[k](k = i - 1) exist in HashTable,
		 *then we find the sub-array [k + 1, j] = 0*/
		if(nums == null || nums.length == 0){
			return null;
		}
		ArrayList<int[]> result = new ArrayList<int[]>();
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		/*Very important base case! sum[0] means sum of the 0th number
		 *not sum of 0 numbers, so we need to add base case sum[-1] = 0*/
		hs.put(0, -1);
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			if(!hs.containsKey(sum)){
				hs.put(sum, i);
			}else{
				int index1 = i < hs.get(sum) + 1 ? i : hs.get(sum) + 1;
				int index2 = i > hs.get(sum) + 1 ? i : hs.get(sum) + 1;
				int[] res = {index1, index2};
				if(!result.contains(res)){
					result.add(res);
				}
			}
		}
		return result;
	}
	
	private static void print(ArrayList<int[]> res){
		for(int i = 0; i < res.size(); i++){
			int[] cur = res.get(i);
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < cur.length; j++){
				sb.append(cur[j] + " ");
			}
			System.out.println(sb.toString());
		}
	}
	
	public static void main(String args[]){
		int[] testcase = {-2, 1, 0, -3, 4, -1, 2, 1, -5, 4};
		ArrayList<int[]> res = findSumZero(testcase);
		print(res);
	}
}
