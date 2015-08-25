package DataStructure;

import java.util.Stack;
/*Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 *compute how much water it is able to trap after raining.
  For example, 
  Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.*/
class TrappingRainWater {
	/*Idea: Using stack to store consecutive decreasing elevation*/
	public int trap(int[] A) {
		if(A == null || A.length <= 2){
			return 0;
		}
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int bottom = A[0];
		for(int i = 1; i < A.length; i++){
			if(A[i] < A[stack.peek()]){
				/*Update base bottom*/
				bottom = A[i];
				stack.push(i);
				continue;
			}
			/*Consecutive decreasing elevation stop*/
			while(!stack.isEmpty()){
				int cur = stack.peek();
				int width = i - cur - 1;
				int height = Math.min(A[cur], A[i]);
				result += width * (height - bottom);
				/*Fill in, update bottom*/
				bottom = height;
				/*Pop out all elevation have been filled in, 
				 *add new recent elevation when finished filling in*/
				if(A[cur] > A[i]){
					stack.push(i);
					break;
				}else{
					stack.pop();
				}
			}
			/*When stack is empty means all elevations have been filled in,
			 *so we set current elevation as a new start*/
			if(stack.isEmpty()){
				stack.push(i);
			}
		}
		return result;
	}
}
