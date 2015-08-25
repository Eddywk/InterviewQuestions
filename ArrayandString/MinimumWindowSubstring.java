package ArrayandString;
/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
	For example,
	S = "ADOBECODEBANC"
	T = "ABC"
  Minimum window is "BANC".
  Note:
  If there is no such window in S that covers all characters in T, return the empty string "".
  If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.*/
class MinimumWindowSubstring {
	/*Idea: Using hash to record occurrence of each char in T, and two pointers: start and i.
	 *		When we move i to a position that contains all characters of T ([start, i] contains T),
	 *	    we start to move start pointer like:
	 *			(1)S[start] does not belong to T --> start++
	 *			(2)S[start] belong to T but we skip it [start + 1, i] still contains T --> start++
	 *		If can not increase start pointer, record substring[start ,i] as temporary result.
	 *			--> start++ to find new window string.
	 *		Repeat aforementioned steps until find minimum one.*/
    public static String minWindow(String S, String T) {
    	int[] hashT = new int[200];
    	/*hashT record the occurrence of each char in T*/
    	for(int i = 0; i < T.length(); i++){
    		hashT[T.charAt(i)]++;
    	}
    	/*Two pointer: start and i*/
    	int start = 0, i = 0;
    	/*"found" to record current size of how many characters of T in S[start, i]*/
    	int found = 0;
    	int min = Integer.MAX_VALUE;
    	String result = "";
    	/*hashS record count of character of T appears in S*/
    	int[] hashS = new int[200];
    	for(i = start = 0; i < S.length(); i++){
    		char c = S.charAt(i); 
    		/*If the char exists in T*/
    		if(hashT[c] != 0){
    			if(++hashS[c] <= hashT[c]){
    				found++;
    			}
    			/*If S[start, i] contains T*/
    			if(found == T.length()){
    				while(start < i){
    					char cur = S.charAt(start);
    					if(hashT[cur] == 0 || --hashS[cur] >= hashT[cur]){
    						start++;
    					}else{
    						break;
    					}
    				}
    				/*Record current window string*/
    				if(i - start + 1 < min){
    					min = i - start + 1;
    					result = S.substring(start, i + 1);
    				}
    				/*Move to find next window string*/
    				found--;
    				start++;
    			}
    		}
    	}
        return min == Integer.MAX_VALUE ? "" : result;
    }
    
    public static void main(String args[]){
    	String S = "ADOBECODEBANC";
    	String T = "ABC";
    	System.out.println(minWindow(S, T));
    }
}
