package ArrayandString;
/*Given an input string, reverse the string word by word.
  For example,
  Given s = "the sky is blue",
  return "blue is sky the".

	Clarification:
	What constitutes a word?
	A sequence of non-space characters constitutes a word.
	Could the input string contain leading or trailing spaces?
	Yes. However, your reversed string should not contain leading or trailing spaces.
	How about multiple spaces between two words?
	Reduce them to a single space in the reversed string.*/
class ReverseWordsinaString {
	public static String reverseWords(String s) {
		if(s == null || s.length() == 0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		String[] words = s.split(" ");
		for(int i = words.length - 1; i >= 0; i--){
			/*words may contains "" if there are leading spaces*/
			if(!words[i].equals("")){
				sb.append(words[i]).append(" ");
			}
		}
		/*If only spaces in words, we should check it here*/
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
	
	/*Without using split function*/
	public static String reverseWords2(String s) {
		StringBuilder sb = new StringBuilder();
		int j = s.length();
		for(int i = s.length() - 1; i >= 0; i--){
			/*Skip white spaces*/
			if(s.charAt(i) == ' '){
				j = i;
			}
			/*i == 0 is edge case to prevent s.charAt(i - 1) out of boundary*/
			else if(i == 0 || s.charAt(i - 1) == ' '){
				/*Add white spaces between words*/
				if(sb.length() != 0){
					sb.append(' ');
				}
				sb.append(s.substring(i, j));
			}
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		String s = " I love you ";
		System.out.println(reverseWords2(s));
	}
}
