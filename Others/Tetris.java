package Others;

class Tetris {
	public static void getNewTetris(char[][] board){
		if(board == null || board.length == 0){
			return;
		}
		int rows = board.length;
		int row = rows - 1;
		while(row >= 0 && !isAllUnmarked(board ,row)){
			if(isAllMarked(board, row)){
				setRowZero(board, row);
			}else{
				int temp = row + 1;
				if(temp == rows){
					row--;
					continue;
				}
				while(temp < rows && isAllUnmarked(board, temp)){
					temp++;
				}
				if(--temp < rows){
					moveTo(board, row, temp);
				}
//				System.out.println("Target row " + temp);
			}
			row--;
			//print(board);
		}
	}
	
	private static void setRowZero(char[][] board, int row){
		for(int j = 0; j < board[0].length; j++){
			board[row][j] = ' ';
		}
	}
	
	private static void moveTo(char[][] board, int cur, int target){
		if(!isAllUnmarked(board, target) || cur == target){
			return;
		}
		for(int j = 0; j < board[0].length; j++){
			if(board[cur][j] == ' '){
				continue;
			}
			board[target][j] = board[cur][j];
		}
		setRowZero(board, cur);
	}
	
	private static boolean isAllMarked(char[][] board, int row){
		for(int j = 0; j < board[0].length; j++){
			if(board[row][j] != 'X'){
				return false;
			}
		}
		return true;
	}
	
	private static boolean isAllUnmarked(char[][] board, int row){
		for(int j = 0; j < board[0].length; j++){
			if(board[row][j] != ' '){
				return false;
			}
		}
		return true;
	}
	
	private static void print(char[][] board){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------");
	}
	
	public static void main(String args[]){
		char[][] board = {
					{' ', ' ', ' ', ' ', ' '},
					{'X', 'X', 'X', 'X', 'X'},
					{'X', 'X', ' ', 'X', ' '},
					{'X', 'X', 'X', 'X', 'X'},
					{'X', ' ', 'X', ' ', 'X'},
					{'X', 'X', 'X', 'X', 'X'},
					{'X', 'X', 'X', 'X', 'X'}
				};
		print(board);
		getNewTetris(board);
		print(board);
	}
}
