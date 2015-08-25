package ArrayandString;

import java.util.HashMap;
/*Given a string, find the length of the longest substring T that contains at most k distinct characters.
	For example, Given s = “eceba”, k = 2
	T is "ece" which its length is 3.
*/

class LongestSubstringwithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int size = 0;
        int max = 0;
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            int cnt = map.get(c);
            //Update count
            map.put(c, cnt + 1);
            //new element
            if(cnt == 0){
                size++;
                //Check if current size of window string is greater than k or not
                if(size > k){
                    max = Math.max(max, i - index);
                    while(index < s.length() && size > k){
                        char cur = s.charAt(index++);
                        //Decrease the count
                        map.put(cur, map.get(cur) - 1);
                        //If count == 0 means the character has been removed
                        if(map.get(cur) == 0){
                            size--;
                        }
                    }
                }
            }
        }
        max = Math.max(max, s.length() - index);
        return max;
	}
}
