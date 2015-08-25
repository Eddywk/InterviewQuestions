package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import Design.TrieNode;

class StringNode implements Comparable<StringNode>{
	String val;
	int count;
	TrieNode node;
	public StringNode(String v, TrieNode tn){
		this.val = v;
		this.node = tn;
		count = 1;
	}
	
	@Override
	public int compareTo(StringNode o) {
		// TODO Auto-generated method stub
		return this.count - o.count;
	}
	
}

class FindTopKWords {
	public static List<String> findTopKWords(List<String> dict, int k){
		List<String> result = new ArrayList<String>();
		Queue<StringNode> heap = new PriorityQueue<StringNode>(k);
//		HashMap<TrieNode, StringNode> map = new HashMap<TrieNode, StringNode>();
		TrieNode root = new TrieNode('/');
		for(String word : dict){
			TrieNode node = insertWord(root, word);
//			if(!map.containsKey(node)){
//				map.put(node, new StringNode(word, node));
//			}
			if(heap.size() < k){
				if(node.count == -1){
					node.count = 1;
					heap.add(new StringNode(word, node));
				}else{
					
				}
			}else{
				
			}
		}
		return result;
	}
	
	private static TrieNode insertWord(TrieNode root, String word){
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(!root.children.containsKey(c)){
				root.children.put(c, new TrieNode(c));
			}
			if(i == word.length() - 1){
				TrieNode leaf = root.children.get(c);
				if(!leaf.isEnd){
					leaf.isEnd = true;
				}
				leaf.count++;
				return leaf;
			}
			root = root.children.get(c);
		}
		return null;
	}
	
	private static boolean containsWord(TrieNode leaf){
		return leaf.isEnd;
	}
}
