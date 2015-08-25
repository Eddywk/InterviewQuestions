package DynamicProgramming;

class UniquePaths2 {
	/*Follow up for "Unique Paths":
	  Now consider if some obstacles are added to the grids. How many unique paths would there be?
	  An obstacle and empty space is marked as 1 and 0 respectively in the grid.

	  For example,
	  There is one obstacle in the middle of a 3x3 grid as illustrated below.
	
		[
		  [0,0,0],
		  [0,1,0],
		  [0,0,0]
		]
	  The total number of unique paths is 2.*/
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null){
			return 0;
		}
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		if(row == 0 || col == 0){
			return 0;
		}
		/*path[i][j] means the unique path number of point(i, j)*/
		int[][] path = new int[row][col];
		
		//Initialization
		/*If find an obstacle in an edge,
		 *then no need to initialize rest right points of the point in the edge,
		 *because direction are only right and down*/
		for(int i = 0; i < row; i++){
			if(obstacleGrid[i][0] != 1){
				path[i][0] = 1;
			}else{
				break;
			}
		}
		for(int i = 0; i < col; i++){
			if(obstacleGrid[0][i] != 1){
				path[0][i] = 1;
			}else{
				break;
			}
		}
		
		for(int i = 1; i < row; i++){
			for(int j = 1; j< col; j++){
				if(obstacleGrid[i][j] != 1){
					path[i][j] = path[i - 1][j] + path[i][j - 1];
				}else{
					path[i][j] = 0;
				}
			}
		}
		
		return path[row - 1][col - 1];
	}
}
