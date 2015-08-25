package DataStructure;

import java.util.Stack;
/*Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.*/
class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] height =  new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '0'){
                    height[i][j] = 0;
                }else{
                    height[i][j] = (i == 0) ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < height.length; i++){
            max = Math.max(max, largestRectangleArea(height[i]));
        }
        return max;
    }
    
    private static int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= height.length; i++){
            int cur = (i == height.length) ? -1 : height[i];
            while(!stack.isEmpty() && cur <= height[stack.peek()]){
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
    
    public static void main(String args[]){
    	char[][] h = {{'0'}};
    	System.out.println(maximalRectangle(h));
    }
}
