package ArrayandString;

class CountWord {
	public static void countWord(char[] c){
		if(c == null || c.length == 0){
			return;
		}
		int index = 0;
		int i = 0;
		int count = 1;
		while(index < c.length && i < c.length - 1){
			char cur = c[i];
			char next = c[i + 1];
			if(cur != next){
				index++;
			}else{
				int j = i;
				while(j < c.length - 1 && c[j] == c[j + 1]){
					count++;
					j++;
				}
				c[index++] = cur;
				String num = "" + count;
				for(int k = 0; k < num.length(); k++){
					c[index++] = num.charAt(k);
				}
				i = j;
			}
			count = 1;
			i++;
		}
		while(index < c.length){
			c[index++] = ' ';
		}
		index = c.length - 1;
		boolean hasNumber = false;
		for(i = c.length - 1; i >= 0; i--){
			if(c[i] == ' '){
				continue;
			}
			if(c[i] >= '0' && c[i] <= '9'){
				c[index--] = c[i];
				hasNumber = true;
			}else if(c[i] >= 'a' && c[i] <= 'z' && hasNumber){
				c[index--] = c[i];
				hasNumber = false;
			}else{
				c[index--] = (char)(1 + '0');
				c[index--] = c[i];
			}
		}
		while(index >= 0){
			c[index--] = ' ';
		}
	}
	
	public static void main(String args[]){
		//String s = "messyyyaaaa";
		String s = "messsssssssssssssssssyyyaaaa";
		char[] letters = s.toCharArray();
		countWord(letters);
		System.out.println(new String(letters));
	}
}
