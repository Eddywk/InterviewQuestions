package Others;
/*Write a program that will calculate the number of trailing zeros in a factorial of a given number
 *For Example:
 *	The factorial of 6 is 6*5*4*3*2*1 which is 720, so it has one zero, return 1*/
class TrailingZerosNFactorial {
	/*Idea: only the product of multiple of 5 with even numbers can generate 0 in trail,
	 * 		and in factorial we have enough even numbers, so only we need to do is find
	 * 		how many multiple of 5 in a factorial*/
	public static int findTrailingZero(int n){
		if(n < 0){
			return 0;
		}
		int count = 0;
		/*Keep find how many multiple of 5 in n*/
		for(long i = 5; n / i >= 1; i *= 5){
			count += n / i;
		}
		return count;
	}
	
	private static int getFactorial(int n){
		int factorial = 1;
		for(int i = 1; i <= n; i++){
			factorial *= i;
		}
		return factorial;
	}
	
	public static void main(String args[]){
		
		System.out.println("Factorial: " + getFactorial(5) + " | Count of 0: " + findTrailingZero(5));
		System.out.println("Factorial: " + getFactorial(7) + " | Count of 0: " + findTrailingZero(7));
		System.out.println("Factorial: " + getFactorial(10) + " | Count of 0: " + findTrailingZero(10));
	}
}
