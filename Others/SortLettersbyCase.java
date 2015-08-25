package Others;
/*Given a string which contains only letters. Sort it by lower case first and upper case second.
  Note
	It's not necessary to keep the original order of lower-case letters and upper case letters.
  Example
	For "abAcD", a reasonable answer is "acbAD"*/
class SortLettersbyCase {
	public static void sortByCase(char[] seq){
		if(seq == null || seq.length == 0){
			return;
		}
		int start = 0, end = seq.length - 1;
		while(start <= end){
			while(start <= end && seq[start] >= 'a' && seq[start] <= 'z'){
				start++;
			}
			while(start <= end && seq[end] >= 'A' && seq[end] <= 'Z'){
				end--;
			}
			if(start <= end){
				char tmp = seq[start];
				seq[start] = seq[end];
				seq[end] = tmp;
			}
		}
	}
	
	public static void main(String args[]){
		String s = "abAcD";
		char[] chars = s.toCharArray();
		sortByCase(chars);
		System.out.println(new String(chars));
		
		String s1 = "eCaBabAcD";
		char[] chars1 = s1.toCharArray();
		sortByCase(chars1);
		System.out.println(new String(chars1));
	}
}
