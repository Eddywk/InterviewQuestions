package GraphSearch;

import java.util.ArrayList;
/*The set [1,2,3,...,n] contains a total of n! unique permutations.
  By listing and labeling all of the permutations in order,
  We get the following sequence (ie, for n = 3):
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
    Given n and k, return the kth permutation sequence.
    Note: Given n will be between 1 and 9 inclusive.*/
class PermutationSequence {
    public static String getPermutation(int n, int k) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            set.add(i);
        }
        StringBuilder sb = new StringBuilder();
        helper(n, k, sb, set);
        return sb.toString();
    }
    
    private static int getFactorial(int n){
        int sum = 1;
        for(int i = 2; i <= n; i++){
            sum *= i;
        }
        return sum;
    }
    
    private static void helper(int n, int k, StringBuilder sb, ArrayList<Integer> set){
        if(n <= 0){
            return;
        }
        int num = getFactorial(n) / n;
        int i;
        for(i = 1; i <= n; i++){
            if(k <= i * num && k > (i - 1) * num){
                break;
            }
        }
        sb.append(set.get(i - 1));
        set.remove(i - 1);
        k -= (i - 1) * num;
        helper(n - 1, k, sb, set);
    }
    
    public static void main(String args[]){
    	System.out.println(getPermutation(4, 22));
    }
}
