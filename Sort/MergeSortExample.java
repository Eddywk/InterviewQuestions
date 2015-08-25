package Sort;

class MergeSortExample {
	
	static int cnt = 0;
	
	static void mergesort(int[] array){
		int[] helper = new int[array.length];
		mergesort(array, helper, 0,  array.length - 1);
	}
	
	static void mergesort(int[] array, int[] helper, int low, int high){
		if(low < high){
			int mid = low + (high - low) / 2;
			/*Sort left half*/
			mergesort(array, helper, low, mid);
			/*Sort right half*/
			mergesort(array, helper, mid + 1, high);
			/*Merge them*/
			merge(array, helper, low, mid, high);
		}
	}

	static void merge(int[] array, int[] helper, int low, int mid, int high){
		/*Copy entire array into helper*/
		for(int i = low; i <= high; i++){
			helper[i] = array[i];
		}
		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;
		/*Base case like [0, 0, 0] will skip the while loop
		 *It actually like,
		 *(1)Copy smaller number into its before position
		 *(2)Copy original larger number to after position from helper[] to array[]*/
		int num = 0;
//		while(helperLeft <= mid && helperRight <= high){
//			/*Step(1) finished here*/
//			if(helper[helperLeft] < helper[helperRight]){
//				array[current++] = helper[helperLeft++];
//			}else{
//				array[current++] = helper[helperRight++];
//			}
//		}
//		/*Step(2) finished here*/
//		int remaining = mid - helperLeft;
//		for(int i = 0; i <= remaining; i++){
//			array[current++] = helper[helperLeft++];
//		}
		
		while(helperLeft <= mid || helperRight <= high){
			if(helperLeft <= mid && helperRight <= high){
				if(helper[helperLeft] < helper[helperRight]){
					array[current++] = helper[helperLeft++];
					cnt += num;
				}else{
					array[current++] = helper[helperRight++];
					num++;
				}
			}else if(helperLeft <= mid){
				array[current++] = helper[helperLeft++];
				cnt += num;
			}else{
				array[current++] = helper[helperRight++];
				num++;
			}
		}
	}
	
	static void printArray(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String args[]){
		int[] num = new int[5];
		java.util.Random myRandom = new java.util.Random();
		for(int i = 0; i < num.length; i++){
			num[i] = myRandom.nextInt(100);
			System.out.print(num[i] + " ");
		}
		mergesort(num);
		System.out.println();
		System.out.println("Result: ");
		for(int i : num){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Unsorted Pairs: " + cnt);
	}
}
