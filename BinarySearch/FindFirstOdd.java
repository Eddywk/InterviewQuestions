package BinarySearch;

class FindFirstOdd {
	public static int findFirstOdd(int[] num){
		int start = 0, end = num.length - 1;
		while(start <= end){
			int mid = start + (end - start) / 2;
			if(num[mid] % 2 == 0){
				start = mid + 1;
			}else{
				if(num[mid - 1] % 2 == 0 && mid == end){
					return mid;
				}
				if(num[mid - 1] % 2 == 0 && num[mid + 1] % 2 != 0){
					return mid;
				}
				end = mid;
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		int[] num = {2, 2, 2, 2, 1, 1, 1, 1};
		int[] num1 = {2,1,1,1,1,1,1};
		int[] num2 = {2,2,2,2,1};
//		int[] num3 = {2, 1, 2, 1, 2, 1};
		System.out.print(findFirstOdd(num2));
	}
}
