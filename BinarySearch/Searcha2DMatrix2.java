package BinarySearch;
/*Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
  This matrix has the following properties:
    * Integers in each row are sorted from left to right.
    * Integers in each column are sorted from up to bottom.
    * No duplicate integers in each row or column.
	Example
	Consider the following matrix:	
	[
	
	    [1, 3, 5, 7],
	
	    [2, 4, 7, 8],
	
	    [3, 5, 9, 10]
	
	]
    Given target = 3, return 2.*/
class Searcha2DMatrix2 {
	/*Idea: Scan from left-bottom each time discard one row or one column*/
	public static int searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0){
			return 0;
		}
		int count = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int i = rows - 1;
		int j = 0;
		while(i >= 0 && j < cols){
			if(matrix[i][j] == target){
				count++;
				i--; j++;
			}else if(matrix[i][j] < target){
				j++;
			}else{
				i--;
			}
		}
		return count;
	}
	
	public static void main(String args[]){
		int[][] matrix = {
				{1, 3, 5, 7},
				{2, 4, 7, 8},
				{3, 5, 9, 10}
		};
		System.out.println(searchMatrix(matrix, 10));
	}
}
