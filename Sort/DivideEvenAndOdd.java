package Sort;

class DivideEvenAndOdd {
	/*Version1: partition, start & end pointer*/
	public static void divideByParity(int[] nums){
		if(nums == null || nums.length <= 1){
			return;
		}
		int i = 0, j = nums.length - 1;
		while(i < j){
			/*From right to left, find first odd*/
			while(i < j && nums[j] % 2 == 0){
				j--;
			}
			while(i < j && nums[i] % 2 != 0){
				i++;
			}
			if(i < j){
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++; j--;
			}
		}
	}
	
	/*Version2: fast & slow pointer
	 *fast point to next odd number.
	 *slow point to last odd number that we have set on the left.*/
	public static void divideByParity2(int[] nums){
		if(nums == null || nums.length <= 1){
			return;
		}
		int slow = -1;
		int fast = 0;
		for(; fast < nums.length; fast++){
			if(nums[fast] % 2 == 0){
				continue;
			}else{
				int tmp = nums[++slow];
				nums[slow] = nums[fast];
				nums[fast] = tmp;
			}
		}
	}
	
	public static void main(String args[]){
		int[] tc = {6, 5, 7, 2, 5, 6, 1, 42};
//		divideByParity(tc);
		divideByParity2(tc);
		for(int i = 0; i < tc.length; i++){
			System.out.println(tc[i]);
		}
	}
}
