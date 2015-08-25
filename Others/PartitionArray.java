package Others;
/*Given an array "a" of integers and an int "k", Partition the array (i.e move the elements in "a") such that
  - All elements < k are moved to the left
  - All elements >= k are moved to the right
  Return the partitioning Index, i.e the first index "i" a[i] >= k.*/
class PartitionArray {
	public static int partition(int[] a, int k){
		if(a == null || a.length == 0){
			return -1;
		}
		int left = 0, right = a.length - 1;
		while(left <= right){
			while(left <= right && a[left] < k){
				left++;
			}
			while(left <= right && a[right] >= k){
				right--;
			}		
			if(left <= right){
				int tmp = a[left];
				a[left] = a[right];
				a[right] = tmp;
			}
		}
		return left;
	}
	
	public static void print(int[] a){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < a.length; i++){
			sb.append(a[i]+" ");
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String args[]){
		int index;
		int[] tc1 = {4, 6, 5, 2, 3, 1};
		index = partition(tc1, 4);
		print(tc1);
		System.out.println(index);
		int[] tc2 = {9, 8, 5, 4, 2, 6, 7, 3, 1};
		index = partition(tc2, 5);
		print(tc2);
		System.out.println(index);
		
		int[] tc3 = {2, 1};
		index = partition(tc3, 2);
		print(tc3);
		System.out.println(index);
	}
}
