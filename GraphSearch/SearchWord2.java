package GraphSearch;

import java.util.ArrayList;
import java.util.HashMap;

    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
class TrieNode{
    public char val;
    public boolean isEnd = false;
    public int added = 0;
    HashMap<Character, TrieNode> children;
    
    public TrieNode(char c){
        this.val = c;
        children = new HashMap<Character, TrieNode>();
    }
}

class SearchWord2{       
    public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        TrieNode root = buildTrie(words);
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String s : words){
            max = Math.max(max, s.length());
            min = Math.min(min, s.length());
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(!hasInitial(root, board[i][j])){
                    continue;
                }
                search(result, sb, board, root, visited, i, j, max, min);
            }
        }
        return result;
    }
    
    private static void addWord(TrieNode root, String word){
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!root.children.containsKey(c)){
                root.children.put(c, new TrieNode(c));
            }
            root = root.children.get(c);
            if(i == word.length() - 1){
                root.isEnd = true;
            }
        }
    }
    
    private static boolean containsWord(TrieNode root, String word){
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!root.children.containsKey(c)){
                return false;
            }
            root = root.children.get(c);
            if(i == word.length() - 1 && root.isEnd){
                root.added++;
                return root.added <= 1;
            }
        }
        return false;
    }
    
    private static TrieNode buildTrie(ArrayList<String> words){
        TrieNode root = new TrieNode('/');
        for(String word : words){
            addWord(root, word);
        }
        return root;
    }
    
    private static boolean hasInitial(TrieNode root, char c){
        return root.children.containsKey(c);
    }
    
    private static TrieNode getNodeByString(TrieNode root, String s){
        if(s == null || s.length() == 0){
            return root;
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!root.children.containsKey(c)){
                return null;
            }else{
                root = root.children.get(c);
            }
        }
        return root;
    }
    
    private static void search(ArrayList<String> result, StringBuilder sb, char[][] board,
        TrieNode root, boolean[][] visited, int i, int j, int max, int min){
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1){
            return;
        }
        if(visited[i][j]){
            return;
        }
        if(sb.length() > max){
            return;
        }
        TrieNode end = getNodeByString(root, sb.toString());
        if(end == null || !end.children.containsKey(board[i][j])){
            return;
        }
        sb.append(board[i][j]);
        if(sb.length() >= min && containsWord(root, sb.toString())){
            result.add(sb.toString());
        }
        visited[i][j] = true;
        search(result, sb, board, root, visited, i + 1, j, max, min);
        search(result, sb, board, root, visited, i - 1, j, max, min);
        search(result, sb, board, root, visited, i, j + 1, max, min);
        search(result, sb, board, root, visited, i, j - 1, max, min);
        visited[i][j] = false;
        sb.setLength(sb.length() - 1);
    }
    
    public static void main(String args[]){
    	String[] strs = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    	 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab"};
    	char[][] board = new char[strs.length][strs[0].length()];
    	for(int i = 0; i < strs.length; i++){
    		board[i] = strs[i].toCharArray();
    	}
    	String[] dict = {"baaaaaaaaaaaaa","a","aa","aaaa","aaaax","abaaabbaz"};
    	ArrayList<String> words = new ArrayList<String>();
    	for(String s : dict){
    		words.add(s);
    	}
    	ArrayList<String> result = wordSearchII(board, words);
    	for(String s : result){
    		System.out.print(s + " ");
    	}
    }
}



