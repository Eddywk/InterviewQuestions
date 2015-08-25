package ArrayandString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
  For example, given:
	S: "barfoothefoobarman"
	L: ["foo", "bar"]
  You should return the indices: [0,9].
 	(order does not matter).*/
class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if(S == null || S.length() == 0 || L == null || L.length == 0){
            return result;
        }
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        //Count occurrence of words in L
        for(String s : L){
            if(hash.containsKey(s)){
                hash.put(s, hash.get(s) + 1);
            }else{
                hash.put(s, 1);
            }
        }
        int len = L[0].length();
        for(int i = 0; i <= S.length() - L.length * len; i++){
            HashMap<String, Integer> found = new HashMap<String, Integer>();
            int j;
            for(j = 0; j < L.length; j++){
                int k = i + j * len;
                String word = S.substring(k, k + len);
                /*Current word is not in L*/
                if(!hash.containsKey(word)){
                    break;
                }
                if(!found.containsKey(word)){
                    found.put(word, 1);
                }else{
                    found.put(word, found.get(word) + 1);
                }
                /*Count of current word appear more than in it appears in L*/
                if(found.get(word) > hash.get(word)){
                    break;
                }
            }
            if(j == L.length){
                result.add(i);
            }
        }
        return result;
    }
}
