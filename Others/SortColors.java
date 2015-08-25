package Others;
/*Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 *with the colors in the order red, white and blue.
  Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
  Note:
	You are not suppose to use the library's sort function for this problem.*/
class SortColors {
	public void sortColors(int[] A) {
		if(A == null || A.length == 0){
			return;
		}
		
        int start = partition(A, 0, 0);
        partition(A, start, 1);
	}
	
    private int partition(int[] A, int start, int target){
        int end = A.length - 1;
        while(start < end){
            while(start < end && A[start] == target){
                start++;
            }
            while(start < end && A[end] != target){
                end--;
            }
            if(start < end){
                int tmp = A[start];
                A[start] = A[end];
                A[end] = tmp;
            }
        }
        return start;
    }
    
    /*One pass & constant space*/
    public void sortColors2(int[] A) {
    	/*low is red pointer & high is blue pointer*/
    	int low = 0, high = A.length - 1;
    	int i = 0;
    	while(i <= high){
    		if(A[i] == 2){
    			A[i] = A[high];
    			A[high--] = 2;
    		}else if(A[i] == 0){
    			A[i++] = A[low];
    			A[low++] = 0;
    		}else{
    			i++;
    		}
    	}
    }
}
