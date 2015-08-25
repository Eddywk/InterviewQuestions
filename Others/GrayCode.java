package Others;

import java.util.ArrayList;

class GrayCode {
  /*The gray code is a binary numeral system where two successive values differ in only one bit.
	Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
	A gray code sequence must begin with 0.
	For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
			00 - 0
			01 - 1
			11 - 3
			10 - 2
	Note:
	For a given n, a gray code sequence is not uniquely defined.	
	For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.	
	For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.*/
	
	/*Idea: 
	 *For n = 1
	 *    0
	 *    1
	 *For n = 2
	 *	  00
	 *	  01
	 *	  11
	 *	  10
	 *We can get result of n = 2 by n = 1
	 *First reverse all number in result n = 1,
	 *    1
	 *    0
	 *Then, add one in front of these numbers
	 *    11
	 *    10
	 *Finally, add these new numbers in to result, done. 
	 **/
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(n < 0){
			return result;
		}
		result.add(0);
		for(int i = 0; i < n; i++){
			int size = result.size();
			for(int j = size - 1; j >= 0; j--){
				result.add(result.get(j) | (1 << i));
			}
		}	
		return result;
	}
}
