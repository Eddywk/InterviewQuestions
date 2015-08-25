package Exercise;

import java.util.Arrays;
import java.util.Comparator;


class FindKthSmallestInRange {	
	
	private static class Data{
		int index;
		int val;
		public Data(int idx, int v){
			index = idx;
			val = v;
		}
	}
	
	static Comparator<Data> dataComparator = new Comparator<Data>(){

		@Override
		public int compare(Data o1, Data o2) {
			// TODO Auto-generated method stub
			return o1.val - o2.val;
		}
		
	};
	
	public static int findKthSmallest(int[] num, int k, int start, int end){
		Data[] arr = new Data[num.length];
		Arrays.sort(arr, dataComparator);
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++){
			if(arr[i].index >= start && arr[i].index <= end){
				k--;
				if(k == 0){
					res = arr[i].val;
					break;
				}
			}
		}
		return res;
	}
	
	
	public static void main(String args[]){
		int[] num = {1, 5, 2, 6, 3, 7, 4};
		System.out.println(findKthSmallest(num, 3, 3, 6));		
	}
}
