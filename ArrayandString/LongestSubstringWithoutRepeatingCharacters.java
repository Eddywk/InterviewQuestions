package ArrayandString;
/*Given a string, find the length of the longest substring without repeating characters. 
 *For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 *For "bbbbb" the longest substring is "b", with the length of 1.*/
class LongestSubstringWithoutRepeatingCharacters {
	/*Idea: Window string, two pointers*/
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0){
			return 0;
		}else if(s.length() == 1){
			return 1;
		}
		int max = 1;
		/*left pointer can move to next position when find repeating*/
		int left = 0;
		/*HashSet*/
		boolean[] flag = new boolean[256];
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(flag[c]){
				max = Math.max(max, i - left);
				for(int j = left; j < i; j++){
					if(s.charAt(j) == c){
						/*left move to previous repeating's next*/
						left = j + 1;
						break;
					}
					/*Reset flag*/
					flag[j] = false;
				}
			}else{
				flag[c] = true;
			}
		}
		/*Don't forget remaining substring*/
		return Math.max(max, s.length() - left);
	}
}
