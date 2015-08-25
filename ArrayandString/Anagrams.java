package ArrayandString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

/*Given an array of strings, return all groups of strings that are anagrams.
  Note: All inputs will be in lower-case.*/
class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();
		if(strs == null || strs.length == 0){
			return result;
		}
		HashMap<String, LinkedList<String>> hash = new HashMap<String, LinkedList<String>>();
		/*Using sorted strings as key in HashTable*/
		for(String s : strs){
			String key = sortString(s);
			if(!hash.containsKey(key)){
				hash.put(key, new LinkedList<String>());
			}
			/*Put all same anagrams into same linked list*/
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
		}
		/*For each linked list which size greater than 2, add its anagrams into result*/
		for(String key : hash.keySet()){
			LinkedList<String> list = hash.get(key);
			if(list.size() >= 2){
				for(String s : list){
					result.add(s);
				}
			}
		}
		return result;
	}
	
	/*Sort string as alphabetical order*/
	private String sortString(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
}
