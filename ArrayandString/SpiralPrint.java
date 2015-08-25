package ArrayandString;

public class SpiralPrint {
	public static void print(int[][] matrix){
		if(matrix == null || matrix.length == 0){
			return;
		}
		int beginX = 0;
		int beginY = 0;
		int endX = matrix[0].length - 1; 
		int endY = matrix.length - 1;
		while(true){
			/*From left to right*/
			for(int i = beginX; i <= endX; i++){
				System.out.print(matrix[beginY][i] + " ");
			}
			if(++beginY > endY) break;
			/*From top to bottom*/
			for(int i = beginY; i <= endY; i++){
				System.out.print(matrix[i][endX] + " ");
			}
			if(beginX > --endX) break;
			/*From right to left*/
			for(int i = endX; i >= beginX; i--){
				System.out.print(matrix[endY][i] + " ");
			}
			if(beginY > -- endY) break;
			/*From bottom to top*/
			for(int i = endY; i >= beginY; i--){
				System.out.print(matrix[i][beginX] + " ");
			}
			if(++beginX > endX) break;
 		}
	}
	
	public static void main(String args[]){
		int[][] m = {
				{1, 2, 3},
				{8, 9, 4},
				{7, 6, 5}
		};
		print(m);
	}
}
