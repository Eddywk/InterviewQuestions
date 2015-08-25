package ArrayandString;

class RotateString {
	public static String rotateString(String s, int offset){
		if(s == null || s.length() <= 1 || offset > s.length()){
			return s;
		}
		char[] chars = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = chars.length - offset; i < chars.length; i++){
//			System.out.println(chars[i]);
			sb.append(chars[i]);
		}
		for(int i = 0; i < chars.length - offset; i++){
//			System.out.println(chars[i]);
			sb.append(chars[i]);
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		String s = "abcdefg";
		s = rotateString(s, 6);
		System.out.println(s);
	}
}
