package DynamicProgramming;

class JumpGame2 {
	/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

	  Each element in the array represents your maximum jump length at that position.

	  Your goal is to reach the last index in the minimum number of jumps.

	  For example:
	  Given array A = [2,3,1,1,4]

	  The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1,
	  then 3 steps to the last index.)*/
	public int jump(int[] A) {
		int[] step = new int[A.length];
		step[0] = 0;
		for(int i = 1; i < A.length; i++){
			step[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i; j++){
				if(step[j] != Integer.MAX_VALUE && j + A[j] >= i){
					step[i] = step[j] + 1;
					break;
				}
			}
		}
		return step[A.length - 1];
	}
}
