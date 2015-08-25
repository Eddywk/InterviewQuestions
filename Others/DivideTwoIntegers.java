package Others;
/*Divide two integers without using multiplication, division and mod operator.*/
class DivideTwoIntegers {
	/*Idea: Using subtraction instead of division.
	 *Increasing divisor by left-shift until its value is closest to dividend,
	 *then check if dividend > divisor, if it does then we can add 2^k to result which k
	 *is the number of bit divisor has left shifted.
	 *Keep doing aforementioned process while k >= 0*/
	public static int divide(int dividend, int divisor) {
		int result = 0;
		/*If dividend is -2147483648, to avoid integer overflow,
		 we "minus" a divisor form it, and add result by 1*/
		if(dividend == Integer.MIN_VALUE){
			dividend += Math.abs(divisor);
			result++;
		}
		/*If divisor is -2147483648, return 0 if dividend is not -2147483648,
		 *else return 1.*/
		if(divisor == Integer.MIN_VALUE){
			return result;
		}
		/*Compare signed bit to decide result is negative or positive
		 *Notice! Using unsigned right-shift >>>!!!*/
		boolean isNegative = ((dividend ^ divisor) >>> 31) == 1;
		int bits = 0;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		/*Avoiding divisor overflow we make divisor <= (dividend >> 1),
		 *if we don't do this and dividend equals to 2147483647(Integer.MAX_VALUE),
		 *divisor always smaller than dividend because when it reach close to dividend
		 *it will overflow, like if divisor is 1, then 1 << n ---> 2147483648 which is overflow*/
		while(divisor <= (dividend >> 1)){
			divisor <<= 1;
			bits++;
		}
		/*Subtract dividend by divisor*/
		while(bits >= 0){
			if(dividend >= divisor){
				dividend -= divisor;
				result += (1 << bits);
			}
			divisor >>= 1;
			bits--;
		}
		return isNegative ? -result : result;
	}
	
	public static void main(String args[]){
		System.out.print(divide(10, -5));
	}
}
