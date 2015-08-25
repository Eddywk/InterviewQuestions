package ArrayandString;
/*Given two numbers represented as strings, return multiplication of the numbers as a string.
  Note: The numbers can be arbitrarily large and are non-negative.*/
class MultiplyStrings {
	public static String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int len3 = len1 + len2;
		/*No need to worry the length of num1 * num2 longer than len1 + len2,
		 *99 * 99 = 9801 still 4, 100 * 100 = 10000 become 5*/
		int[] num3 = new int[len3];
		int i, j, carry;
		/*Mock Multiplication*/
		for(i = len1 - 1; i >= 0; i--){
			/*New level reset carry*/
			carry = 0;
			for(j = len2 - 1; j >= 0; j--){
				/*Current value = carry + digit in corresponding position of last level + current product*/
				int product = carry + num3[i + j + 1] + 
				Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
				carry = product / 10;
				num3[i + j + 1] = product % 10;
			}
			/*j has already minus! Put last carry into next position*/
			num3[i + j + 1] = carry;
		}
		StringBuilder sb = new StringBuilder();
		i = 0;
		/*Remove 0 on the left of num3, BUT need to keep one!!!
		 *For example, 9999 * 0 = 0 we need keep one 0! So, i < len3 - 1*/
		while(i < len3 - 1 && num3[i] == 0) 
			i++;
		/*Insert digits into result*/
		while(i < len3){
			sb.append(num3[i++]);
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		String num1 = "99";
		String num2 = "99";
		System.out.print(multiply(num1, num2));
	}
}
