package ArrayandString;
/*There is an array which we can assume the numbers in adjacent positions are different. 
 *and A[0] < A[1] && A[A.length - 2] > A[A.length - 1]. 
 *We consider a position P is a peak if A[P] > A[P-1] && A[P] > A[P+1]. Find a peak in this array.*/
class FindPeak {
	/*Following corner cases give better idea about the problem.
	  1) If input array is sorted in strictly increasing order, the last element is always a peak element. 
	     For example, 50 is peak element in {10, 20, 30, 40, 50}.
	  2) If input array is sorted in strictly decreasing order, the first element is always a peak element. 
	  	 100 is the peak element in {100, 80, 60, 50, 20}.
	  3) If all elements of input array are same, every element is a peak element.*/
	public static int findPeak(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}
		int start = 0, end = nums.length - 1;
		int mid;
		/*We just need to get one peak, so we can use binary search*/
		while(start <= end){
			mid = start + (end - start) / 2;
			/*Key return condition*/
			if((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1] )){
				return mid;
			}
			/*If mid - 1 greater than mid, then on the left must have a peak
			 *because even if the rest of left sub-array is incremental, the first element is a peak.*/
			else if(mid > 0 && nums[mid] < nums[mid - 1]){
				end = mid - 1;
			}
			/*If mid + 1 greater than mid, then on the right must have a peak
			 *because even if the rest of right sub-array is incremental, the last element is a peak.*/
			else{
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		int[] tc1 = {1, 3, 20, 4, 1, 0};
		int[] tc2 = {5, 10, 20, 15};
		int[] tc3 = {10, 20, 30, 40, 50};
		int[] tc4 = {100, 80, 60, 50, 20};
		int[] tc5 = {10, 20, 15, 2, 23, 90, 67};
		System.out.println("Test Case 1  Index: " + findPeak(tc1) + " Peak: " + tc1[findPeak(tc1)]);
		System.out.println("Test Case 2  Index: " + findPeak(tc2) + " Peak: " + tc2[findPeak(tc2)]);
		System.out.println("Test Case 3  Index: " + findPeak(tc3) + " Peak: " + tc3[findPeak(tc3)]);
		System.out.println("Test Case 4  Index: " + findPeak(tc4) + " Peak: " + tc4[findPeak(tc4)]);
		System.out.println("Test Case 5  Index: " + findPeak(tc5) + " Peak: " + tc5[findPeak(tc5)]);
	}
}
