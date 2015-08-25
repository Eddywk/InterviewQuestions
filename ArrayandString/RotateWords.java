package ArrayandString;

/*Rotate Words List: I love you -> you love I*/
class RotateWords {
	public static String rotateWords(String words){
		if(words == null || words.length() <= 1){
			return words;
		}
		StringBuffer sb = new StringBuffer();
		int start, end = words.length();
		for(int i = words.length() - 1; i >= 0; i--){
			if(words.charAt(i) != ' '){
				continue;
			}
			start = i + 1;
			sb.append(words.substring(start, end) + " ");
			end = i;
		}
		/*Append rest left-most chars*/
		if(end > 0){
			sb.append(words.substring(0, end));
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		String s = " I love you";
		s = rotateWords(s);
		System.out.println(s);
	}
}
