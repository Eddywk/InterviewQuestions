package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WordLadder {
  /*Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
	
	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	
	For example,
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	
	Note:
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.*/
	public int ladderLength(String start, String end, Set<String> dict) {
		if(dict == null || dict.size() == 0){
			return 0;
		}
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int length = 1;
		while(!queue.isEmpty()){
			int count = queue.size();
			/*For each word in the queue*/
			for(int i = 0; i < count; i++){
				String cur = queue.poll();
				/*For each char in the word*/
				for(int j = 0; j< cur.length(); j++){
					/*Replace the char with a - z*/
					for(char c = 'a'; c <= 'z'; c++){
						/*If the char has already in the original word*/
						if(cur.charAt(j) == c){
							continue;
						}
						String tmp = replace(cur, c, j);
						/*Only return length if find end*/
						if(tmp.equals(end)){
							return length + 1;
						}
						/*Add tmp into queue and remove it from dict*/
						if(dict.contains(tmp)){
							/*Add it to queue to prepare scan from next word*/
							queue.offer(tmp);
							/*We need to remove next word in dict,
							 *because at next round we will scan from
							 *it, if we find the end return, else it prove
							 *cannot reach the end from this word directly.
							 *So, no worry to delete it.*/
							dict.remove(tmp);
						}
					}
				}
			}
			length++;
		}
		return 0;
		
	}
	
	private String replace(String s, char c, int pos){
		char[] chars = s.toCharArray();
		chars[pos] = c;
		return new String(chars);
	}
}
