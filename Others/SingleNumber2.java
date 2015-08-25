package Others;
/*Given an array of integers, every element appears three times except for one. Find that single one.
  Note:
  Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
class SingleNumber2 {
	public int singleNumber(int[] A) {
		/*count[i] means how many times 1 appears on bit i*/
		int[] count = new int[32];
		/*For each number of A, we see it as 32 bits binary number because its type is int
		 *So, after we traversed A, the count[i] must be multiple of 3 except the bits of 
		 *the number doesn't appear 3 times.*/
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < 32; j++){
				/*Count the bit number*/
				count[j] += (A[i] >> j) & 1;
				/*Reset count of bit if reach 3*/
				count[j] = count[j] % 3;
			}
		}
		int result = 0;
		/*Recovery the number we want*/
		for(int k = 0; k < 32; k++){
			result += (count[k] << k);
		}
		return result;
	}
}
