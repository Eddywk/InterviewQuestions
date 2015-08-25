package Others;

import java.util.ArrayList;

class Result{
	int num1;
	int num2;
}
/*Given an array of integers, every element appears twice except for two. Find the two singles.*/
class SingleNumber3 {
	/*Idea: XOR all numbers in A, then we can get xor of two single numbers.
	 *Next, we pick one one bit from xor randomly and record its position(last is fastest, OK),
	 *So, we make sure that the two single numbers have different bit in this position.
	 *So, we can divide all numbers in A into two arrays by the bit in this position.
	 *Finally, we use method of Single Number 1 to each array, we can get the two single numbers!*/
	public static Result singleNumber(int[] A) {
		if(A == null || A.length < 4){
			return null;
		}
		Result res = new Result();
		/*XOR all elements in A*/
		int xor = A[0];
		for(int i = 1; i < A.length; i++){
			xor = xor ^ A[i];
		}
		/*Find different last bit's position*/
		int pos = 0;
		while((xor & (1 << pos)) == 0){
			pos++;
		}
		/*Divide all numbers in A into two arrays by this bit*/
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		for(int i = 0; i < A.length; i++){
			if((A[i] & (1 << pos)) == 0){
				array1.add(A[i]);
			}else{
				array2.add(A[i]);
			}
		}
		/*XOR all numbers in each array to get result*/
		res.num1 = array1.get(0);
		for(int i = 1; i < array1.size(); i++){
			res.num1 = res.num1 ^ array1.get(i);
		}
		res.num2 = array2.get(0);
		for(int i = 1; i < array2.size(); i++){
			res.num2 = res.num2 ^ array2.get(i);
		}
		return res;
	}
	
	public static void main(String args[]){
		int[] tc1 = {2, 2, 1, 3};
		Result res1 = singleNumber(tc1);
		System.out.println("First Number is: " + res1.num1);
		System.out.println("Second Number is: " + res1.num2);
		
		int[] tc2 = {1, 2, 1, 2, 3, 7, 6, 5, 5, 6, 7, 8, 9, 8};
		Result res2 = singleNumber(tc2);
		System.out.println("First Number is: " + res2.num1);
		System.out.println("Second Number is: " + res2.num2);
	}
}
