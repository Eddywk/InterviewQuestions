package ArrayandString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubstringPermutation {
	public static List<Integer> getSubstringPermutationIndex(String s, String target){
		List<Integer> result = new ArrayList<Integer>();
		int[] hash = new int[256];
		for(int i = 0; i < target.length(); i++){
			char c = target.charAt(i);
			hash[c]++;
		}
		int found = 0;
		for(int i = 0; i < s.length(); i++){
			char cur = s.charAt(i);
			if(hash[cur] == 0){
				continue;
			}
			int[] map = Arrays.copyOf(hash, hash.length);
			int start = i;
			for(int j = start; j < s.length() && j < i + target.length(); j++){
				char c = s.charAt(j);
				if(--map[c] >= 0){
					found++;
				}else{
					break;
				}
			}
			if(found == target.length()){
				result.add(start);
			}
			found = 0;
		}
		return result;
	}
	
	public static void main(String args[]){
		String s = "abcadcba";
		String target = "abc";
		List<Integer> result = getSubstringPermutationIndex(s, target);
		for(int i : result){
			System.out.print(i + " ");
		}
	}
}
