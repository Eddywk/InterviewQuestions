package GraphSearch;

import java.util.ArrayList;

class Permutation2 {
	/*Given a collection of numbers that might contain duplicates, return all possible unique permutations.

		For example,
		[1,1,2] have the following unique permutations:
		[1,1,2], [1,2,1], and [2,1,1].*/
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0){
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];
		/*Sorting the array, so all duplicated number will be neighbors*/
		quickSort(num, 0, num.length);
		helper(list, result, num, visited);
		return result;
	}
	
	/*Quick Sort*/
	private void quickSort(int[] a, int low, int high){
		int i = low;
		int j = high;
		int key = a[low];
		while(i < j){
			while(i < j && a[j] >= key){
				j--;
			}
			if(i < j){
				a[i++] = a[j];
			}
			while(i < j && a[i] < key){
				a[j--] = a[i];
			}
			a[i] = key;
		}
		quickSort(a, low, i - 1);
		quickSort(a, i + 1, high);
	}
	
	/*Recursion*/
	private void helper(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, int[] num, boolean[] visited){
		/*Base*/
		if(list.size() == num.length){
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i = 0; i < num.length; i++){
			/*In these following cases we will skip:
			 *case 1: the number we have already visited
			 *case 2: last number == current one && last number was unvisited
			 *For Example:
			 *	In level 1: list{1(num[0])} visited{num[0]}
			 *		In level 2: list{1, 1(num[1])} visited{num[0], num[1]}
			 *						In level 3: list{1, 1(num[1]), 1(num[2])} visited{num[0], num[1], num[2]}
			 *									list{1, 1(num[1]), 2} visited{num[0], num[1], num[3]}
			 *									list{1, 1(num[1]), 3} visited{num[0], num[1], num[4]}
			 *					list{1, 1(num[2])} visited{num[0], num[1]}, we skip this because case 2
			 *					list{1, 2} visited{num[0], num[1], num[3]}
			 *					list{1, 3} visited{num[0], num[1], num[4]}
			 *					.......*/
			if(visited[i] || (i != 0 && num[i] == num[i - 1] && !visited[i - 1])){
				continue;
			}
			
			visited[i] = true;
			list.add(num[i]);
			helper(list, result, num, visited);
			/*Clear up all data to previous level*/
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
	
}
