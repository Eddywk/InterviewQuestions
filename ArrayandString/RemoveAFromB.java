package ArrayandString;

class RemoveAFromB {
	public static String removeAfromB(String A, String B){
		if(A == null || A.length() == 0 || B == null || A.length() > B.length()){
			return null;
		}
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		for(int i = 0; i < b.length; i++){
			int j = 0;
			if(a[j] != b[i]){
				continue;
			}
			int k = i;
			while(j < a.length && k < b.length && b[k] == a[j]){
				j++;
				k++;
			}
			if(j == a.length){
				for(int m = i; m < k; m++){
					b[m] = ' ';
				}
				i = k - 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char c : b){
			if(c == ' '){
				continue;
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		String A = "ABC";
		String B = "AAABCABCDEABC";
		System.out.println(B);
		System.out.println(removeAfromB(A, B));
	}
}
