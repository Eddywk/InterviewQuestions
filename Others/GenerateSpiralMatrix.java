package Others;

import ArrayandString.SpiralPrint;

class GenerateSpiralMatrix {
	public static int[][] getSpiralMatrix(int rows, int cols){
		int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int num = 1;
		int[][] result = new int[rows][cols];
		int x = 0, y = -1;
		int dir = 0;
		while(num <= rows * cols){
			int nextX = x + directions[dir][0];
			int nextY = y + directions[dir][1];
			if(nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && result[nextX][nextY] == 0){
				result[nextX][nextY] = num++;
				x = nextX;
				y = nextY;
			}else{
				dir++;
				dir %= 4;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		SpiralPrint sp = new SpiralPrint();
		sp.print(getSpiralMatrix(1, 1));
		System.out.println();
		sp.print(getSpiralMatrix(1, 2));
		System.out.println();
		sp.print(getSpiralMatrix(2, 1));
		System.out.println();
		sp.print(getSpiralMatrix(2, 2));
		System.out.println();
		sp.print(getSpiralMatrix(3, 2));
		System.out.println();
		sp.print(getSpiralMatrix(2, 3));
		System.out.println();
	}
}
