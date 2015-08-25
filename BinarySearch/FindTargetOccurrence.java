package BinarySearch;

class FindTargetOccurrence {
	public static int findTargetOccurrence(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int low = getBoundaryIndex(nums, target, true);
		int high = getBoundaryIndex(nums, target, false);
		int occurrence = high - low + 1;
		return occurrence = occurrence > 0 ? occurrence : 0;
	}
	
	private static int getBoundaryIndex(int[] nums, int target, boolean isUpper){
		int start = 0, end = nums.length - 1;
		int mid;
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			if(nums[mid] < target){
				start = mid;
			}else if(nums[mid] > target){
				end = mid;
			}else{
				if(isUpper){
					end = mid;
				}else{
					start = mid;
				}
			}
		}
		if(nums[start] == target){
			return start;
		}
		if(nums[end] == target){
			return end;
		}
		return -1;
	}
	
	public static void main(String args[]){
		int[] test = {1, 2, 3, 4, 4, 4, 4, 5, 6, 7};
		System.out.println(findTargetOccurrence(test, 4));
	}
}
