package LinkedList;

/*Given an array, 
 *indexes  0 1 2 3 4
  values   3 2 1 4 0
  values are the next index of the jump 0 -> 3 -> 4 -> 0  1 -> 2 
  return if there are loops, if yes, get the max length of the loop possible*/
class MaximumCycle {
    public static int getMaximumCycleInArray(int[] A){
        if(A == null || A.length <= 1){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < A.length; i++){
            int slow = i, fast = i;
            int length = 0;
            while(isValid(A, A[fast]) && isValid(A, A[A[fast]])){
                slow = A[slow];
                fast = A[A[fast]];
                length++;
                if(slow == fast){
                	break;
                }
            }
            max = Math.max(max, length);
        }
        return max;
    }
    
    private static boolean isValid(int[] A, int index){
    	if(index < 0 || index >= A.length){
    		return false;
    	}
    	return true;
    }
    
    public static void main(String args[]){
    	int[] A = {3, 2, 1, 4, 0};
    	System.out.println(getMaximumCycleInArray(A));
    }
}
