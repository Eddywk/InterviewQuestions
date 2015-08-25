package Exercise;

class RotateWords {
	public static String rotateWords(String s){
		char[] c = s.toCharArray();
		int start = 0;
		int end = 0;
		for(int i = 0; i < c.length; i++){
			if(c[i] == ' ' || i == c.length - 1){
				end = i == c.length - 1 ? i : i - 1;
				reverse(c, start, end);
				end++;
				while(end < c.length && c[end] == ' '){
					end++;
				}
				start = end;
			}
		}
		reverse(c, 0, c.length - 1);
		return new String(c);
	}
	
	private static void reverse(char[] c, int start, int end){
		if(start >= end) return;
		while(start < end){
			char tmp = c[start];
			c[start++] = c[end];
			c[end--] = tmp;
		}
	}
	
	public static void main(String args[]){
		String s = "I am a student.";
		System.out.println(rotateWords(s));
	}
}
