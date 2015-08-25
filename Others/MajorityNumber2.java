package Others;
/*Given an array of integers, the majority number is 
 *the number that occurs more than 1/3 of the size of the array.Find it.*/
class MajorityNumber2 {
	public static int majorityNumber(int[] nums) {
		if(nums == null || nums.length == 0){
			return -1;
		}
		int candidate1 = -1, candidate2 = -1;
		int count1 = 0, count2 = 0;
		for(int num : nums){
			if(candidate1 == num){
				count1++;
			}else if(candidate2 == num){
				count2++;
			}else if(count1 == 0){
				count1++;
				candidate1 = num; 
			}else if(count2 == 0){
				count2++;
				candidate2 = num;
			}else{
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		/*Find result from the two candidates*/
		for(int num : nums){
			if(num == candidate1){
				count1++;
			}
			else if(num == candidate2){
				count2++;
			}
		}
		int result = count1 > count2 ? candidate1 : candidate2; 
		return result;
	}
	
	public static void main(String args[]){
		int[] tc1 = {1};
		int[] tc2 = {1, 2, 2};
		int[] tc3 = {1, 2, 3, 4, 5, 6, 7, 7, 7, 7};
		System.out.println(majorityNumber(tc1));
		System.out.println(majorityNumber(tc2));
		System.out.println(majorityNumber(tc3));
	}
}
