package Others;

import java.util.Arrays;
/*Find number of pairs such that x^y > y^x

Given two arrays X[] and Y[] of positive integers, find number of pairs such that x^y > y^x where 
x is an element from X[] and y is an element from Y[].
Examples:
  Input: X[] = {2, 1, 6}, Y = {1, 5}
  Output: 3 
  	There are total 3 pairs where pow(x, y) is greater than pow(y, x)
  	Pairs are (2, 1), (2, 5) and (6, 1)


  Input: X[] = {10, 19, 18}, Y[] = {11, 15, 9};
  Output: 2
   	There are total 2 pairs where pow(x, y) is greater than pow(y, x)
  	Pairs are (10, 11) and (10, 15)*/
class NumberOfPairs {
	/*First we need to do some math shit
	 *x^y > y^x ==> ylogx > xlogy ==> logx / x > logy / y*/
	public static int findNumberOfPairs (int[] X, int[] Y) {
		if(X == null || Y == null || X.length == 0 || Y.length == 0){
			return -1;
		}
		/*Need to create a new array to store redesigned elements,
		 *because Math.log return double*/
		double[] x = new double[X.length];
		double[] y = new double[Y.length];
		for (int i = 0; i < X.length; i++) {
			x[i] = Math.log((double)X[i]) / X[i];
		}
		for (int i = 0; i < Y.length; i++) {
			y[i] = Math.log((double)Y[i]) / Y[i];
		}
		Arrays.sort(x);
		Arrays.sort(y);
		int index_b = 0;
		int result = 0;
		for(int i = 0; i < x.length; i++){
			int j;
		    for(j = index_b; j < y.length; j++){
		        if(y[j] < x[i]){
		        	result++;
		        	index_b = j;
		        }
		    }
		}
		return result;
	}
  
    public static void main(String args[]){
    	int[] x1 = {2, 1, 6}; int[] y1 = {1, 5};
    	int[] x2 = {10, 19, 18}; int[] y2 = {11, 15, 9};
    	int[] x3 = {1, 2, 3}; int[] y3 = {2, 3, 4};
    	int[] x4 = {2, 2, 3}; int[] y4 = {1, 2, 3};
    	int[] x5 = {1000, 2000, 3000}; int[] y5 = {1000, 2000, 3000};
    	
    	System.out.println(findNumberOfPairs(x1, y1));
    	System.out.println(findNumberOfPairs(x2, y2));
    	System.out.println(findNumberOfPairs(x3, y3));
    	System.out.println(findNumberOfPairs(x4, y4));
    	System.out.println(findNumberOfPairs(x5, y5));
    }
}
