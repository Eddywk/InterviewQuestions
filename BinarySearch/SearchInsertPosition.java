package BinarySearch;
/*Given a sorted array and a target value, return the index if the target is found. 
 *If not, return the index where it would be if it were inserted in order.
  You may assume no duplicates in the array.
  Here are few examples.
	[1,3,5,6], 5 -> 2
	[1,3,5,6], 2 -> 1
	[1,3,5,6], 7 -> 4
	[1,3,5,6], 0 -> 0*/
class SearchInsertPosition {
	public static int searchInsert(int[] A, int target) {
		if(A == null){
			return -1;
		}
		if(target < A[0]){
			return 0;
		}
		int start = 0, end = A.length - 1;
		int mid;
		/*Find the last number less than target*/
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			if(A[mid] == target){
				return mid;
			}else if(A[mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		if(A[end] == target){
			System.out.println("case 1");
			return end;
		}
		if(A[end] < target){
			System.out.println("case 2");
			return end + 1;
		}
		if(A[start] == target){
			System.out.println("case 3");
			return start;
		}
		System.out.println("case 4");
		return start + 1;
	}
	
	public static void main(String args[]){
		int[] tc = {1,3,5,6};
		System.out.println(searchInsert(tc, 5));
		System.out.println("-----------------");
		System.out.println(searchInsert(tc, 2));
		System.out.println("-----------------");
		System.out.println(searchInsert(tc, 7));
		System.out.println("-----------------");
		System.out.println(searchInsert(tc, 0));
		System.out.println("-----------------");
	}
}
