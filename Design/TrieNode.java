package Design;

import java.util.HashMap;

public class TrieNode {
	public boolean isEnd;
	public HashMap<Character, TrieNode> children;
	public char val;
	public int count = -1;
	
	public TrieNode(char v){
		this.val = v;
		children = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
}
