package ArrayandString;
/*Similar String: If two same length strings still equals to each other after removing one char.
 *Check if two strings are similar string.*/
class SimilarString {
	public static boolean isSimilarString(String a, String b){
		if(a.length() != b.length()){
			return false;
		}
		int diff = 0;
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		int len = A.length;
		int i = 0, j = 0;
		while(i < len || j < len){
			if(i == len){
				diff += len - j;
				break;
			}
			if(j == len){
				diff += len - i;
				break;
			}
			
			if(A[i] == B[j]){
				i++; j++;
			}else if(j + 1 < len && A[i] == B[j + 1]){
				j++;
				diff++;
			}else if(i + 1 < len && A[i + 1] == B[j]){
				i++;
				diff++;
			}else{
				i++; j++;
				diff += 2;
			}
		}
		return (diff == 2);
	}
	
	public static void main(String args[]){
		String s1 = "mabc"; String s2 = "emac";
		String s3 = "ab"; String s4 = "ea";
		String s5 = "hello"; String s6 = "gello";
		if(isSimilarString(s1, s2)){
			System.out.println("Yes!");
		}else{
			System.out.println("No...");
		}
	}
}
