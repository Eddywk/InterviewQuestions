package GraphSearch;

import java.util.ArrayList;

class N_Queens {
	/*The n-queens puzzle is the problem of placing n queens on an nxn chessboard such that no two queens attack each other.
	 *Given an integer n, return all distinct solutions to the n-queens puzzle.
	  Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

		For example,
		There exist two distinct solutions to the 4-queens puzzle:
		[
		 [".Q..",  // Solution 1
		  "...Q",
		  "Q...",
		  "..Q."],
		
		 ["..Q.",  // Solution 2
		  "Q...",
		  "...Q",
		  ".Q.."]
		]*/
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		if(n <= 0){
			return result;
		}
		/*cols store the coordinates of each queen,
		 *index represents row, and value represents col*/
		ArrayList<Integer> cols = new ArrayList<Integer>();
		search(result, cols, n);
		return result;
	}
	
	private void search(ArrayList<String[]> result, ArrayList<Integer> cols, int n){
		if(cols.size() == n){
			result.add(drawChessboard(cols));
			return;
		}
		
		for(int i = 0; i < n; i++){
			if(!isOK(cols, i)){
				continue;
			}
			cols.add(i);
			search(result, cols, n);
			cols.remove(cols.size() - 1);
		}
	}
	
	/*Function to check if queen can be place at (row, col)*/
	private boolean isOK(ArrayList<Integer> cols, int col){
		int row = cols.size();
		/*For each grid x (i, cols.get(i)) we have already placed*/
		for(int i = 0; i < cols.size(); i++){
			/*x and (row, col) at same column*/
			if(cols.get(i) == col){
				return false;
			}
			/*(row, col) at the top-left or right-bottom of x
			 *For (i, j), its top-left is (i - 1, j -1) and its right-bottom is (i + 1, j + 1)
			 *So, the relationship is j - i == j - 1 - (i - 1), j - i == j + 1 - (i + 1)*/
			if(i - cols.get(i) == row - col){
				return false;
			}
			/*(row, col) at the top-right or left-bottom of x*/
			if(i + cols.get(i) == row + col){
				return false;
			}
		}
		return true;
	}
	
	private String[] drawChessboard(ArrayList<Integer> cols){
		String[] board = new String[cols.size()];
		for(int i = 0; i < board.length; i++){
			board[i] = "";
			for(int j = 0; j < board.length; j++){
				if(j == cols.get(i)){
					board[i] += "Q";
				}else{
					board[i] += ".";
				}
			}
		}
		return board;
	}
}
