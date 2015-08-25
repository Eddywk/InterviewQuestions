package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;

class SurroundedRegions {
    static int rows;
    static int cols;
    private static boolean[][] unfill;
    private static boolean[][] visited;
    public static void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        rows = board.length;
        cols = board[0].length;
        if(rows <= 2 || cols <= 2){
            return;
        }
        unfill = new boolean[rows][cols];
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            DFS(board, i , 0);
            DFS(board, i, cols - 1);
        }
        for(int j = 0; j < cols; j++){
            DFS(board, 0, j);
            DFS(board, rows - 1, j);
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'X' || unfill[i][j]){
                    continue;
                }
                board[i][j] = 'X';
            }
        }
    }
    
    private static void DFS(char[][] board, int i, int j){
        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || board[i][j] == 'X'){
            return;
        }
        visited[i][j] = true;
        unfill[i][j] = true;
        //top
        DFS(board, i - 1, j);
        //bottom
        DFS(board, i + 1, j);
        //left
        DFS(board, i, j - 1);
        //right
        DFS(board, i, j + 1);
    }
    
    static class Cell{
        int x;
        int y;
        public Cell(int i, int j){x = i; y = j;}
    }
    
    public static void solveByBFS(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        if(rows <= 2 || cols <= 2){
            return;
        }
        boolean[][] unfill = new boolean[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
        	for(int j = 0; j < cols; j++){
        		unfill[i][j] = false;
        		visited[i][j] = false;
        	}
        }
        Queue<Cell> queue = new LinkedList<Cell>();
        for(int i = 0; i < rows; i++){
            if(board[i][0] == '0'){
                queue.add(new Cell(i, 0));
            }
            if(board[i][cols - 1] == '0'){
                queue.add(new Cell(i, cols - 1));
            }
        }
        for(int j = 0; j < cols; j++){
            if(board[0][j] == '0'){
                queue.add(new Cell(0, j));
            }
            if(board[rows - 1][j] == '0'){
                queue.add(new Cell(rows - 1, j));
            }
        }
        while(!queue.isEmpty()){
            Cell c = queue.poll();
            int i = c.x;
            int j = c.y;
            unfill[i][j] = true;
            if(visited[i][j] || board[i][j] == 'X'){
                continue;
            }
            visited[i][j] = true;
            //top
            if(i - 1 >= 0){
                queue.add(new Cell(i - 1, j));
            }
            //bottom
            if(i + 1 < rows){
                queue.add(new Cell(i + 1, j));
            }
            //left
            if(j - 1 >= 0){
                queue.add(new Cell(i, j - 1));
            }
            //right
            if(j + 1 < cols){
                queue.add(new Cell(i, j + 1));
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'X' || unfill[i][j]){
                    continue;
                }
                board[i][j] = 'X';
            }
        }
    }
    
    private static void print(char[][] m){
    	for(int i = 0; i < m.length; i++){
    		for(int j = 0; j < m[0].length; j++){
    			System.out.print(m[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String args[]){
    	char[][] matrix = {{'0','0','0'}, {'0','0','0'}, {'0','0','0'}};
    	char[][] m = {
    			{'X', 'X', 'X', 'X', 'X'},
    			{'X', 'X', '0', 'X', 'X'},
    			{'X', '0', '0', '0', 'X'},
    			{'X', 'X', 'X', '0', 'X'},
    			{'X', '0', '0', 'X', '0'}
    	};
    	char[][] n = {{'0', '0'}, {'0', '0'}};
    	char[][] f = {{'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}};
    	print(f);
    	solveByBFS(f);
    	System.out.println("Result: ");
    	print(f);
    }
}
