package Others;

/*Given an array of integers, the majority number is the number that occurs 
 *more than half of the size of the array. Find it.*/
class MajorityNumber {
	public static int majorityNumber(int[] nums) {
		if(nums == null || nums.length == 0){
			return -1;
		}
		/*Record count of candidate number, 
		 *if it's 0 then change candidate
		 *else 
		 *	if candidate number != incoming number, counteract: count--
		 *  else candidate count++*/
		int candidate = -1, count = 0;
		for(int i = 0; i < nums.length; i++){
			if(count == 0){
				candidate = nums[i];
				count++;
			}else{
				if(candidate == nums[i]){
					count++;
				}else{
					count--;
				}
			}		
		}
		/*The one survived from counteracting is majority number*/
		return candidate;
	}
	
	public static void main(String args[]){
		int[] tc1 = {1};
		int[] tc2 = {2,1,2};
		int[] tc3 = {3,3,3,1,2};
		int[] tc4 = {1, 3, 1, 2, 1, 4};
		System.out.println(majorityNumber(tc1));
		System.out.println(majorityNumber(tc2));
		System.out.println(majorityNumber(tc3));
		System.out.println(majorityNumber(tc4));
	}
}
