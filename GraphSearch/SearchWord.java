package GraphSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SearchWord {
	
	private static boolean[][] visited;
	private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static List<String> searchWord(char[][] board, Set<String> dict){
		List<String> result = new ArrayList<String>();
		if(board == null || board.length == 0 || dict == null || dict.size() == 0){
			return result;
		}
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				StringBuilder sb = new StringBuilder();
				visited = new boolean[board.length][board[0].length];
				helper(result, sb, board, dict, i, j);
			}
		}
		return result;
	}
	
	private static void helper(List<String> result, StringBuilder sb,
			char[][] board, Set<String> dict, int i, int j){
		if(dict.contains(sb.toString()) && !result.contains(sb.toString())){
			System.out.println(sb.toString());
			result.add(new String(sb));
		}
		visited[i][j] = true;
		sb.append(board[i][j]);
		
		for(int k = 0; k < 8; k++){
			int x = dx[k] + i;
			int y = dy[k] + j;
			if(isValid(board, x, y)){
				helper(result, sb, board, dict, x , y);
				sb.deleteCharAt(sb.length() - 1);
				visited[x][y] = false;
			}
		}
	}
	
	private static boolean isValid(char[][] board, int i, int j){
		int rows = board.length;
		int cols = board[0].length;
		if(i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j]){
			return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		Set<String> dict = new HashSet<String>();
		char[][] board = {
				{'A', 'B', 'C', 'D'},
				{'E', 'F', 'G', 'H'},
				{'I', 'S', 'R', 'P'},
				{'Q', 'N', 'M', 'T'}
		};
		dict.add("ABCD");
		dict.add("AFRT");
		dict.add("DGSQ");
		dict.add("BFSN");
		dict.add("FGRS");
		dict.add("BCGRP");
		dict.add("BCGRPTMNQ");
		searchWord(board, dict);
	}
}
