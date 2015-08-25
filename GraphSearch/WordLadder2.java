package GraphSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WordLadder2 {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(dict == null || dict.size() == 0){
            return result;
        }
        HashMap<String, Integer> tree = buildMapTree(start, end, dict);
        ArrayList<String> path = new ArrayList<String>();
        helper(end, start, result, path, tree);
        return result;
    }
    
    //Obtain new string by change one letter
    private static String replace(String s, char c, int pos){
        char[] chars = s.toCharArray();
        chars[pos] = c;
        return new String(chars);
    }
    
    //Build a path tree by BFS
    private static HashMap<String, Integer> buildMapTree(String start, String end, Set<String> dict){
        HashMap<String, Integer> tree = new HashMap<String, Integer>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        tree.put(start, 0);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(cur.equals(end)){
                continue;
            }
            for(int i = 0; i < cur.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    if(cur.charAt(i) == c){
                        continue;
                    }
                    String newWord = replace(cur, c, i);
                    if(dict.contains(newWord) || newWord.equals(end)){
                        if(!tree.containsKey(newWord)){
                            tree.put(newWord, tree.get(cur) + 1);
                            queue.add(newWord);
                        }
                    }
                }
            }
        }
//        for(String s : tree.keySet()){
//        	System.out.println("Key: " + s + " level: " + tree.get(s));
//        }
        return tree;
    }
    
    //Get all result by DFS
    private static void helper(String start, String end, ArrayList<ArrayList<String>> result, ArrayList<String> path, 
        HashMap<String, Integer> tree){
        if(start.equals(end)){
            // path.add(start);
        	System.out.print("Path: ");
        	for(String s : path){
        		System.out.print(s + " ");
        	}
        	System.out.println();
        	System.out.println("-----------------------------");
//            Collections.reverse(path);
            result.add(new ArrayList<String>(path));
            return;
        }
        if(!tree.containsKey(start)){
            return;
        }
        int depth = tree.get(start);
        if(!path.contains(start)){
        	System.out.println("Add!!!! " + start);
            path.add(start);
        }
        // path.add(start);
        for(int i = 0; i < start.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(start.charAt(i) == c){
                    continue;
                }
                String newWord = replace(start, c, i);
                if(tree.containsKey(newWord) && tree.get(newWord) == depth - 1){
                	System.out.println("Current: " + start + " Added: " + newWord);
                	System.out.print("Path: ");
                	for(String s : path){
                		System.out.print(s + " ");
                	}
                	System.out.println();
                	System.out.println("-----------------------------");
                    path.add(newWord);
                    helper(newWord, end, result, path, tree);
                    System.out.println("Removed: " + path.get(path.size() - 1));
                    path.remove(path.size() - 1);
                }
            }
        }
        // path.remove(path.size() - 1);
    }
    
    public static void main(String args[]){
    	String start = "hot";
    	String end = "dog";
    	String[] words = {"hot","cog","dog","tot","hog","hop","pot","dot"};
    	Set<String> dict = new HashSet<String>();
    	for(String s : words){
    		dict.add(s);
    	}
    	ArrayList<ArrayList<String>> result = findLadders(start, end, dict);
    	for(int i = 0; i < result.size(); i++){
    		for(int j = 0; j < result.get(i).size(); j++){
    			System.out.print(result.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
    }
}
