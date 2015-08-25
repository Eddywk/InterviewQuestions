package DynamicProgramming;

import java.util.List;

class Triangle {
	/*Given a triangle, find the minimum path sum from top to bottom. 
	 *Each step you may move to adjacent numbers on the row below.
	 *[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	 ]
	 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).*/
	public int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();
		/*Error Checking*/
		if(row == 0) return 0;
		int[] minSum = new int[triangle.get(row - 1).size()];
		/*DP*/
		for(int i = row -1; i >= 0; i--){
			int col = triangle.get(i).size();
			for(int j = 0; j < col; j++){
				/*Base Case Initialization*/
				if(i == row - 1){
					minSum[j] = triangle.get(i).get(j);
					continue;
				}
				/*Each element's path sum equals its below row minimum of two adjacent elements*/
				minSum[j] = Math.min(minSum[j], minSum[j + 1]) + triangle.get(i).get(j);
			}
		}
		/*Return answer, top of triangle only has one element 0*/
		return minSum[0];
	}
}
