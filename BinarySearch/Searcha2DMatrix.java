package BinarySearch;
/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
  Integers in each row are sorted from left to right.
  The first integer of each row is greater than the last integer of the previous row.
  For example,
  Consider the following matrix:
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
  Given target = 3, return true.*/
class Searcha2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        //find row
        for(int i = 0; i < rows; i++){
            if(matrix[i][cols - 1] >= target){
                row = i;
                break;
            }
        }
        //find col
        int start = 0, end = cols - 1;
        int mid;
        System.out.println("S:" + start + " E: " + end);
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(matrix[row][mid] == target){
                return true;
            }
            if(matrix[row][mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(matrix[row][start] == target){
            return true;
        }
        if(matrix[row][end] == target){
            return true;
        }
        return false;
	}
	
	/*Better solution*/
	/*Idea: Treat 2D matrix as 1D one*/
	public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        /*end = rows * cols - 1, so we can get row by [mid / cols]
         *and get column by [mid % cols]*/
        int start = 0, end = rows * cols - 1;
        int mid;
        while(start <= end){
        	mid = start + (end - start) / 2;
        	int value = matrix[mid / cols][mid % cols];
        	if(value == target){
        		return true;
        	}else if(value < target){
        		start = mid + 1;
        	}else{
        		end = mid - 1;
        	}
        }
        return false;
	}
	
	public static void main(String args[]){
		int[][] matrix = {
				{-8,-7,-5,-3,-3,-1,1},
				{2,2,2,3,3,5,7},
				{8,9,11,11,13,15,17},
				{18,18,18,20,20,20,21},
				{23,24,26,26,26,27,27},
				{28,29,29,30,32,32,34}
		};
		if(searchMatrix(matrix, -5)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
}
