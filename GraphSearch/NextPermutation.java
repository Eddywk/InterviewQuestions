package GraphSearch;

class NextPermutation {
	/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
	  If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	  The replacement must be in-place, do not allocate extra memory.
	  Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
		1,2,3 -> 1,3,2
		3,2,1 -> 1,2,3
		1,1,5 -> 1,5,1*/
	public void nextPermutation(int[] num) {
		if(num == null || num.length == 0){
			return;
		}
		for(int i = num.length - 2; i >= 0; i--){
			/*Find an increasing sub array*/
			if(num[i + 1] > num[i]){
				int j;
				/*Scan from tail to head*/
				for(j = num.length - 1; j > i; j--){
					/*From right to left, find first number greater than num[i]*/
					if(num[j] > num[i]){
						break;
					}
				}
				/*Swap num[i] and num[j]*/
				swap(num, i, j);
				/*Why need reverse?
				 *For example, for [1, 4, 3, 2]
				 *When we find increasing pair[1, 4], now i = 0,
				 *After we finished swapping, it looks like [2, 4, 3, 1], it's not next permutation,
				 *the real next permutation is [2, 1, 3, 4], so we need reverse between i+1 and length - 1.
				 *Because after traversed outer loop, we know (i+1, length - 1) is an increasing order sub array!*/
				reverse(num, i + 1, num.length - 1);
				return;
			}
		}
		/*If the entire num[] is decreasing order like 4 3 2 1 so, its next permutation is 1 2 3 4*/
		reverse(num, 0, num.length - 1);
	}
	
	private void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private void reverse(int[] a, int start, int end){
		for(int i = start, j = end; i < j; i++, j--){
			swap(a, i, j);
		}
	}
}
