package Sort;

/* Quick Sort:
 * Tips: Set a key to make all elements smaller than the key move to left of it,
 * 		 all elements greater than the key move to right of it, and do sort to 
 * 		 left sub-array and right one recursively to get final result.*/
class QuickSortExample {
	
	public static void quicksort(int[] a, int low, int high){
		/*Base case: only one element to be sorted, do nothing*/
		if(low < high){
			
			int i = low;
			int j = high;
			int key = a[low];
			/*If i == j stop sort, do another iteration*/
			while(i < j){				
				/*From right to left, find the first element in array
				 *that smaller than key*/
				while(i < j && a[j] >= key) 
					j--;
				/*Copy a[j] to a[i] and increase i*/
				if(i < j)
					a[i++] = a[j];					
				
				/*From left to right, find the first element in array
				 *that greater than key*/
				while(i < j && a[i] < key) 
					i++;
				/*Copy a[i] to a[j] and decrease j*/
				if(i < j)
					a[j--] = a[i];
				
				/*Assign the position of key value*/
				a[i] = key;
			}
			/*Recursion, sort left sub-array and right one*/
			quicksort(a, low, i - 1);
			quicksort(a, i + 1, high);
		}
	}
	
	/*Version 2*/
	private static void quickSort(int[] num){
		quickSort(num, 0, num.length - 1);
	}
	
	private static void quickSort(int[] num, int start, int end){
	     int index = partition(num, start, end);
	      if (start < index - 1)
	            quickSort(num, start, index - 1);
	      if (index < end)
	            quickSort(num, index, end);
	}
	
	private static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int pivot = arr[left];	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	            	swap(arr, i++, j--);
	            }
	      };
	      return i;
	}
	
	private static void swap(int[] num, int i, int j){
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	
	public static void printArray(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	public static void main(String args[]){
		int[] num = new int[10];
		java.util.Random myRandom = new java.util.Random();
		for(int i = 0; i < num.length; i++){
			num[i] = myRandom.nextInt(100);
//			System.out.print(num[i] + " ");
		}
		quicksort(num, 0, num.length - 1);
		for(int i : num){
			System.out.print(i + " ");
		}
	}
}
