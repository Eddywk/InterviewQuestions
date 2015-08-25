package ArrayandString;
/*Similar to Question [6. Reverse Words in a String], but with the following constraints:
  "The input string does not contain leading or trailing spaces and 
  the words are always separated by a single space."
  Could you do it in-place without allocating extra space?*/
class ReverseWordsinaString2 {
	public static void reverseWords(char[] s){
		reverse(s, 0, s.length - 1);
		for(int i = 0, j = 0; j <= s.length; j++){
			if(j == s.length || s[j] == ' '){
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}
	}
	
	private static void reverse(char[] s, int i, int j){
		while(i < j){
			char tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
			i++; j--;
		}
	}
	
	public static void main(String args[]){
		char[] s = "abc ca ef".toCharArray();
		reverseWords(s);
		System.out.println(new String(s));
	}
}
