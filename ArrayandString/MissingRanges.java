package ArrayandString;

import java.util.ArrayList;
import java.util.List;
/*Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
  For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].*/
class MissingRanges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        String range = "";
        if(A == null || A.length == 0){
            range = lower != upper ? lower + "->" + upper : "" + lower;
            result.add(range);
            return result;
        }
        //lower to A[0]
        if(lower < A[0]){
            range = lower == A[0] - 1 ? "" + lower : lower + "->" + (A[0] - 1);
            result.add(range);
        }
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            int num = A[i];
            if(prev != Integer.MIN_VALUE){
                range = prev == num - 1 ? "" + prev : prev + "->" + (num - 1);
                result.add(range);
                prev = Integer.MIN_VALUE;
            }
            for(int j = i + 1; j < A.length; j++){
                if(A[j] != ++num){
                    if(prev == Integer.MIN_VALUE){
                        prev = num;
                        i = j - 1;
                        break;
                    }
                }
            }
        }
        //A[n - 1] to upper
        if(upper > A[A.length - 1]){
            range = upper == A[A.length - 1] + 1 ? "" + upper : (A[A.length - 1] + 1) + "->" + upper;
            result.add(range);
        }
        return result;
    }
}
