package DataStructure;

import java.util.Stack;
/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 *find the area of largest rectangle in the histogram.
 *For example,
  Given height = [2,1,5,6,2,3],
  return 10.*/
class LargestRectangleinHistogram {
	/*Idea: Using stack to store continuous increasing subset*/
    public static int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= height.length; i++){
            int cur = (i == height.length) ? -1 : height[i];
            /*Find a element smaller than the top of stack(increasing continuous subset stop)*/
            while(!stack.isEmpty() && cur <= height[stack.peek()]){
            	/*Compute area, area of current height of width = the range between current position to right-most 
            	 *of the continuous increasing subset in the stack*/
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
    
    public static void main(String args[]){
    	int[] height = {2,1,5,6,2,3};
    	System.out.println(largestRectangleArea(height));
    }
}
