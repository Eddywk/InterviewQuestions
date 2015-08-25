package DynamicProgramming;

class JumpGame {
	/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

	  Each element in the array represents your maximum jump length at that position.

	  Determine if you are able to reach the last index.

	  For example:
	  A = [2,3,1,1,4], return true.
		
	  A = [3,2,1,0,4], return false.*/
	public boolean canJump(int[] A) {
		/*can[i] means can reach the position index i of array*/
		boolean[] can = new boolean[A.length];
		/*Base case: we can start from start position 0*/
		can[0] = true;
		/*From left to right to see if we can reach position i*/
		for(int i = 1; i < A.length; i++){
			/*Traverse all positions j on the left of position i*/
			for(int j = 0; j < i; j++){
				/*If we can reach position j && at j max length allow us to pass i,
				 *then we can reach i*/
				if(can[j] && j+ A[j] >= i){
					can[i] = true;
					break;
				}
			}
		}
		/*Return if we can reach destination*/
		return can[A.length - 1];
	}
}
