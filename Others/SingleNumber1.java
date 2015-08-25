package Others;
/*Given an array of integers, every element appears twice except for one. Find that single one.
  Note:
  Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
class SingleNumber1 {
	/*Idea: XOR ^ operation
	 *For example: A = {3, 2, 2}
	 *    11 ^ 10 = 01
	 *    01 ^ 10 = 11(Single number = 3)
	 **/
	public int singleNumber(int[] A) {
		if(A.length < 3){
			return -1;
		}
		int current = A[0];
		for(int i = 1; i < A.length; i++){
			current = current ^ A[i];
		}
		return current;
	}
}
